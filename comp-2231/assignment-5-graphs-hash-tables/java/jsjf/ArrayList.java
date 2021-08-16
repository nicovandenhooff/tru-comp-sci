package jsjf;

import jsjf.exceptions.*;
import java.util.*;

/**
 * ArrayList represents an array implementation of a list. The front of
 * the list is kept at array index 0. This class will be extended
 * to create a specific kind of list.
 * 
 * Solution to Programming Project 15.1 (full implementation)
 *
 * @author Java Foundations
 * @version 4.0
 */
public abstract class ArrayList<T> implements ListADT<T>, Iterable<T>
{
	private final static int DEFAULT_CAPACITY = 100;
	private final static int NOT_FOUND = -1;

	protected int rear;
	protected T[] list;
	protected int modCount;

	/**
	 * Creates an empty list using the default capacity.
	 */
	public ArrayList()
	{
		this(DEFAULT_CAPACITY);
	}

	/**
	 * Creates an empty list using the specified capacity.
	 *
	 * @param initialCapacity the integer value of the size of the array list
	 */
	public ArrayList(int initialCapacity)
	{
		rear = 0;
		list = (T[])(new Object[initialCapacity]);
		modCount = 0;
	}

	/**
	 * Creates a new array to store the contents of this list with
	 * twice the capacity of the old one. Called by descendant classes
	 * that add elements to the list.
	 */
	protected void expandCapacity()
	{
		list = Arrays.copyOf(list, list.length * 2);  
	}

	/**
	 * Removes and returns the last element in this list.
	 *
	 * @return the last element in the list
	 * @throws EmptyCollectionException if the element is not in the list
	 */
	public T removeLast() throws EmptyCollectionException
	{
        if (isEmpty())
            throw new EmptyCollectionException("ArrayList");

        T result;
        rear--;
        result = list[rear];
        list[rear] = null;
		modCount++;

        return result;
	}

	/**
	 * Removes and returns the first element in this list.
	 *
	 * @return the first element in the list
	 * @throws EmptyCollectionException if the element is not in the list
	 */
	public T removeFirst() throws EmptyCollectionException
	{
        if (isEmpty())
            throw new EmptyCollectionException("ArrayList");

        T result = list[0];
        rear--;
        
        // shift the elements
        for (int scan = 0; scan < rear; scan++)
            list[scan] = list[scan+1];
 
        list[rear] = null;
		modCount++;
 
        return result;
	}

	/**
	 * Removes and returns the specified element.
	 *
	 * @param  element the element to be removed and returned from the list
	 * @return the removed element
	 * @throws ElementNotFoundException if the element is not in the list
	 */
	public T remove(T element)
	{
		T result;
		int index = find(element);

		if (index == NOT_FOUND)
			throw new ElementNotFoundException("ArrayList");

		result = list[index];
		rear--;

		// shift the appropriate elements 
		for (int scan = index; scan < rear; scan++)
			list[scan] = list[scan+1];

		list[rear] = null;
		modCount++;

		return result;
	}

	/**
	 * Returns a reference to the element at the front of this list.
	 * The element is not removed from the list.  Throws an
	 * EmptyCollectionException if the list is empty.  
	 *
	 * @return a reference to the first element in the list
	 * @throws EmptyCollectionException if the list is empty
	 */
	public T first() throws EmptyCollectionException
	{
        if (isEmpty())
            throw new EmptyCollectionException("ArrayList"); 

        return list[0];
	}

	/**
	 * Returns a reference to the element at the rear of this list.
	 * The element is not removed from the list. Throws an
	 * EmptyCollectionException if the list is empty.  
	 *
	 * @return a reference to the last element of this list
	 * @throws EmptyCollectionException if the list is empty
	 */
	public T last() throws EmptyCollectionException
	{
        if (isEmpty())
            throw new EmptyCollectionException("ArrayList"); 

        return list[rear - 1];
	}

	/**
	 * Returns true if this list contains the specified element.
	 *
	 * @param target the target element
	 * @return true if the target is in the list, false otherwise 
	 */
	public boolean contains(T target)
	{
		return (find(target) != NOT_FOUND);
	}

	/**
	 * Returns the array index of the specified element, or the
	 * constant NOT_FOUND if it is not found.
	 *
	 * @param target the target element
	 * @return the index of the target element, or the 
	 *         NOT_FOUND constant
	 */
	private int find(T target)
	{
		int scan = 0; 
		int result = NOT_FOUND;

		if (!isEmpty())
			while (result == NOT_FOUND && scan < rear)
				if (target.equals(list[scan]))
					result = scan;
				else
					scan++;

		return result;
	}

	/**
	 * Returns true if this list is empty and false otherwise. 
	 *
	 * @return true if the list is empty, false otherwise
	 */
	public boolean isEmpty()
	{
        return (rear == 0);
	}

	/**
	 * Returns the number of elements currently in this list.
	 *
	 * @return the number of elements in the list
	 */
	public int size()
	{
        return rear;
	}

	/**
	 * Returns a string representation of this list. 
	 * 
	 * @return the string representation of the list
	 */
	public String toString()
	{
        String result = "";

        for (int scan=0; scan < rear; scan++) 
            result = result + list[scan] + "\n";

        return result;
	}

	/**
	 * Returns an iterator for the elements currently in this list.
	 * 
	 * @return an iterator for the elements in the list
	 */
	public Iterator<T> iterator()
	{
		return new ArrayListIterator();
	}

	/**
	 * ArrayListIterator iterator over the elements of an ArrayList.
	 */	
	private class ArrayListIterator implements Iterator<T>
	{
		int iteratorModCount;
		int current;

		/**
		 * Sets up this iterator using the specified modCount.
		 * 
		 * @param modCount the current modification count for the ArrayList
		 */
		public ArrayListIterator()
		{
			iteratorModCount = modCount;
			current = 0;
		}

		/**
		 * Returns true if this iterator has at least one more element
		 * to deliver in the iteration.
		 *
		 * @return  true if this iterator has at least one more element to deliver
		 *          in the iteration
		 * @throws  ConcurrentModificationException if the collection has changed
		 *          while the iterator is in use
		 */
		public boolean hasNext() throws ConcurrentModificationException
		{
			if (iteratorModCount != modCount)
				throw new ConcurrentModificationException();

			return (current < rear);
		}

		/**
		 * Returns the next element in the iteration. If there are no
		 * more elements in this iteration, a NoSuchElementException is
		 * thrown.
		 *
		 * @return  the next element in the iteration
		 * @throws  NoSuchElementException if an element not found exception occurs
		 * @throws  ConcurrentModificationException if the collection has changed
		 */
		public T next() throws ConcurrentModificationException
		{
			if (!hasNext())
				throw new NoSuchElementException();

			current++;

			return list[current - 1];
		}

		/**
		 * The remove operation is not supported in this collection.
		 * 
		 * @throws UnsupportedOperationException if the remove method is called
		 */
		public void remove() throws UnsupportedOperationException
		{
			throw new UnsupportedOperationException();
		}

	}	
}
