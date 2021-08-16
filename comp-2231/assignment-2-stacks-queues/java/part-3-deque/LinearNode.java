/**
 * LinearNode.Java
 * COMP 2231 Assignment 2: Part 2 and 3
 * 
 * Represents a node in a linked list.  Based on LinearNode class from Java Foundations
 * Chapter 13.  This implementation adds a previous reference for each LinearNode that
 * is created, allowing a user to create a doubly linked data structure.  Utilized in the
 * in the DropoutStack (Part 2) and LinkedDeque(Part 3) classes as part of Assignment 2.
 * 
 * @author Nico Van den Hooff
 * @version 1.0
 */
public class LinearNode<T>
{
    // next and previous node links
    private LinearNode<T> next, previous;
    
    // the node's element
    private T element;
    
    /**
     * Constructor 1: Creates an empty node.
     */
    public LinearNode()
    {
        // initialize element, next/previous references to null
        next = null;
        previous = null;
        element = null;
    }
    
    /**
     * Constructor 2: Creates a node storing the specified element.
     * @param elem element to be stored
     */
    public LinearNode(T elem)
    {
        // initalize next/previous references to null        
        next = null;
        previous = null;
        
        // set node element
        element = elem;
    }
    
    /**
     * Returns the node that follows this one.
     * @return reference to next node
     */
    public LinearNode<T> getNext()
    {
        return next;
    }
    
    /**
     * Sets the node that follows this one.
     * @param node node to follow this one
     */
    public void setNext(LinearNode<T> node)
    {
        next = node;
    }
    
    /**
     * Returns the node that comes before this one.
     * @return reference to next node
     */
    public LinearNode<T> getPrevious()
    {
        return previous;
    }
    
    /**
     * Sets the node that comes before this one.
     * @param node node to follow this one
     */
    public void setPrevious(LinearNode<T> node)
    {
        previous = node;
    }
    
    /**
     * Returns the element stored in this node.
     * @return element stored at the node
     */
    public T getElement()
    {
        return element;
    }
    
    /**
     * Sets the element stored in this node.
     * @param elem element to be stored at this node
     */
    public void setElement(T elem)
    {
        element = elem;
    }
}