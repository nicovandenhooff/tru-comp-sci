import java.util.ArrayList;

/**
 * HashTable.Java
 * COMP 2231 Assignment 5: Part 3
 *
 * Implements a hash table that stores 10 digit ISBN numbers and book names as
 * key value pairs.  An array is used as the data structure for the hash table.
 * Each cell in the hash table holds a HashNode object that is defined in a private
 * support class.  Each HashNode Object contains instance data related to the nodes
 * key, value, and a boolean marker to determine if the node has been marked as deleted.
 * The hash tables default initial size is 11, and dynamically resizes as needed with a
 * default load factor of 0.70.  The hash function calculates the hash address using a
 * extraction with division method, by extracting the last 3 digits of the ISBN number
 * and then determining the mod of this with the hash table size.  If a collision occurs,
 * linear probing is used until the next valid hash address is found.  If the nodes
 * marked as deleted in the hash table exceeds 50% of the nodes in the table, those nodes
 * are removed from the table and the entire table is rehashed.
 *
 * @author Nico Van den Hooff
 * @version 1.0
 */
public class HashTable
{
    // default capacity and load factor
    private static final int DEFAULT_CAPACITY = 11;
    private static final double DEFAULT_LOAD_FACTOR = 0.7;

    // maximum deleted items factor
    private static final double MAX_DELETED_FACTOR = 0.5;

    // ISBN format for hash table keys #-##-######-#
    private static final String PATTERN = "\\d{1}-\\d{2}-\\d{6}-\\d{1}";

    private HashNode [] hashTable;      // array to store hashed values
    private double loadFactor;          // load factor
    private int hashTableSize;          // size of hash table (capacity)
    private int numberOfValues;         // # of values in hash table
    private int deletedValues;          // # of deleted values in hash table

