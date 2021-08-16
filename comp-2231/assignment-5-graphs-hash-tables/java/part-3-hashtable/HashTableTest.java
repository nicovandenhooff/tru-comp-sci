/**
 * HashTableTest.Java
 * COMP 2231 Assignment 5: Part 3 Driver
 *
 * Test driver class for HashTable.
 *
 * @author Nico Van den Hooff
 * @version 1.0
 */
public class HashTableTest
{
    public static void main(String [] args)
    {
        // create new hash table with default capacity and load factor
        HashTable hashtable = new HashTable();
        
        // book 2, 3, 9 all have 777 as the last 3 digits of their ISBN
        // book 1, 6, 7 all have 123 as the last 3 digits of their ISBN
        // the above will cause collisions
        
        // first set of keys to add to hash table
        String [] keys1 = {"6-58-723912-3", "3-77-273377-7", "7-46-401977-7", 
                           "3-19-056468-8", "6-86-833825-7", "7-00-509112-3", 
                           "8-18-814512-3", "7-75-844049-4"};
        
        // first set of values to add to hash table
        String [] values1 = {"Book 1", "Book 2", "Book 3 (Collision)", 
                             "Book 4", "Book 5", "Book 6 (Collision)",
                             "Book 7 (Collision)", "Book 8"};
        
        // next set of keys to add to hash table
        String [] keys2 = {"9-71-846777-7", "3-81-731644-3"};
        
        // next set of values to add to hash table
        String [] values2 = {"Book 9 (Collision)", "Book 10"};
        
        System.out.println("********************Test 1: Add items to hash table********************");
        System.out.println("Creating a hash table...");
        System.out.println("Adding 8 items to the table...");
        
        // add the first set of key value pairs to the hash table
        for (int i = 0; i < keys1.length; i++)
            hashtable.put(keys1[i], values1[i]);
        
        // print the hash table and relevant information
        System.out.println(hashtable);
        System.out.println("The hash tables capacity is: " + hashtable.capacity() + " items");
        System.out.println("The hash table contains: " + hashtable.getNumberOfValues() + " items");
        System.out.println("The hash table contains: " + hashtable.getDeletedValues() + " deleted items");
        System.out.println("The hash table contains: " + hashtable.size() + " total items");
        System.out.println();
        
        System.out.println("********************Test 2: Add more items, causing resize********************");
        System.out.println("Adding 2 more items to the table causing it to resize...");
        // add the next set of key value pairs to the hash table
        for (int i = 0; i < keys2.length; i++)
            hashtable.put(keys2[i], values2[i]);
            
        // print the hash table and relevant information
        System.out.println(hashtable);
        System.out.println("The hash tables capacity is: " + hashtable.capacity() + " items");
        System.out.println("The hash table contains: " + hashtable.getNumberOfValues() + " items");
        System.out.println("The hash table contains: " + hashtable.getDeletedValues() + " deleted items");
        System.out.println("The hash table contains: " + hashtable.size() + " total items");
        System.out.println();
        
        System.out.println("********************Test 3: Add same items, different order********************");
        System.out.println("Clearing the hash table...");
        System.out.println("Adding the same items back, except in a different order...");
        System.out.println("The indicies below should be different than test 2 now...");
        
        // clear hash table
        hashtable.clear();
        
        // add the items in opposite order this time
        for (int i = 0; i < keys2.length; i++)
            hashtable.put(keys2[i], values2[i]);   
        
        for (int i = 0; i < keys1.length; i++)
            hashtable.put(keys1[i], values1[i]);
        
        // print the hash table and relevant information
        System.out.println(hashtable);
        
        System.out.println("********************Test 4: Testing ability to find items********************");
        
        // try to find a valid key
        System.out.println("Key 6-58-723912-3 exists in hash table: " + 
                                hashtable.containsKey("6-58-723912-3"));
        
        // try to find a valid value
        System.out.println("Book 5 exists in hash table: " + 
                                hashtable.containsValue("Book 5"));
                                
        // try to get a value for a valid key
        System.out.println("The value for Key 8-18-814512-3 is: " +
                                hashtable.getValue("8-18-814512-3"));
        
        // try to find an invalid key
        System.out.println("Key 0-00-000000-0 exists in hash table: " + 
                                hashtable.containsKey("0-00-000000-0"));
        
        // try to find an invalid value
        System.out.println("Book 100 exists in hash table: " + 
                                hashtable.containsValue("Book 100"));
        System.out.println();
        
        System.out.println("********************Test 5: Removal of items********************");
        System.out.println("Removing three items from the hash table...");
        System.out.println();
        
        // remove three items from the hash table
        hashtable.remove("6-58-723912-3");
        hashtable.remove("3-77-273377-7");
        hashtable.remove("7-46-401977-7");
        
        // print the hash table and relevant information
        System.out.println(hashtable);
        System.out.println("The hash tables capacity is: " + hashtable.capacity() + " items");
        System.out.println("The hash table contains: " + hashtable.getNumberOfValues() + " items");
        System.out.println("The hash table contains: " + hashtable.getDeletedValues() + " deleted items");
        System.out.println("The hash table contains: " + hashtable.size() + " total items");
        System.out.println();
        
        
        System.out.println("********************Test 6: Remove more items causing rehashing********************");
        System.out.println("Removing three more items from the hash table...");
        System.out.println();
        
        // remove three more items which will cause deleted factor to go over limit
        // this will cause the hash table to remove deleted items and resize
        hashtable.remove("3-19-056468-8");
        hashtable.remove("6-86-833825-7");
        hashtable.remove("7-00-509112-3");
        
        // print the hash table and relevant information
        System.out.println(hashtable);
        System.out.println("The hash tables capacity is: " + hashtable.capacity() + " items");
        System.out.println("The hash table contains: " + hashtable.getNumberOfValues() + " items");
        System.out.println("The hash table contains: " + hashtable.getDeletedValues() + " deleted items");
        System.out.println("The hash table contains: " + hashtable.size() + " total items");
        System.out.println();
        
        System.out.println("********************Test 7: Clear hash table and test remaining methods********************");
        
        // clear the hash table and test only untested method so far - isEmpty()
        hashtable.clear();
        System.out.println("The hash table is empty: " + hashtable.isEmpty());
    }
}
