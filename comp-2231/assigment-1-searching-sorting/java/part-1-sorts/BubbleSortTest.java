
/**
 * BubbleSortTest.Java
 * COMP 2231 Assignment 1: Part 2 Driver
 *
 * Test driver class to test the bubbleSort2 method in the Sorting class.  Test exhibits
 * include two Integer arrays.  Array 1 contains 10 random Integers.  Array 2 is a sorted
 * array of numbers 1 through 10.  Compares and contrasts the original bubbleSort method
 * from the text with the improved bubbleSort2 method created for the assignment.
 *
 * @author Nico Van den Hooff
 * @version 1.0
 */

import java.util.*;

public class BubbleSortTest {
    public static void main(String[] args) {
        Random generator = new Random();

        // array of 10 Integers to randomly fill
        Integer[] array1 = new Integer[10];

        // sorted array of Integers 1 through 10
        Integer[] array2 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        // fill first array with random values
        for (int i = 0; i < array1.length; i++) {
            int num = generator.nextInt(501);
            array1[i] = num;
        }

        // create copies of both arrays above so that we can test both bubble
        // sort methods on the exact same values
        Integer[] array1copy = Arrays.copyOf(array1, 10);
        Integer[] array2copy = Arrays.copyOf(array2, 10);

        // first test case, array with random integers
        System.out.println("-------------------Test case 1-------------------");

        // test original bubble sort method on first array
        System.out.println("~~~~~~~~~~~~~Original Bubble Sort~~~~~~~~~~~~~~~~");
        System.out.println("Original array: " + Arrays.toString(array1));
        Sorting.bubbleSort(array1);
        System.out.println("Sorted array: " + Arrays.toString(array1));
        System.out.println();

        // test modified bubble sort method on first array
        System.out.println("~~~~~~~~~~~~~Modified Bubble Sort~~~~~~~~~~~~~~~~");
        System.out.println("Original array: " + Arrays.toString(array1copy));
        Sorting.bubbleSort2(array1copy);
        System.out.println("Sorted array: " + Arrays.toString(array1copy));
        System.out.println();

        // second test case, array with sorted integers
        System.out.println("-------------------Test case 2-------------------");

        // test original bubble sort method on second array
        System.out.println("~~~~~~~~~~~~~Original Bubble Sort~~~~~~~~~~~~~~~~");
        System.out.println("Original array: " + Arrays.toString(array2));
        Sorting.bubbleSort(array2);
        System.out.println("Sorted array: " + Arrays.toString(array2));
        System.out.println();

        // test modified bubble sort method on second array
        System.out.println("~~~~~~~~~~~~~Modified Bubble Sort~~~~~~~~~~~~~~~~");
        System.out.println("Original array: " + Arrays.toString(array2copy));
        Sorting.bubbleSort2(array2copy);
        System.out.println("Sorted array: " + Arrays.toString(array2copy));
        System.out.println();
    }
}
