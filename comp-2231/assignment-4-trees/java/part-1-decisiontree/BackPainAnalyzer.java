import java.io.*;

/**
 * BackPainAnalyzer.Java
 * COMP 2231 Assignment 4: Part 1 Driver
 * 
 * Test driver class for the DecisionTree class.  Demonstrates the use 
 * of a binary decision tree to diagnose back pain.
 * 
 * @author Nico Van den Hooff 
 * @version 1.0
 */
/**
 * BackPainAnaylyzer
 */
public class BackPainAnalyzer {
    /**
     * Asks questions of the user to diagnose a medical problem.
     */
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("So, you're having back pain.");

        // create new decision tree with backpain questions
        DecisionTree expert = new DecisionTree("input.txt");

        // evaluate based on users inputs
        expert.evaluate();
    }
}
