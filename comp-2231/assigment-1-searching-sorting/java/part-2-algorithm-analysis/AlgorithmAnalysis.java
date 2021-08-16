
/**
 * AlgorithmAnalysis.Java
 * COMP 2231 Assignment 1: Part 3
 *
 * Class that contains modified versions of methods from the Sorting class.
 * Specifically, modified versions of the shellSort, bubbleSort, and bubbleSort2,
 * are within the class.  These methods have been updated with code to tally
 * the total number of comparisons between elements being sorted, the number
 * of swaps that occur in total, and and the execution time of each algorithm.
 * Certain parts of code that outputted the array have also been commented out to
 * simplfy the test output in the driver.
 *
 * @author Nico Van den Hooff
 * @version 1.0
 */

import java.util.Arrays;

public class AlgorithmAnalysis {
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
     * Sorts the specified array of objects using a shell sort algorithm. Updated to
     * include a tracker for comparisons, swaps and execution time.
     * 
     * @param data the array to be sorted
     */
    public static <T extends Comparable<T>> void shellSort(T[] data) {
        // start time
        double startTime = System.nanoTime();

        // comparison and swap counters
        int comparisons = 0, swaps = 0;

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
                    // increments comparison counter
                    comparisons++;

                    // swaps elements being compared if first element is less than the second
                    if (data[s].compareTo(data[s + gap]) > 0) {
                        // increments swap counter
                        swaps++;

                        // prints out the elements being swapped
                        // System.out.println("Swapping " + data[s] + " and " + data[s + gap]);

                        // swaps the elements
                        swap(data, s, s + gap);

                        // resets swapFlag and prints out the array after the swap
                        swapFlag = true;
                        // System.out.println(Arrays.toString(data));
                    }
                }
            }
            // reduces the gap size by half
            gap = gap / 2;
        }

        // ends timer and calculates time in milliseconds
        double endTime = System.nanoTime();
        double totalTime = (endTime - startTime) / 1000000;

        // System.out.println("The array is sorted");

        // reports comparisons, swaps, and total time
        System.out.println("Total comparisons made: " + comparisons);
        System.out.println("Total swaps made: " + swaps);
        System.out.println("Total execution time (ms): " + totalTime);
    }

    /**
     * Sorts the specified array of objects using a bubble sort algorithm. Updated
     * to include a tracker for comparisons, swaps and execution time.
     *
     * (NOTE: This method was originally written by the authors of Java Foundations)
     *
     * @param data the array to be sorted
     */
    public static <T extends Comparable<T>> void bubbleSort(T[] data) {
        // start time
        double startTime = System.nanoTime();

        // comparison and swap counters
        int comparisons = 0, swaps = 0;

        int position, scan;
        int pass = 0; // to keep track of passes through array

        for (position = data.length - 1; position >= 0; position--) {
            // increment pass and print out pass number with array
            // pass++;
            // System.out.println("Pass " + pass + ": " + Arrays.toString(data));

            for (scan = 0; scan <= position - 1; scan++) {
                // increments comparison counter
                comparisons++;
                if (data[scan].compareTo(data[scan + 1]) > 0) {
                    // increments swap counter
                    swaps++;

                    swap(data, scan, scan + 1);
                }
            }
        }

        // ends timer and calculates time in milliseconds
        double endTime = System.nanoTime();
        double totalTime = (endTime - startTime) / 1000000;

        // System.out.println("The array is sorted");

        // reports comparisons, swaps, and total time
        System.out.println("Total comparisons made: " + comparisons);
        System.out.println("Total swaps made: " + swaps);
        System.out.println("Total execution time (ms): " + totalTime);
    }

    /**
     * Sorts the specified array of objects using a modified bubble sort algorithm,
     * that stops as soon as the list is sorted. Updated to include a tracker for
     * comparisons, swaps and execution time.
     *
     * @param data the array to be sorted
     */
    public static <T extends Comparable<T>> void bubbleSort2(T[] data) {
        // start time
        double startTime = System.nanoTime();

        // comparison and swap counters
        int comparisons = 0, swaps = 0;

        // starting position and pass counter
        int position = data.length - 1, pass = 0;

        // to track current value scanned in array
        int scan;

        // to determine if a swap is made on a given pass
        boolean swapFlag = true;

        // while loop that runs as double as a swap takes place and a valid
        // position in the array to scan exists
        while (swapFlag == true && position >= 0) {
            swapFlag = false;

            // increment pass and print out pass number with array
            // pass++;
            // System.out.println("Pass " + pass + ": " + Arrays.toString(data));

            // bubble sort
            for (scan = 0; scan <= position - 1; scan++) {
                // increments comparison counter
                comparisons++;
                if (data[scan].compareTo(data[scan + 1]) > 0) {
                    // increments swap counter
                    swaps++;

                    // swaps elements and updates swapFlag to true
                    swap(data, scan, scan + 1);
                    swapFlag = true;
                }
            }

            // decrements position after bubble sort is finished
            position--;
        }

        // ends timer and calculates time in milliseconds
        double endTime = System.nanoTime();
        double totalTime = (endTime - startTime) / 1000000;

        // System.out.println("The array is sorted");

        // reports comparisons, swaps, and total time
        System.out.println("Total comparisons made: " + comparisons);
        System.out.println("Total swaps made: " + swaps);
        System.out.println("Total execution time (ms): " + totalTime);
    }
}
