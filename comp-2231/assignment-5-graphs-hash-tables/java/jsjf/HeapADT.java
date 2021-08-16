package jsjf;

/**
 * HeapADT defines the interface to a Heap.
 *
 * @author Java Foundations
 * @version 4.0
 */
public interface HeapADT<T> extends BinaryTreeADT<T> 
{
	/** 
	 * Adds the specified object to this heap. 
	 *
	 * @param obj the element to be added to the heap
	 */   
	public void addElement(T obj);

	/** 
	 * Removes element with the lowest value from this heap. 
	 *
	 * @return the element with the lowest value from the heap
	 */
	public T removeMin();

	/** 
	 * Returns a reference to the element with the lowest value in 
	 * this heap. 
	 *
	 * @return a reference to the element with the lowest value in the heap
	 */
	public T findMin();
}


