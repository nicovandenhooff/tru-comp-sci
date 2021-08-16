/**
 * LinkedDeque.Java
 * COMP 2231 Assignment 2: Part 3
 *
 * Implementation of a deque.  Implments the DequeADT interface.  A deque (pronounced
 * "deck") is a double-ended queue.  Behaves similar to a traditional queue, except that
 * it is possible to add,remove, or view elements from both the front or rear of the deque.
 *
 * @author Nico Van den Hooff
 * @version 2.0
 */

public class LinkedDeque<T> implements DequeADT<T>
{
    private int count;                      // keeps a tally of the number of nodes on the deque
    private LinearNode<T> head, tail;       // points to the head and tail nodes of the deque

    /**
     * Constructor: Creates an empty deque
     */
    public LinkedDeque()
    {
        // initialize number of elements to zero, and head/tail elements to null
        count = 0;
        head = null;
        tail = null;
    }

    /**
     * Adds one element to the front of this deque
     * @param   element the element to be added to the front of the deque
     */
    public void enqueueFirst (T element)
    {
        LinearNode<T> node = new LinearNode<T>(element);

        // if deque is empty, assign new node as tail node
        if (isEmpty())
            tail = node;
        else
        // otherwise 1) link new node to current head node, 2) link current head node to new node
        {
            node.setNext(head);
            head.setPrevious(node);
        }

        // assign new node as head node and increment count
        head = node;
        count++;
    }

    /**
     * Adds one element to the rear of this deque
     * @param   element the element to be added to the rear of the deque
     */
    public void enqueueLast (T element)
    {
        LinearNode<T> node = new LinearNode<T>(element);

        // if deque is empty, assign new node as head node
        if (isEmpty())
            head = node;
        else
        // otherwise 1) link new node to current tail node, 2) link current tail node to new node
        {
            node.setPrevious(tail);
            tail.setNext(node);
        }

        // assign new node as tail node and increment count
        tail = node;
        count++;
    }

    /**
     * Removes and returns the element at the front of the deque
     * @return  the element at the front of the deque
     * @throws  EmptyCollectionException if the deque is empty
     */
    public T dequeueFirst() throws EmptyCollectionException
    {
        // throw exception if deque is empty
        if (isEmpty())
            throw new EmptyCollectionException("deque");

        // store element from current head node for return value
        T result = head.getElement();

        // reassign head node to next node, decrement count
        head = head.getNext();
        count--;

        // if deque is now empty update tail reference to null
        if (isEmpty())
            tail = null;
        else
        // otherwise set the old head to null
            head.setPrevious(null);

        return result;
    }

    /**
     * Removes and returns the element at the rear of the deque
     * @return  the element at the rear of the deque
     * @throws  EmptyCollectionException if the deque is empty
     */
    public T dequeueLast() throws EmptyCollectionException
    {
        // throw exception if deque is empty
        if (isEmpty())
            throw new EmptyCollectionException("deque");

        // store element from current tail node for return value
        T result = tail.getElement();

        // reassign tail node to previous node, remove previous tail, decrement count
        tail = tail.getPrevious();
        count--;

        // if deque is now empty update head reference to null
        if (isEmpty())
            head = null;
        else
        // otherwise set the old tail to null
            tail.setNext(null);

        return result;
    }

    /**
     * Returns the element at the front of the deque without removing it
     * @return  the element at the front of the deque
     * @throws  EmptyCollectionException if the deque is empty
     */
    public T getFirst() throws EmptyCollectionException
    {
        // throw exception if deque is empty
        if (isEmpty())
            throw new EmptyCollectionException("deque");

        return head.getElement();
    }

    /**
     * Returns the element at the rear of the deque without removing it
     * @return  the element at the rear of the deque
     * @throws  EmptyCollectionException if the deque is empty
     */
    public T getLast() throws EmptyCollectionException
    {
        // throw exception if deque is empty
        if (isEmpty())
            throw new EmptyCollectionException("deque");

        return tail.getElement();
    }

    /**
     * Determines if the deque is empty (i.e. contains no elements)
     * @return  true if the deque is empty, false otherwise
     */
    public boolean isEmpty()
    {
        return (count == 0);
    }

    /**
     * Determines the size of the deque (i.e. number of elements it contains)
     * @return  the size of the deque
     */
    public int size()
    {
        return count;
    }

    /**
     * Returns a string representation of the deque
     * @return  a string representation of the deque
     */
    public String toString()
    {
        String result = "";
        LinearNode<T> current = head;

        // traverses deque adding String of each node to result
        while (current != null)
        {
            result = result + current.getElement() + "\n";
            current = current.getNext();
        }

        return result;
    }
}
