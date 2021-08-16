import java.io.*;

/**
 * ActivityDecider.Java COMP 2231 Assignment 4: Part 1 Driver
 * 
 * Test driver class for the DecisionTree class. Demonstrates the use of a
 * binary decision tree to help a user decide what to do on a day off.
 * 
 * @author Nico Van den Hooff
 * @version 1.0
 */
public class ActivityDecider {
    /**
     * Asks questions of the user to determine the appropriate activity to
     * recommend.
     */
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("So, you don't know what to do today.");

        // create new decision tree with activity questions
        DecisionTree expert = new DecisionTree("activitytree.txt");

        // evaluate based on users inputs
        expert.evaluate();
    }
}
