//****************************************************************************************************
// PascalsTriangle.java
//
// COMP 1131 Assignment 5 Question 3 (Part 2: Pascal's Triangle Recursive Program Tester)
// This is a recursive program that determines and prints up to the Nth line of Pascal's triangle.
//****************************************************************************************************

import java.util.Scanner;

public class PT_Tester {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int rows, columns;
        PascalsTriangle pt;

        // welcomes user to program and prompts them asking how many lines of PT to
        // display
        System.out.println("Program that generates Pascal's Triangle!");

        System.out.println("How many lines would you like Pascal's Triangle to have?");
        rows = keyboard.nextInt();
        columns = rows;

        // intantiates new pascals triangle object and fills it's array
        pt = new PascalsTriangle(rows, columns);
        pt.fillarray(rows);

        // prints # of lines of pascals triangle reqeusted by user
        System.out.println("\nThe first " + rows + " lines of Pascal's triangle are: \n");
        System.out.println(pt);
    }
}
