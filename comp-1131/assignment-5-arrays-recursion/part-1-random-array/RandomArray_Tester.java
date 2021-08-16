//****************************************************************************************************
// RandomArray_Tester.java
//
// COMP 1131 Assignment 5 Question 1 (Part 2: RandomArray Test Driver)
// This is a test driver for the RandomArray Class created in Assignment 5 Question 1.
// It prompts the user for the size of the integer array they would like to create, and then outputs
// the array's contents, minimum value, maximum value and and average values.
//****************************************************************************************************

import java.util.Scanner;

public class RandomArray_Tester {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int size;

        System.out.println("Random Integer Array Generator\n");

        // prompts user for size of array
        System.out.print("How many values would you like the array to have?: ");

        // creates a new array with # of values specified by user
        size = keyboard.nextInt();
        RandomArray array = new RandomArray(size);

        // prints out array values, minimum, maximum, and average
        System.out.println("\nThe array values are: " + array);
        System.out.println("The minimum value is " + array.getMinimum());
        System.out.println("The maximum value is " + array.getMaximum());
        System.out.println("The average value is " + array.getAverage());
    }
}