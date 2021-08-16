/**
 * EmptyCollectionException.Java
 * COMP 2231 Assignment 2: Part 1, 2, 3, Exception Class
 * 
 * Represents the situation in which a collection is empty.  Written by Java
 * Foundations and utilized for this Assignment for COMP 2231.
 *
 * @author Java Foundations
 * @version 4.0
 */
public class EmptyCollectionException extends RuntimeException
{
    /**
     * Sets up this exception with an appropriate message.
     * @param collection the name of the collection
     */
    public EmptyCollectionException(String collection)
    {
        super("The " + collection + " is empty.");
    }
}
