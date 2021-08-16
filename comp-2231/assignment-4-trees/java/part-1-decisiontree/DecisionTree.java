import java.util.*;
import java.io.*;

/**
 * DecisionTree.Java COMP 2231 Assignment 4: Part 1
 * 
 * The DecisionTree class uses the LinkedBinaryTree class to implement a binary
 * decision tree. Tree elements are read from a given file and then the decision
 * tree can be evaluated based on user input using the evaluate method.
 * 
 * @author Nico Van den Hooff
 * @version 1.0
 */
public class DecisionTree {
    // binary decision tree
    private LinkedBinaryTree<String> tree;

    /**
     * Constructor: Builds the decision tree based on the contents of the given file
     *
     * @param filename the name of the input file
     * @throws FileNotFoundException if the input file is not found
     */
    public DecisionTree(String filename) throws FileNotFoundException {
        File inputFile = new File(filename); // input file that contains tree data
        Scanner scan = new Scanner(inputFile);

        int numberNodes = scan.nextInt(); // first line in file is # of nodes
        scan.nextLine();

        int root = 0, left, right; // to track nodes operating on

        // list of tree nodes
        List<LinkedBinaryTree<String>> nodes = new java.util.ArrayList<LinkedBinaryTree<String>>();

        // add nodes to node list
        for (int i = 0; i < numberNodes; i++)
            nodes.add(i, new LinkedBinaryTree<String>(scan.nextLine()));

        // build decision tree
        while (scan.hasNext()) {
            root = scan.nextInt();
            left = scan.nextInt();
            right = scan.nextInt();
            scan.nextLine();

            nodes.set(root, new LinkedBinaryTree<String>((nodes.get(root)).getRootElement(), nodes.get(left),
                    nodes.get(right)));
        }

        // set tree up
        tree = nodes.get(root);
    }

    /**
     * Follows the decision tree based on user responses to each question.
     */
    public void evaluate() {
        // decision tree
        LinkedBinaryTree<String> current = tree;
        Scanner scan = new Scanner(System.in);

        // prompt for user input and traverse tree as appropriate
        while (current.size() > 1) {
            System.out.println(current.getRootElement());
            if (scan.nextLine().equalsIgnoreCase("N"))
                current = current.getLeft();
            else
                current = current.getRight();
        }

        // print final leaf based on above
        System.out.println(current.getRootElement());
    }
}