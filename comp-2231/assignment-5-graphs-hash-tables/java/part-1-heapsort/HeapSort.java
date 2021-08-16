import jsjf.ArrayHeap;

/**
 * HeapSort.Java COMP 2231 Assignment 5: Part 1
 * 
 * HeapSort sorts a given array of Comparable objects using a heap. The method
 * heapSort is the original heapSort method from the Java Foundations textbook.
 * The method efficientHeapSort is the more efficient implementation for
 * Assignment 5.
 * 
 * @author Nico Van den Hooff
 * @version 1.0
 */
public class HeapSort<T> {
    /**
     * Sorts the specified array using a Heap Sort. Note: Written by Java
     * Foundations and kept in class for comparison purposes only.
     *
     * @param data the data to be added to the heapsort
     */
    public void heapSort(T[] data) {
        ArrayHeap<T> heap = new ArrayHeap<T>();

        // copy the array into a heap
        for (int i = 0; i < data.length; i++)
            heap.addElement(data[i]);

        // place the sorted elements back into the array
        int count = 0;
        while (!(heap.isEmpty())) {
            data[count] = heap.removeMin();
            count++;
        }
    }

    /**
     * Sorts the specificed array using a more efficient Heap Sort. First, builds a
     * maxheap in place using the data in the array. Then, sorts the array by moving
     * the max element (root) to the end of the array, one by one, until all
     * elements have been processed.
     * 
     * @param data the data to be sorted
     */
    public void efficientHeapSort(T[] data) {
        // size of heap (# of nodes)
        int size = data.length;

        // first non-leaf node
        int start = (size - 1) / 2;

        // build maxheap inplace
        for (int i = start; i >= 0; i--)
            heapify(data, size, i);

        // remove maxheap elements one by one, starting at root and
        // moving to the end of the array, until array is sorted.
        for (int i = size - 1; i >= 0; i--) {
            // move current root (current max element) to end of array
            T temp = data[0];
            data[0] = data[i];
            data[i] = temp;

            // recursively heapify remaining elements
            heapify(data, i, 0);
        }
    }

    /**
     * Recursively builds a maxheap out of an array of data.
     * 
     * @param data the data to be heapified
     * @param size the size of the heap
     * @param i    the node of the subtree to heapify
     */
    private void heapify(T[] data, int size, int i) {
        // assume parent node is largest to start
        int max = i;

        // left child index
        int left = 2 * i + 1;

        // right child index
        int right = 2 * i + 2;

        // swap max index if left child > parent
        if (left < size && ((Comparable) data[left]).compareTo(data[max]) > 0)
            max = left;

        // swap max index if right child > max index
        if (right < size && ((Comparable) data[right]).compareTo(data[max]) > 0)
            max = right;

        // if parent index is not max, swap parent element and max element
        if (max != i) {
            T temp = data[i];
            data[i] = data[max];
            data[max] = temp;

            // recursively heapify subtrees
            heapify(data, size, max);
        }
    }
}