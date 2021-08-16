
/**
 * ArrayStack.Java
 * COMP 2231 Assignment 2: Part 1
 * 
 * Array based implementation of a stack that is based on the original ArrayStack class from
 * Chapter 12 of Java Foundations.  This implementation has been updated so that the top of
 * the stack is the actual top element, rather than the next available position in the stack.
 * 
 * @author Nico Van den Hooff
 * @version 1.0
 */

import java.util.Arrays;

public class ArrayStack<T> implements StackADT<T> {
    // default stack capacity is set to 100
    private final static int DEFAULT_CAPACITY = 100;

    private int top; // keeps track of the top element location
    private T[] stack; // array used as the base data structure for the stack

    /**
     * Constructor 1: Creates an empty stack using the default capacity.
     */
    public ArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Constructor 2: Creates an empty stack of the user specified quantity.
     * 
     * @param initialCapacity the initial size of the stack
     */
    public ArrayStack(int initialCapacity) {
        // initialize top to -1 as there are no items on the stack yet
        top = -1;

        // create empty stack
        stack = (T[]) (new Object[initialCapacity]);
    }

    /**
     * Adds the specified element to the top of this stack, expanding the capacity
     * of the array if necessary.
     * 
     * @param element generic element to be pushed onto stack
     */
    public void push(T element) {
        // expands stack capacity if stack is full
        if (size() == stack.length)
            expandCapacity();

        // increments top counter and pushes element onto stack
        top++;
        stack[top] = element;
    }

    /**
     * Creates a new array to store the contents of this stack with twice the
     * capacity of the old one.
     */
    private void expandCapacity() {
        // creates a copy of the stack with double the capcity
        stack = Arrays.copyOf(stack, stack.length * 2);
    }

    /**
     * Removes the element at the top of this stack and returns a reference to it.
     * 
     * @return element removed from top of stack
     * @throws EmptyCollectionException if stack is empty
     */
    public T pop() throws EmptyCollectionException {
        // throws exception if stack is empty
        if (isEmpty())
            throw new EmptyCollectionException("stack");

        // stores top of stack in temp variable and updates top to null
        T result = stack[top];
        stack[top] = null;

        // decrements top counter
        top--;

        return result;
    }

    /**
     * Returns a reference to the element at the top of this stack. The element is
     * not removed from the stack.
     * 
     * @return element on top of stack
     * @throws EmptyCollectionException if stack is empty
     */
    public T peek() throws EmptyCollectionException {
        // throws exception if stack is empty
        if (isEmpty())
            throw new EmptyCollectionException("stack");

        return stack[top];
    }

    /**
     * Returns true if this stack is empty and false otherwise. The stack is empty
     * if the top reference variable contains -1.
     * 
     * @return true if this stack is empty
     */
    public boolean isEmpty() {
        return (top == -1);
    }

    /**
     * Returns the number of elements in this stack. If the stack is empty returns
     * 0.
     * 
     * @return the number of elements in the stack
     */
    public int size() {
        if (isEmpty())
            return 0; // stack is empty
        else
            return (top + 1); // + 1 due to zero based array indexing
    }

    /**
     * Returns a string representation of this stack. If the stack is empty returns
     * a statement stating the fact.
     * 
     * @return a string representation of the stack
     */
    public String toString() {
        String result = "";

        if (isEmpty())
            result += "Stack is empty, no elements to print\n";
        else {
            for (int i = 0; i <= top; i++)
                result += stack[i] + "\n";
        }

        return result;
    }
}