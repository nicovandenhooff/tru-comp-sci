
/**
 * Sorting.Java
 * COMP 2231 Assignment 1: Part 1 and 2
 *
 * This class includes my answers to Assigment 1 Part 1 (shell sort) and Part 2 (more
 * efficient bubble sort).  The methods named "swap" and "bubbleSort" have been included
 * from the original "Sorting.Java" file, written by the authors of Java Foundations (all
 * other sorting algorithms were removed as they are not relevant in this assignment).
 * My answers to Part 1 and 2 of the assignment are included in the methods named
 * "shellSort" and "bubbleSort2", respectively.
 *
 * @author Nico Van den Hooff
 * @version 1.0
 */

import java.util.Arrays;

public class Sorting {
    /**
     * Swaps to elements in an array. Used by various sorting algorithms. (NOTE:
     * This method was written by the authors of Java Foundations)
     *
     * @param data   the array in which the elements are swapped
     * @param index1 the index of the first element to be swapped
     * @param index2 the index of the second element to be swapped
     */
    private static <T extends Comparable<T>> void swap(T[] data, int index1, int index2) {
        T temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }

    /**
     * Sorts the specified array of objects using a shell sort algorithm.
     *
     * @param data the array to be sorted
     */
    public static <T extends Comparable<T>> void shellSort(T[] data) {
        // initializes gap to array length / 2
        int gap = data.length / 2;

        // used to track if a swap is made in a pass
        boolean swapFlag;

        // outer while loop to iterate through each gap size > 0
        while (gap > 0) {
            swapFlag = true;

            // inner while loop to continue swapping elements with relevant
            // gap size until no swaps ocur
            while (swapFlag == true) {
                swapFlag = false;

                // inner for loop to compare array elements at each gap
                for (int s = 0; s < (data.length - gap); s++) {
                    // swaps elements being compared if first element is less than the second
                    if (data[s].compareTo(data[s + gap]) > 0) {
                        // prints out the elements being swapped
                        System.out.println("Swapping " + data[s] + " and " + data[s + gap]);

                        // swaps the elements
                        swap(data, s, s + gap);

                        // resets swapFlag and prints out the array after the swap
                        swapFlag = true;
                        System.out.println(Arrays.toString(data));
                    }
                }
            }
            // reduces the gap size by half
            gap = gap / 2;
        }
    }

    /**
     * Sorts the specified array of objects using a bubble sort algorithm. Modified
     * to include an output for each pass of the array.
     *
     * (NOTE: This method was originally written by the authors of Java Foundations)
     *
     * @param data the array to be sorted
     */
    public static <T extends Comparable<T>> void bubbleSort(T[] data) {
        int position, scan;
        int pass = 0; // to keep track of passes through array

        for (position = data.length - 1; position >= 0; position--) {
            // increment pass and print out pass number with array
            pass++;
            System.out.println("Pass " + pass + ": " + Arrays.toString(data));

            for (scan = 0; scan <= position - 1; scan++) {
                if (data[scan].compareTo(data[scan + 1]) > 0) {
                    swap(data, scan, scan + 1);
                }
            }
        }
    }

    /**
     * Sorts the specified array of objects using a modified bubble sort algorithm,
     * that stops as soon as the list is sorted.
     *
     * @param data the array to be sorted
     */
    public static <T extends Comparable<T>> void bubbleSort2(T[] data) {
        // starting position and pass counter
        int position = data.length - 1, pass = 0;

        // to determine if a swap is made on a given pass
        boolean swapFlag = true;

        // while loop that runs as long as a swap takes place and a valid
        // position in the array to scan exists
        while (swapFlag == true && position >= 0) {
            swapFlag = false;

            // increment pass and print out pass number with array
            pass++;
            System.out.println("Pass " + pass + ": " + Arrays.toString(data));

            // bubble sort
            for (int scan = 0; scan <= position - 1; scan++) {
                if (data[scan].compareTo(data[scan + 1]) > 0) {
                    // swaps elements and updates swapFlag to true
                    swap(data, scan, scan + 1);
                    swapFlag = true;
                }
            }

            // decrements position since largest value has bubbled up
            position--;
        }
    }
}
