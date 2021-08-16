package jsjf;

import java.util.Iterator;

/**
 * BinaryTreeADT defines the interface to a binary tree data structure.
 *
 * @author Java Foundations
 * @version 4.0
 */
public interface BinaryTreeADT<T> 
{
	/** 
	 * Returns a reference to the root element 
	 *
	 * @return a reference to the root
	 */
	public T getRootElement();

	/** 
	 * Returns true if this binary tree is empty and false otherwise.
	 *
	 * @return true if this binary tree is empty, false otherwise
	 */
	public boolean isEmpty();

	/** 
	 * Returns the number of elements in this binary tree.
	 *
	 * @return the number of elements in the tree
	 */
	public int size();

	/** 
	 * Returns true if the binary tree contains an element that matches
	 * the specified element and false otherwise. 
	 *
	 * @param targetElement the element being sought in the tree
	 * @return true if the tree contains the target element
	 */
	public boolean contains(T targetElement);

	/** 
	 * Returns a reference to the specified element if it is found in 
	 * this binary tree. Throws an exception if the specified element
	 * is not found.
	 *
	 * @param targetElement the element being sought in the tree
	 * @return a reference to the specified element
	 */
	public T find(T targetElement);

	/**  
	 * Returns the string representation of this binary tree.
	 *
	 * @return a string representation of the binary tree
	 */
	public String toString();

	/**  
	 * Returns an iterator over the elements of this tree.
	 *
	 * @return an iterator over the elements of this binary tree
	 */
	public Iterator<T> iterator();

	/**  
	 * Returns an iterator that represents an inorder traversal on this binary tree.  
	 *
	 * @return an iterator over the elements of this binary tree
	 */
	public Iterator<T> iteratorInOrder();

	/**  
	 * Returns an iterator that represents a preorder traversal on this binary tree. 
	 *
	 * @return an iterator over the elements of this binary tree
	 */
	public Iterator<T> iteratorPreOrder();

	/**  
	 * Returns an iterator that represents a postorder traversal on this binary tree. 
	 *
	 * @return an iterator over the elements of this binary tree
	 */
	public Iterator<T> iteratorPostOrder();

	/**  
	 * Returns an iterator that represents a levelorder traversal on the binary tree.
	 *
	 * @return an iterator over the elements of this binary tree
	 */
	public Iterator<T> iteratorLevelOrder();
}

