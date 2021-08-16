package jsjf;

import java.util.*;
import jsjf.exceptions.*;

/**
 * ArrayBinaryTree implements the BinaryTreeADT interface using an array.
 *
 * @author Java Foundations
 * @version 4.0
 */
public class ArrayBinaryTree<T> implements BinaryTreeADT<T>, Iterable<T>
{
	private static final int DEFAULT_CAPACITY = 50;

	protected int count;
	protected T[] tree; 
	protected int modCount;

	/**
	 * Creates an empty binary tree.
	 */
	public ArrayBinaryTree() 
	{
		count = 0;
		tree = (T[]) new Object[DEFAULT_CAPACITY];
	}

	/**
	 * Creates a binary tree with the specified element as its root.
	 *
	 * @param element the element which will become the root of the new tree
	 */
	public ArrayBinaryTree(T element) 
	{
		count = 1;
		tree = (T[]) new Object[DEFAULT_CAPACITY];
		tree[0] = element;
	}

	/**
	 * Private method to expand capacity if full.
	 */    
	protected void expandCapacity()
	{
		tree = Arrays.copyOf(tree, tree.length * 2);   
	}

	/**
	 * Returns the root element of the tree.
	 *
	 * @return element stored at the root
	 * @throws EmptyCollectionException if the tree is empty
	 */
	public T getRootElement() throws EmptyCollectionException
	{
		if (isEmpty())
			throw new EmptyCollectionException("ArrayBinaryTree");

		return tree[0];
	}

	/**
	 * Returns true if this binary tree is empty and false otherwise.
	 * 
	 * @return true if this binary tree is empty, false otherwise
	 */
	public boolean isEmpty() 
	{
		return (count == 0);
	}

	/**
	 * Returns the integer size of this binary tree.
	 *
	 * @return the integer size of this binary tree
	 */
	public int size() 
	{
		return count;
	}

	/**
	 * Returns true if this tree contains an element that matches the
	 * specified target element and false otherwise.
	 *
	 * @param targetElement the element being sought in the tree
	 * @return true if the element is in this tree
	 */
	public boolean contains(T targetElement) 
	{
		T temp;
		boolean found = false;

		try 
		{
			temp = find(targetElement);
			found = true;
		}
		catch (Exception ElementNotFoundException) 
		{
			found = false;
		}

		return found;
	}

	/**
	 * Returns a reference to the specified target element if it is
	 * found in this binary tree.  Throws a ElementNotFoundException if
	 * the specified target element is not found in the binary tree.
	 *
	 * @param targetElement the element being sought in the tree
	 * @return true if the element is in the tree
	 * @throws ElementNotFoundException if the element is not in the tree
	 */
	public T find(T targetElement) throws ElementNotFoundException 
	{
		T temp = null;
		boolean found = false;

		for (int i = 0; i < tree.length && !found; i++)
			if (tree[i] != null)
				if (targetElement.equals(tree[i]))
				{
					found = true;
					temp = tree[i];
				}

		if (!found)
			throw new ElementNotFoundException("ArrayBinaryTree");

		return temp;
	}


	/**
	 * Returns a string representation of this binary tree showing
	 * the nodes in an inorder fashion.
	 *
	 * @return a string representation of the binary tree
	 */
	public String toString() 
	{
		ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
		inOrder(0, tempList);

		return tempList.toString();
	}

	/**
	 * Returns an iterator over the elements of this binary tree using
	 * the iteratorInOrder method
	 *
	 * @return an iterator over the binary tree
	 */
	public Iterator<T> iterator() 
	{
		return this.iteratorInOrder();
	}

	/**
	 * Performs an inorder traversal on this binary tree by calling an
	 * overloaded, recursive inorder method that starts with
	 * the root.
	 *
	 * @return an iterator over the binary tree
	 */
	public Iterator<T> iteratorInOrder() 
	{
		ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
		inOrder(0, tempList);

		return new TreeIterator(tempList.iterator());
	}

