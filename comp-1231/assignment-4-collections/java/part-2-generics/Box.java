
/**
 * Box.Java
 * COMP 1231 Assigment 4: Collections (Question 2)
 * 
 * A generic class that simulates a Box.  The Box can contain objects of the specified type parameter.
 * For example, a Box could contain Strings that represent names written on pieces of paper.  Includes
 * methods to: allow a user to add an object to a Box, determine if a Box is empty, "draw" an item at
 * random from a Box, determine the size of the Box, and print the contents of the Box.  Includes two
 * constructors, one to set up a Box with a default capacity of 100 items, and another to specify
 * the initial capacity required.
 *
 * @author Nico Van den Hooff
 * @version 1.0
 */

import java.util.*;

public class Box<T> {
    private final static int DEFAULT_CAPACITY = 100; // default capcity for a Box
    private ArrayList<T> box = new ArrayList<T>(); // used to store the Box's objects
    private Random generator = new Random(); // for drawing random items from a Box

    /**
     * Constructor 1: Creates an empty box using the default capacity of 100
     * objects.
     */
    public Box() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Constructor 2: Creates an empty box using the specified initial capactiy.
     * 
     * @param initialCapacity the initial size of the Box
     */
    public Box(int initialCapacity) {
        box = new ArrayList<T>(initialCapacity);
    }

    /**
     * Adds the specified element to the Box. Uses the add method from ArrayList
     * which shares the same method name.
     * 
     * @param element the generic element to be added to the Box
     */
    public void add(T element) {
        box.add(element);
    }

    /**
     * Determines if a Box is empty. Uses the isEmpty method from ArrayList, which
     * shares the same method name.
     * 
     * @returns true if box is empty, false otherwise
     */
    public boolean isEmpty() {
        return box.isEmpty();
    }

    /**
     * Used to randomly select an object from the box and return it. Also eliminates
     * the object from the box. Returns null if the box is empty.
     * 
     * @returns a random generic element that is currently in the Box, unless the
     *          box is empty, then returns null.
     */
    public T drawItem() {
        if (this.isEmpty())
            return null;
        else {
            int randomItem = generator.nextInt(box.size());

            // temporarily store the random item as it is removed before the return
            // statement
            T temp = box.get(randomItem);
            box.remove(randomItem);

            return temp;
        }
    }

    /**
     * Returns a nicely formatted String version of the current contents of the box.
     * 
     * @returns a nicely formatted String representation of the current contents of
     *          the box. If the box is empty, returns a statement stating so.
     */
    public String toString() {
        String str = "";

        if (box.size() == 0) {
            str = "The box is currently empty";
            return str;
        } else {
            for (T element : box)
                str += element.toString() + "\n";

            return str;
        }
    }
}
