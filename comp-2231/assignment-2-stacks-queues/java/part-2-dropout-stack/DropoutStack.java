/**
 * DropoutStack.Java
 * COMP 2231 Assignment 2: Part 2
 * 
 * Implementation of a drop-out stack.  Behaves like a stack in every respect except that
 * the stack size is limited to "n" elements.  When the "n + 1" element is pushed onto the
 * top of drop-out stack, the bottom element is lost.  The constructor of the class allows
 * a user to specify the number of elements "n" that the drop-out stack can hold.
 * 
 * Note: Algorithm Efficiency
 * This implementation contains a O(n) push method due to the for loop that traverses the stack.
 * This was a design decision as this data structure is a singly linked list.  This would make
 * this implementation of the drop-out stack suitable for smaller stacks only.  A doubly linked 
 * structure should be implemented if the intention is to use a larger stack with drop-out 
 * features.
 *
 * @author Nico Van den Hooff
 * @version 1.0
 */

public class DropoutStack<T> implements StackADT<T>
{
    private int count;              // keeps a tally of the number of nodes on the stack
    private int maxSize;            // holds the max number of elements "n" for the stack
    private LinearNode<T> top;      // points to the top node of the stack

    /**
     * Constructor: Creates an empty dropout-stack, allowing the user to
     * pass the desired capcity.
     * @param   max the max number of elements the drop-out stack can hold
     */
    public DropoutStack(int max)
    {
        maxSize = max;
        count = 0;
        top = null;
    }

    /**
     * Adds the specified element to the top of this stack. If the drop-out
     * stack is at capcity, the bottom element is "dropped" (lost).
     * @param   element element to be pushed on stack
     */
    public void push(T element)
    {   
        // checks if the current number of elements on the stack is equal to
        // the max number of elements allowed.
        if (count == maxSize)
        {
            // temporary node
            LinearNode current = top;
            
            // traverse stack until second last element
            for (int i = 1; i < maxSize - 1; i++)
                current = current.getNext();
            
            // set last (bottom) element of the stack to null
            current.setNext(null);
            
            // decrement count as an element is dropped
            count--;
        }
        
        // pushes the passed element to the top of the stack and increments counter
        LinearNode<T> temp = new LinearNode<T>(element);
        temp.setNext(top);
        top = temp;
        count++;
    }

    /**
     * Removes the element at the top of this stack and returns a
     * reference to it.
     * @return element from top of stack
     * @throws EmptyCollectionException if the stack is empty
     */
    public T pop() throws EmptyCollectionException
    {
        // throws exception for an empty stack
        if (isEmpty())
            throw new EmptyCollectionException("stack");
        
        // pops and returns the top element and decrements counter
        T result = top.getElement();
        top = top.getNext();
        count--;
        
        return result;
    }
    
    /**
     * Returns a reference to the element at the top of this stack.
     * The element is not removed from the stack.
     * @return element on top of stack
     * @throws EmptyCollectionException if the stack is empty
     */
    public T peek() throws EmptyCollectionException
    {
        // throws exception if empty, otherwise returns top element
        if (isEmpty())
            throw new EmptyCollectionException("stack");

        return top.getElement();
    }

    /**
     * Returns true if this stack is empty and false otherwise. A
     * stack is empty if the count of elements is zero.
     * @return true if stack is empty
     */
    public boolean isEmpty()
    {
        return (count == 0);
    }
    
    /**
     * Returns true if the number of elements in the dropout stack
     * is equal to the max elements it can hold.  E.g. for a dropout
     * stack that can hold 5 elements, returns true if the stack 
     * contains 5 elements.
     * @return true if dropout stack contains max number of elements
     */
    public boolean isFull()
    {
        return (count == maxSize);
    }    
    
    /**
     * Returns the number of elements in this stack.
     * @return number of elements in the stack
     */
    public int size()
    {
        return count;
    }

    /**
     * Returns the max number of elements in this dropout stack.
     * @return max number of elements in the stack
     */
    public int getMaxSize()
    {
        return maxSize;
    }
    
    /**
     * Allows the user to update the max number of elements for a
     * dropout stack.
     */
    public void setMaxSize(int max)
    {
        maxSize = max;
    }
    
    /**
     * Returns a string representation of this dropout stack.
     * @return string representation of the dropout stack
     */
    public String toString()
    {
        String result = "";
        LinearNode current = top;
        
        // traverses drop-out stack adding String of each node to result
        while (current != null)
        {
            result = result + current.getElement() + "\n";
            current = current.getNext();
        }

        return result;
    }
}