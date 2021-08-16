
/**
 * LinkedQueue.Java
 * COMP 2231 Assignment 3: Part 3
 * 
 * A queue data structure where the container for the queue is the java.util.LinkedList class.
 * Implements the QueueADT interface from Java Foundations.
 * 
 * @author Nico Van den Hooff
 * @version 1.0
 */

import java.util.LinkedList;

public class LinkedQueue<T> implements QueueADT<T> {
    private LinkedList<T> queue;

    /**
     * Constructor: Creates an empty queue.
     */
    public LinkedQueue() {
        queue = new LinkedList<T>();
    }

    /**
     * Adds one element to the rear of this queue.
     * 
     * @param element the element to be added to the rear of the queue
     */
    public void enqueue(T element) {
        queue.add(element);
    }

    /**
     * Removes and returns the element at the front of this queue.
     * 
     * @return the element at the front of the queue
     */
    public T dequeue() {
        // stores element in temporary variable to return
        T element = queue.remove();

        return element;
    }

    /**
     * Returns without removing the element at the front of this queue. Returns null
     * if empty.
     * 
     * @return the first element in the queue
     */
    public T first() {
        // uses peekFirst method from LinkedList as this performs the
        // desired operation. Note that the formal "queue" method would
        // normally just be called "first".
        return queue.peekFirst();
    }

    /**
     * Returns true if this queue contains no elements.
     * 
     * @return true if this queue is empty
     */
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    /**
     * Returns the number of elements in this queue.
     * 
     * @return the integer representation of the size of the queue
     */
    public int size() {
        return queue.size();
    }

    /**
     * Returns a string representation of this queue.
     * 
     * @return the string representation of the queue
     */
    public String toString() {
        String result = "";

        // loops through queue elements, adding to result
        for (T element : queue)
            result += element + "\n";

        return result;
    }
}