    /**
     * Constructor 1: Creates a hash table with the default capacity
     * and load factor
     */
    public HashTable()
    {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    /**
     * Constructor 2: Creates a hash table with the specified capcity
     * and default load factor
     */
    public HashTable(int initialCapacity)
    {
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
    }

    /**
     * Constructor 3: Creates a hash table with the specified capcity
     * and load factor
     */
    public HashTable(int initialCapacity, double loadFactor)
    {
        // creates a hash table with the specified capacity
        this.hashTable = new HashNode[initialCapacity];

        // sets load factor to the specified value, unless
        // its greater than 0.99, which causes the default
        // load factor to be used
        if (loadFactor > 0.99)
            this.loadFactor = DEFAULT_LOAD_FACTOR;
        else
            this.loadFactor = loadFactor;

        // sets the current size of hash table
        this.hashTableSize = initialCapacity;

        // sets the number of values and deleted values to zero
        this.numberOfValues = 0;
        this.deletedValues = 0;
    }

    /**
     * The hashing function.  Extracts the last 3 digits of the ISBN number
     * and then determines the hash key by the division method with the
     * current hash table size
     *
     * @param key   the key to be hashed
     * @return      the hash value for the given key
     * @throws InvalidKeyException  if the key pattern is invalid
     */
    public int hashCode(String key) throws InvalidKeyException
    {
        if (!key.matches(PATTERN))
        {
            throw new InvalidKeyException(key);
        }

        // parses the last 3 digits of the ISBN number
        int intKey = Integer.parseInt(key.replaceAll("-", "").substring(7));

        // hashing function
        return Math.abs(intKey) % hashTableSize;
    }

    /**
     * Maps a key value pair to the corresponding index in the hash table
     *
     * @param key       the key of the item to be mapped
     * @param value     the value of the item to be mapped
     * @throws InvalidKeyException if the key pattern is invalid
     */
    public void put(String key, String value) throws InvalidKeyException
    {
        if (!key.matches(PATTERN))
        {
            throw new InvalidKeyException(key);
        }

        // determine the index by using the hashing function
        int index = hashCode(key);

        // create a new node to store in the hash table
        HashNode node = new HashNode(key, value);

        // check load factor and expand hash table if necessary
        if (calculateLoadFactor() > loadFactor)
        {
            expandHashTable();
        }

        // linear probing to find an index if already taken
        while (hashTable[index] != null)
        {
            index = nextIndex(index);
        }

        // place item in the hash table
        hashTable[index] = node;

        // increment number of values
        numberOfValues++;
    }

    /**
     * Removes a key value pair from the hash table.  Checks the portion of
     * deleted items compared to the max deleted factor (50%) and removes
     * these items while rehashing the remaining items, if required
     *
     * @param key       the key of the item to be removed
     * @throws InvalidKeyException if the key pattern is invalid
     * @throws NoSuchKeyException  if the key does not exist in the hash table
     */
    public void remove(String key) throws InvalidKeyException, NoSuchKeyException
    {
        if (!key.matches(PATTERN))
        {
            throw new InvalidKeyException(key);
        }

        if (!containsKey(key))
            throw new NoSuchKeyException(key);

        // determine the index by using the hashing function
        int index = hashCode(key);

        // if there is a collision, cycle through indices until
        // the index with matching key is found
        while (!hashTable[index].getKey().equals(key))
        {
            index = nextIndex(index);
        }

        // mark the hash node as deleted
        hashTable[index].delete();

        // decrement number of values
        numberOfValues--;

        // increment number of deleted values
        deletedValues++;

        // if portion of deleted items is > 50%, remove these items
        // from the hash table and rehash the remaining items
        if (calculateDeletedFactor() > MAX_DELETED_FACTOR)
        {
            reHash();
        }
    }

    /**
     * Determines if the given key is in the hash table
     *
     * @param key       the key to search for in the hash table
     * @returns         true if the key is in the hash table, false otherwise
     * @throws InvalidKeyException if the key pattern is invalid
     */
    public boolean containsKey(String key) throws InvalidKeyException
    {
        if (!key.matches(PATTERN))
        {
            throw new InvalidKeyException(key);
        }

        // determine the index by using the hashing function
        int index = hashCode(key);

        // if the item at hash table index is null return false
        if (hashTable[index] == null)
            return false;
        // else try to search for the key
        else
            // loop with linear probing until a null value is encounted
            while (hashTable[index] != null)
            {
                // if this items key matches return true
                if (hashTable[index].getKey().equals(key))
                    return true;
                // else try the next index via linear probing
                else
                    index = nextIndex(index);
            }

        // if we make it through the above, then the hash table
        // does not contain the key so return false
        return false;
    }

    /**
     * Determines if the given value is in the hash table.  Uses a
     * simple linear search to attempt to find the value
     *
     * @param value     the value to search for in the hash table
     * @return          true if the value is found, false otherwise
     */
    public boolean containsValue(String value)
    {
        // linear search through hash table attempting to find value
        for (int i = 0; i < hashTable.length; i++)
        {
            if (hashTable[i] != null && hashTable[i].getValue() == value)
                return true;
        }

        // if we make it through the linear search then the item is
        // not in the hash table so return false
        return false;
    }

    /**
     * Gets the corresponding value for the given key from the hash table
     *
     * @param key       the key pair for the value to get
     * @returns         the value of the given key
     * @throws InvalidKeyException if the key pattern is invalid
     * @throws NoSuchKeyException  if the key does not exist in the hash table
     */
    public String getValue(String key) throws InvalidKeyException, NoSuchKeyException
    {
        if (!key.matches(PATTERN))
        {
            throw new InvalidKeyException(key);
        }

        if (!containsKey(key))
            throw new NoSuchKeyException(key);

        // determine the index by using the hash function
        int index = hashCode(key);

        // if there is a collision, cycle through indices until
        // the index with matching key is found
        while (!hashTable[index].getKey().equals(key))
        {
            index = nextIndex(index);
        }

        // return the value of the matching index
        return hashTable[index].getValue();
    }

    /**
     * Returns the number of values (not marked as deleted) in the hash table
     * @return the number of values (not marked as deleted) in the hash table
     */
    public int getNumberOfValues()
    {
        return numberOfValues;
    }

    /**
     * Returns the number of values marked as deleted in the hash table
     * @return the number of values marked as deleted in the hash table
     */
    public int getDeletedValues()
    {
        return deletedValues;
    }

    /**
     * Returns the total number of key value pairs in the hash table, including
     * cells marked as deleted
     * @return the total number of key value pairs in the hash table
     */
    public int size()
    {
        return (numberOfValues + deletedValues);
    }

    /**
     * Determines if the hash table is empty.  In order for the hash table to be
     * empty, it also cannot contain any cell with a node marked as deleted
     * @return true if the hash table is empty, false otherwise
     */
    public boolean isEmpty()
    {
        return (numberOfValues + deletedValues) == 0;
    }

    /**
     * Returns the current max capacity of the hash table
     * @return the current max capacity of the hash table
     */
    public int capacity()
    {
        return hashTableSize;
    }

    /**
     * Clears all cells in the hash table, rendering the table empty
     */
    public void clear()
    {
        // clear the hash table
        hashTable = new HashNode[hashTableSize];

        // update number of values to zero
        numberOfValues = 0;
        deletedValues = 0;
    }

    /**
     * Returns a string representation of the hashtable
     * @return a string representation of the hashtable
     */
    public String toString()
    {
        String result = "";

        // if the hash table is empty return a statement saying so
        if (isEmpty())
            result += "The hash table is empty";

        // else iterate through non-null and non-deleted values and add
        // each of them to the string representation
        else
            for (int i = 0; i < hashTable.length; i++)
            {
                if (hashTable[i] != null && !hashTable[i].isDeleted())
                {
                    result += "--------------------------------------------------";
                    result += "--------------------------------------------------\n";
                    result += "Index: " + i + "\t";
                    result += "Key: " + hashTable[i].getKey() + "\t\t";
                    result += "Value: " + hashTable[i].getValue()  + "\n";
                    result += "--------------------------------------------------";
                    result += "--------------------------------------------------\n";
                }
            }

        return result;
    }

    /**
     * Support method that calculates the next index to attempt to map to
     * using the linear probing function: ((current index + 1) % hash table size)
     *
     * @param index the index that is currently occupied
     * @return the next index to try to map to
     */
    private int nextIndex(int index)
    {
        return ((index + 1) % hashTableSize);
    }

    /**
     * Support method that calculates the current load factor of the hash table
     * @return the current load factor of the hash table
     */
    private double calculateLoadFactor()
    {
        // requires double cast since all instance data below is int
        return (double) (numberOfValues + deletedValues) / hashTableSize;
    }

    /**
     * Support method that determines the current portion of items marked as
     * deleted in the hash table.
     */
    private double calculateDeletedFactor()
    {
        return (double) (deletedValues) / (numberOfValues + deletedValues);
    }

    /**
     * Support method that expands the size of the hash table.  The new
     * size will be at least double the current size, and is guaranteed
     * to be a prime number
     */
    private void expandHashTable()
    {
        // temporary ArrayList to store items currently in hash table
        ArrayList<HashNode> temp = new ArrayList<HashNode>();

        // add items that aren't null or deleted in hash table to temp list
        for (int i = 0; i < hashTable.length; i++)
        {
            if (hashTable[i] != null && !hashTable[i].isDeleted())
                temp.add(hashTable[i]);
        }

        // calculate the new hash table size
        hashTableSize = nextPrimeSize(hashTableSize);

        // clear the current hash table and update size
        clear();

        // add each node back to the newly expanded hash table
        for (HashNode node: temp)
            put(node.getKey(), node.getValue());
    }

    /**
     * Support method that rehashes the entire hash table.  To be used
     * when the number of items + number of deleted items causes the
     * hash table to exceed the load factor.
     */
    private void reHash()
    {
        // temporary ArrayList for items currently in hash table
        ArrayList<HashNode> temp = new ArrayList<HashNode>();

        // add items that aren't null or deleted in hash table to temp list
        for (int i = 0; i < hashTable.length; i++)
            if (hashTable[i] != null && !hashTable[i].isDeleted())
                temp.add(hashTable[i]);

        // clear hash table
        clear();

        // add each node back to the newly expanded hash table
        for (HashNode node: temp)
            this.put(node.getKey(), node.getValue());
    }

    /**
     * Support method that determines if a number is prime.
     *
     * @param n     the number to check
     * @return      true if the number is prime, false otherwise
     */
    private boolean isPrime(int n)
    {
        // if divisible by 2, not prime
        if (n % 2 == 0)
            return false;

        // if divisible by odd numbers up to sqrt of n, not prime
        for (int i = 3; i * i <= n; i += 2)
            if (n % i == 0)
                return false;

        // if we got through the for loop, the number is prime
        return true;
    }

    /**
     * Support method used that determines the next size to expand
     * the hash table to.  Ensures that the next size will be at least
     * two times the current size, and is a prime number.
     *
     * @param size  the current hash table size
     * @return      the next hash table size to use
     */
    private int nextPrimeSize(int size)
    {
        // ensure that new size is at least 2x larger
        size *= 2;

        // iterate until the next prime is found
        for (int i = size; true; i++)
            if (isPrime(i))
                return i;
    }

    /**
     * Private class that represents a hash node to be stored in the
     * hash table within the HashTable class
     */
    private class HashNode
    {
        protected String key;       // the hash nodes key
        protected String value;     // the hash nodes value
        protected boolean deleted;  // deletion marker

        /**
         * Constructor: Creates a hash node with the given key value pair
         * @param key   the key of the hash node
         * @param value the value of the hash node
         */
        public HashNode(String key, String value)
        {
            // set the key and value of hash node
            this.key = key;
            this.value = value;

            // mark deleted as false
            deleted = false;
        }

        /**
         * Hash node key accessor
         * @return the hash nodes key
         */
        public String getKey()
        {
            return key;
        }

        /**
         * Hash node value accessor
         * @return the hash nodes value
         */
        public String getValue()
        {
            return value;
        }

        /**
         * Determines if a hash node is marked as deleted
         * @return true if a hash node is marked as deleted, false otherwise
         */
        public boolean isDeleted()
        {
            return deleted;
        }

        /**
         * Marks a hash node as deleted
         */
        public void delete()
        {
            // mark deleted as true
            deleted = true;
        }
    }
}
