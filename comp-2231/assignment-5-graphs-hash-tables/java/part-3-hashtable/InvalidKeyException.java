/**
 * InvalidKeyException.Java
 * COMP 2231 Assignment 5: Part 3 Exception Class 1
 *
 * Custom exception class used in HashTable.
 *
 * @author Nico Van den Hooff
 * @version 1.0
 */
public class InvalidKeyException extends IllegalArgumentException
{
    public InvalidKeyException(String key)
    {
        super("The key: " + key + " is not in the correct format: " +
              "#-##-######-#");
    }
}
