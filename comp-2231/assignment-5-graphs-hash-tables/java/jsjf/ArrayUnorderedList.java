package jsjf;

import jsjf.exceptions.*;

/**
 * ArrayUnorderedList represents an array implementation of an unordered list.
 * 
 * Solution to Programming Project 15.1 (full implementation)
 *
 * @author Java Foundations
 * @version 4.0
 */
public class ArrayUnorderedList<T> extends ArrayList<T> 
implements UnorderedListADT<T>
{
	/**
	 * Creates an empty list using the default capacity.
	 */
	public ArrayUnorderedList()
	{
		super();
	}

	/**
	 * Creates an empty list using the specified capacity.
	 *
	 * @param initialCapacity the initial size of the list
	 */
	public ArrayUnorderedList(int initialCapacity)
	{
		super(initialCapacity);
	}

	/**
	 * Adds the specified element to the front of this list.
	 * 
	 * @param element the element to be added to the front of the list
	 */
	public void addToFront(T element)
	{
        if (size() == list.length)
            expandCapacity();

        // shift elements up one 
        for (int scan = rear; scan > 0; scan--)
            list[scan] = list[scan - 1];

        list[0] = element;
        rear++;
		modCount++;
	}

	/**
	 * Adds the specified element to the rear of this list.
	 *
	 * @param element the element to be added to the list
	 */
	public void addToRear(T element)
	{
        if (size() == list.length)
            expandCapacity();

        list[rear] = element;
        rear++;
		modCount++;
	}

	/**
	 * Adds the specified element after the specified target element.
	 * Throws an ElementNotFoundException if the target is not found.
	 *
	 * @param element the element to be added after the target element
	 * @param target  the target that the element is to be added after
	 */
	public void addAfter(T element, T target)
	{
		if (size() == list.length)
			expandCapacity();

		int scan = 0;

		// find the insertion point
		while (scan < rear && !target.equals(list[scan])) 
			scan++;

		if (scan == rear)
			throw new ElementNotFoundException("UnorderedList");

		scan++;

		// shift elements up one
		for (int shift = rear; shift > scan; shift--)
			list[shift] = list[shift - 1];

		// insert element
		list[scan] = element;
		rear++;
		modCount++;
	}
}
