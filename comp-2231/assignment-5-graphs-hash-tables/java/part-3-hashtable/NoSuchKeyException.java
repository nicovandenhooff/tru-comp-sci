/**
 * NoSuchKeyException.Java
 * COMP 2231 Assignment 5: Part 3 Exception Class 2
 *
 * Custom exception class used in HashTable.
 *
 * @author Nico Van den Hooff
 * @version 1.0
 */
public class NoSuchKeyException extends IllegalArgumentException
{
    public NoSuchKeyException(String key)
    {
        super("The key: " + key + " is not in the hashtable");
    }
}
