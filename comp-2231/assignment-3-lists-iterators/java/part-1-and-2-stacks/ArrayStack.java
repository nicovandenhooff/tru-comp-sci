
/**
 * ArrayStack.Java
 * COMP 2231 Assignment 3: Part 2
 * 
 * A stack data structure where the container for the stack is the java.util.ArrayList class.
 * Implements the StackADT interface from Java Foundations.
 * 
 * @author Nico Van den Hooff
 * @version 1.0
 */

import java.util.ArrayList;

public class ArrayStack<T> implements StackADT<T> {
    // stack container
    private ArrayList<T> stack;

    /**
     * Constructor: Creates an empty stack.
     */
    public ArrayStack() {
        stack = new ArrayList<T>();
    }

    /**
     * Adds the specified element to the top of this stack.
     * 
     * @param element element to be pushed onto the stack
     */
    public void push(T element) {
        stack.add(0, element);
    }

    /**
     * Removes and returns the top element from this stack.
     * 
     * @return the element removed from the stack
     */
    public T pop() {
        // stores element in temporary variable to return
        T element = stack.remove(0);

        return element;
    }

    /**
     * Returns without removing the top element of this stack. Returns null if
     * empty.
     * 
     * @return the element on top of the stack
     */
    public T peek() {
        if (isEmpty())
            return null;
        else
            return stack.get(0);
    }

    /**
     * Returns true if this stack contains no elements.
     * 
     * @return true if the stack is empty
     */
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    /**
     * Returns the number of elements in this stack.
     * 
     * @return the number of elements in the stack
     */
    public int size() {
        return stack.size();
    }

    /**
     * Returns a string representation of this stack.
     * 
     * @return a string representation of the stack
     */
    public String toString() {
        String result = "";

        // loops through stack elements, adding to result
        for (T element : stack)
            result += element + "\n";

        return result;
    }
}