	/**
	 * Performs a recursive inorder traversal.
	 *
	 * @param node the index of the node used in the traversal
	 * @param tempList the temporary list used in the traversal
	 */
	protected void inOrder(int node, ArrayUnorderedList<T> tempList) 
	{
		if (node < tree.length)
			if (tree[node] != null)
			{
				inOrder(node * 2 + 1, tempList);
				tempList.addToRear(tree[node]);
				inOrder((node + 1) * 2, tempList);
			}
	}

	/**
	 * Performs an preorder traversal on this binary tree by calling an
	 * overloaded, recursive preorder method that starts with
	 * the root.
	 * 
	 * @return an iterator over the binary tree
	 */
	public Iterator<T> iteratorPreOrder() 
	{
		ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
		preOrder(0, tempList);

		return new TreeIterator(tempList.iterator());
	}

	/**
	 * Performs a recursive preorder traversal.
	 *
	 * @param node the index of the node used in the traversal
	 * @param tempList the temporary list used in the traversal
	 */
	protected void preOrder(int node, ArrayUnorderedList<T> tempList) 
	{
		if (node < tree.length)
			if (tree[node] != null) 
			{ 
				tempList.addToRear(tree[node]);
				preOrder(node * 2 + 1, tempList);
				preOrder((node + 1) * 2, tempList);
			}
	}

	/**
	 * Performs an postorder traversal on the binary tree by calling
	 * an overloaded, recursive postorder method that starts
	 * with the root.
	 * 
	 * @return an iterator over the binary tree
	 */
	public Iterator<T> iteratorPostOrder() 
	{
		ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
		postOrder(0, tempList);

		return new TreeIterator(tempList.iterator());
	}

	/**
	 * Performs a recursive postorder traversal.
	 * 
	 * @param node the index of the node used in the traversal
	 * @param tempList the temporary list used in the traversal
	 */
	protected void postOrder(int node, ArrayUnorderedList<T> tempList) 
	{
		if (node < tree.length)
			if (tree[node] != null) 
			{
				postOrder(node * 2 + 1, tempList); 
				postOrder((node + 1) * 2, tempList);
				tempList.addToRear(tree[node]);  
			}
	}

	/**
	 * Performs a levelorder traversal on this binary tree, using a
	 * tempList.
	 *
	 * @return an iterator over the binary tree
	 */
	public Iterator<T> iteratorLevelOrder() 
	{
		ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
		int ct = 0; // current number of elements added to list
		int i = 0; // current position in array

		while (ct < count)
		{
			if (tree[i] != null)
			{
				tempList.addToRear(tree[i]);
				ct++;
			}
			i++;
		}

		return new TreeIterator(tempList.iterator());
	}

	/**
	 * Inner class to represent an iterator over the elements of this tree
	 */
	private class TreeIterator implements Iterator<T>
	{
		private int expectedModCount;
		private Iterator<T> iter;

		/**
		 * Sets up this iterator using the specified iterator.
		 *
		 * @param iter the list iterator created by a tree traversal
		 */
		public TreeIterator(Iterator<T> iter)
		{
			this.iter = iter;
			expectedModCount = modCount;
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
			if (!(modCount == expectedModCount))
				throw new ConcurrentModificationException();

			return (iter.hasNext());
		}

		/**
		 * Returns the next element in the iteration. If there are no
		 * more elements in this iteration, a NoSuchElementException is
		 * thrown.
		 *
		 * @return the next element in the iteration
		 * @throws NoSuchElementException if the iterator is empty
		 */
		public T next() throws NoSuchElementException
		{
			if (hasNext())
				return (iter.next());
			else 
				throw new NoSuchElementException();
		}

		/**
		 * The remove operation is not supported.
		 * 
		 * @throws UnsupportedOperationException if the remove operation is called
		 */
		public void remove()
		{
			throw new UnsupportedOperationException();
		}
	}
}

