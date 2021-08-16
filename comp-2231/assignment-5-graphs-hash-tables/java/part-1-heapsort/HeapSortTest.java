import java.util.Arrays;

/**
 * HashTableTest.Java COMP 2231 Assignment 5: Part 1 Driver
 *
 * Test driver class for HeapSort.
 *
 * @author Nico Van den Hooff
 * @version 1.0
 */

public class HeapSortTest {
    public static void main(String[] args) {
        // test cases
        Integer[] array1 = { 20, 13, 27, 18, 2, 7, 0 };
        String[] array2 = { "Z", "R", "T", "A", "X", "H", "J" };
        Double[] array3 = { -1000.98, 200.43, 777.777, -345.67, -124232.9, 10000.0 };

        // used to perform heapsort
        HeapSort heapsorter = new HeapSort();

        // test case 1: Integer Array
        System.out.println("---------------Test Case 1: Integer Array 1---------------");

        // print array before heap sort
        System.out.println("Array before heapsort: " + Arrays.toString(array1));

        // run heapsort and reprint array
        System.out.println("Running heapsort...");
        heapsorter.efficientHeapSort(array1);
        System.out.println("Array after heapsort: " + Arrays.toString(array1));

        // run heapsort on sorted array and reprint array
        System.out.println("Running heapsort again...");
        System.out.println("Sorted array after heapsort: " + Arrays.toString(array1));
        System.out.println();

        // test case 2: String Array
        System.out.println("---------------Test Case 2: String Array---------------");

        // print array before heap sort
        System.out.println("Array before heapsort: " + Arrays.toString(array2));

        // run heapsort and reprint array
        System.out.println("Running heapsort...");
        heapsorter.efficientHeapSort(array2);
        System.out.println("Array after heapsort: " + Arrays.toString(array2));

        // run heapsort on sorted array and reprint array
        System.out.println("Running heapsort again...");
        System.out.println("Sorted array after heapsort: " + Arrays.toString(array2));
        System.out.println();

        System.out.println("---------------Test Case 3: Integer Array 2---------------");

        // print array before heap sort
        System.out.println("Array before heapsort: " + Arrays.toString(array3));

        // run heapsort and reprint array
        System.out.println("Running heapsort...");
        heapsorter.efficientHeapSort(array3);

        // run heapsort on sorted array and reprint array
        System.out.println("Array after heapsort: " + Arrays.toString(array3));
        System.out.println("Running heapsort again...");
        System.out.println("Sorted array after heapsort: " + Arrays.toString(array3));
    }
}
