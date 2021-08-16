/**
 * LinkedBinarySearchTreeTest.Java COMP 2231 Assignment 4: Part 2 Driver
 *
 * Test driver class for the LinkedBinarySearchTree class.
 *
 * @author Nico Van den Hooff
 * @version 1.0
 */
public class LinkedBinarySearchTreeTest {
    public static void main(String[] args) {
        // create three trees to test
        LinkedBinarySearchTree<Integer> tree1 = new LinkedBinarySearchTree<Integer>();
        LinkedBinarySearchTree<Integer> tree2 = new LinkedBinarySearchTree<Integer>();
        LinkedBinarySearchTree<Integer> tree3 = new LinkedBinarySearchTree<Integer>();

        // create array of values to fill trees with
        int[] tree1nodes = { 3, 5, 9, 12, 18, 20 };
        int[] tree2nodes = { 100, 75, 44, 27, 17, 7, 6, 4, 1 };

        // fill tree 1 with values
        for (int i = 0; i < tree1nodes.length; i++)
            tree1.addElement(tree1nodes[i]);

        // fill tree 2 with values
        for (int i = 0; i < tree2nodes.length; i++)
            tree2.addElement(tree2nodes[i]);

        // add single value to tree3
        tree3.addElement(0);

        System.out.println("------------Test case 1: Degenerate Tree 1------------");

        // print height of tree 1, balance tree, then print height again
        System.out.println("Height of tree before balancing: " + tree1.getHeight());
        tree1.balanceTree();
        System.out.println("Height of tree after balancing: " + tree1.getHeight());

        // add some elements to balanced tree 1, causing it to become a degenerate tree
        tree1.addElement(30);
        tree1.addElement(40);
        tree1.addElement(50);
        tree1.addElement(60);

        // print new height of tree 1, rebalance tree, then print height again
        System.out.println("Height of tree after insertions: " + tree1.getHeight());
        tree1.balanceTree();
        System.out.println("Height of tree after rebalancing: " + tree1.getHeight());

        // output tree contents and test other methods completed for assignment 4
        System.out.println("Tree contents: \n" + tree1);
        System.out.println("Minimum value: " + tree1.findMin());
        System.out.println("Maximum value: " + tree1.findMax());
        System.out.println("Left root subtree: \n" + tree1.getLeft());
        System.out.println("Right root subtree: \n" + tree1.getRight());

        // test removeMax method completed for assingment 4
        tree1.removeMax();
        System.out.println("Tree contents after removal to max value: \n" + tree1);

        System.out.println("------------Test case 2: Degenerate Tree 2------------");

        // print height of tree 2, balance tree, then print height again
        System.out.println("Height of tree before balancing: " + tree2.getHeight());
        tree2.balanceTree();
        System.out.println("Height of tree after balancing: " + tree2.getHeight());

        // add some elements to balanced tree 2, causing it to become a degenerate tree
        tree2.addElement(200);
        tree2.addElement(300);
        tree2.addElement(500);
        tree2.addElement(700);

        // print new height of tree 2, rebalance tree, then print height again
        System.out.println("Height of tree after insertions: " + tree2.getHeight());
        tree2.balanceTree();
        System.out.println("Height of tree after rebalancing: " + tree2.getHeight());

        // output tree contents and test other methods completed for assignment 4
        System.out.println("Tree contents: \n" + tree2);
        System.out.println("Minimum value: " + tree2.findMin());
        System.out.println("Maximum value: " + tree2.findMax());
        System.out.println("Left root subtree: \n" + tree2.getLeft());
        System.out.println("Right root subtree: \n" + tree2.getRight());

        // test removeMax method completed for assingment 4
        tree2.removeMax();
        System.out.println("Tree contents after removal to max value: \n" + tree2);

        System.out.println("------------Test case 3: Edge Cases for Methods------------");

        // test methods implemented on a tree with a single root, value = 0
        System.out.println("Tree contents: \n" + tree3);
        System.out.println("Minimum value: " + tree3.findMin());
        System.out.println("Maximum value: " + tree3.findMax());
        System.out.println("Left root subtree: \n" + tree3.getLeft());
        System.out.println("Right root subtree: \n" + tree3.getRight());
    }
}
