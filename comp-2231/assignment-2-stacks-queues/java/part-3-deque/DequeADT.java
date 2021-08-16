/**
 * DequeADT.Java
 * COMP 2231 Assignment 2: Part 3 Interface
 * 
 * DequeADT defines the interface to a deque collection.
 *
 * @author Nico Van den Hooff
 * @version 1.0
 */
public interface DequeADT<T>
{
    /**
     * Adds one element to the front of this deque
     * @param   element the element to be added to the front of the deque
     */
    public void enqueueFirst (T element);
    
    /**
     * Adds one element to the rear of this deque
     * @param   element the element to be added to the rear of the deque
     */
    public void enqueueLast (T element);
    
    /**
     * Removes and returns the element at the front of the deque
     * @return  the element at the front of the deque
     */
    public T dequeueFirst();
    
    /**
     * Removes and returns the element at the rear of the deque
     * @return  the element at the rear of the deque
     */
    public T dequeueLast();
    
    /**
     * Returns the element at the front of the deque without removing it
     * @return  the element at the front of the deque
     */
    public T getFirst();
    
    /**
     * Returns the element at the rear of the deque without removing it
     * @return  the element at the rear of the deque
     */
    public T getLast();
    
    /**
     * Determines if the deque is empty (i.e. contains no elements)
     * @return  true if the deque is empty, false otherwise
     */
    public boolean isEmpty();
    
    /**
     * Determines the size of the deque (i.e. number of elements it contains)
     * @return  the size of the deque
     */
    public int size();
    
    /**
     * Returns a string representation of the deque
     * @return  a string representation of the deque
     */
    public String toString();
}