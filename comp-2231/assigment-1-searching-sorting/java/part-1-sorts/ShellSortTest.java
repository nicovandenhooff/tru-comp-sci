
/**
 * ShellSortTest.Java
 * COMP 2231 Assignment 1: Part 1 Driver
 *
 * Test driver class to test the shellSort method in the Sorting class.  Test exhibits
 * include three Integer arrays.  Array 1 is the same array as given in Chapter 18, pg 667.
 * Array 2 and 3 are arrays of random integers with 10 and 20 values each, respectively.
 * Array 2 has random Integers in the range of 0 - 500.  Array 3 has integers in the range
 * of -500 to 500.
 *
 * @author Nico Van den Hooff
 * @version 1.0
 */

import java.util.*;

public class ShellSortTest {
    public static void main(String[] args) {
        Random generator = new Random();

        Integer[] array1 = { 9, 6, 8, 12, 3, 1, 7 }; // example array from textbook
        Integer[] array2 = new Integer[10]; // array of 10 Integers to randomly fill
        Integer[] array3 = new Integer[20]; // array of 20 Integers to randomly fill

        // randomly fill the second array with 10 integers between 0 and 500
        for (int i = 0; i < array2.length; i++) {
            int num = generator.nextInt(501);
            array2[i] = num;
        }

        // randomly fill the third array with 20 integers between -500 and 500
        // negative values are included to test how algorithm reacts to
        // them in addition to positive values
        for (int i = 0; i < array3.length; i++) {
            int num = generator.nextInt(1001) - 500;
            array3[i] = num;
        }

        // apply the shellsort algorithm to the first array and print results
        System.out.println("-------------------Test case 1-------------------");
        System.out.println("Original array: " + Arrays.toString(array1));
        Sorting.shellSort(array1);
        System.out.println("Sorted array: " + Arrays.toString(array1));
        System.out.println();

        // apply the shellsort algorithm to the second array and print results
        System.out.println("-------------------Test case 2-------------------");
        System.out.println("Original array: " + Arrays.toString(array2));
        Sorting.shellSort(array2);
        System.out.println("Sorted array: " + Arrays.toString(array2));
        System.out.println();

        // apply the shellsort algorithm to the third array and print results
        System.out.println("-------------------Test case 3-------------------");
        System.out.println("Original array: " + Arrays.toString(array3));
        Sorting.shellSort(array3);
        System.out.println("Sorted array: " + Arrays.toString(array3));
        System.out.println();
    }
}
