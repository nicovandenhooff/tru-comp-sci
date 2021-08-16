
/**
 * AlgorithmAnalysisTest.Java
 * COMP 2231 Assignment 1: Part 3 Driver
 *
 * Test driver class for the modified methods in the AlgorithmAnalysis class, which
 * have been updated to count and output the number of comparisons, swaps, and execution
 * time for each sorting method.  Tests each algorithm on an array of 10, 100, and 1000
 * Integers.  For each array, each of the three algorithms (shell, bubble, modified bubble)
 * is ran first on the unsorted random array, and then again on the same array which is then
 * already sorted.
 *
 * @author Nico Van den Hooff
 * @version 1.0
 */

import java.util.*;

public class AlgorithmAnalysisTest {
    public static void main(String[] args) {
        Random generator = new Random();

        // arrays to be filled with random Integers
        Integer[] array1 = new Integer[10];
        Integer[] array2 = new Integer[100];
        Integer[] array3 = new Integer[1000];

        // three for loops to fill the above arrays with random values between 0-10000
        for (int i = 0; i < array1.length; i++) {
            int num = generator.nextInt(10001);
            array1[i] = num;
        }

        for (int i = 0; i < array2.length; i++) {
            int num = generator.nextInt(10001);
            array2[i] = num;
        }

        for (int i = 0; i < array3.length; i++) {
            int num = generator.nextInt(10001);
            array3[i] = num;
        }

        // takes two copies of each array so that we can test all three algorithms
        // on the exact same values
        Integer[] array1copy1 = Arrays.copyOf(array1, 10);
        Integer[] array1copy2 = Arrays.copyOf(array1, 10);
        Integer[] array2copy1 = Arrays.copyOf(array2, 100);
        Integer[] array2copy2 = Arrays.copyOf(array2, 100);
        Integer[] array3copy1 = Arrays.copyOf(array3, 1000);
        Integer[] array3copy2 = Arrays.copyOf(array3, 1000);

        // first test on array with 10 elements
        System.out.println("-------------------Test case 1-------------------");
        System.out.println("-------------Array with 10 elements--------------");

        // shell sort results
        System.out.println("~~~~~~~~~~~~~~~~~~~Shell Sort~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Unsorted array results:");
        AlgorithmAnalysis.shellSort(array1);
        System.out.println();

        System.out.println("Sorted array results:");
        AlgorithmAnalysis.shellSort(array1);
        System.out.println();

        // original bubble sort results
        System.out.println("~~~~~~~~~~~~~Original Bubble Sort~~~~~~~~~~~~~~~~");
        System.out.println("Unsorted array results:");
        AlgorithmAnalysis.bubbleSort(array1copy1);
        System.out.println();

        System.out.println("Sorted array results:");
        AlgorithmAnalysis.bubbleSort(array1copy1);
        System.out.println();

        // modified bubble sort results
        System.out.println("~~~~~~~~~~~~~Modified Bubble Sort~~~~~~~~~~~~~~~~");
        System.out.println("Unsorted array results:");
        AlgorithmAnalysis.bubbleSort2(array1copy2);
        System.out.println();

        System.out.println("Sorted array results:");
        AlgorithmAnalysis.bubbleSort2(array1copy2);
        System.out.println();

        // second test on array with 100 elements
        System.out.println("-------------------Test case 2-------------------");
        System.out.println("-------------Array with 100  elements-------------");

        // shell sort results
        System.out.println("~~~~~~~~~~~~~~~~~~~Shell Sort~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Unsorted array results:");
        AlgorithmAnalysis.shellSort(array2);
        System.out.println();

        System.out.println("Sorted array results:");
        AlgorithmAnalysis.shellSort(array2);
        System.out.println();

        // original bubble sort results
        System.out.println("~~~~~~~~~~~~~Original Bubble Sort~~~~~~~~~~~~~~~~");
        System.out.println("Unsorted array results:");
        AlgorithmAnalysis.bubbleSort(array2copy1);
        System.out.println();

        System.out.println("Sorted array results:");
        AlgorithmAnalysis.bubbleSort(array2copy1);
        System.out.println();

        // modified bubble sort results
        System.out.println("~~~~~~~~~~~~~Modified Bubble Sort~~~~~~~~~~~~~~~~");
        System.out.println("Unsorted array results:");
        AlgorithmAnalysis.bubbleSort2(array2copy2);
        System.out.println();

        System.out.println("Sorted array results:");
        AlgorithmAnalysis.bubbleSort2(array2copy2);
        System.out.println();

        // third test on array with 100 elements
        System.out.println("-------------------Test case 3-------------------");
        System.out.println("------------Array with 1000  elements-------------");

        // shell sort results
        System.out.println("~~~~~~~~~~~~~~~~~~~Shell Sort~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Unsorted array results:");
        AlgorithmAnalysis.shellSort(array3);
        System.out.println();

        System.out.println("Sorted array results:");
        AlgorithmAnalysis.shellSort(array3);
        System.out.println();

        // original bubble sort results
        System.out.println("~~~~~~~~~~~~~Original Bubble Sort~~~~~~~~~~~~~~~~");
        System.out.println("Unsorted array results:");
        AlgorithmAnalysis.bubbleSort(array3copy1);
        System.out.println();

        System.out.println("Sorted array results:");
        AlgorithmAnalysis.bubbleSort(array3copy1);
        System.out.println();

        // modified bubble sort results
        System.out.println("~~~~~~~~~~~~~Modified Bubble Sort~~~~~~~~~~~~~~~~");
        System.out.println("Unsorted array results:");
        AlgorithmAnalysis.bubbleSort2(array3copy2);
        System.out.println();

        System.out.println("Sorted array results:");
        AlgorithmAnalysis.bubbleSort2(array3copy2);
        System.out.println();
    }
}
