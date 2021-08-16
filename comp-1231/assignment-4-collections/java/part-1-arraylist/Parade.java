/**
 * Parade.Java
 * COMP 1231 Assignment 4: Collections (Question 1)
 *
 * A class that represents a Parade of Clown objects.  Implemented using an ArrayList.  When a new Clown
 * "joins" (is added to) the Parade, they are added to the end (the "back") of the parade.  No explicit
 * constructor is declared as a design choice, since the default constructor will initialize an ArrayList
 * with 10 spaces, and then the ArrayList will update its size automatically.  Includes methods to add and
 * remove a Clown from the parade, that follow the logic previously explained.  Also includes methods to
 * return the size of a parade, check if a Clown is at the front of the parade, and to print a nicely
 * formatted version of the parade.
 *
 * Note, another design choice was to not inherit ArrayList, since this would give Parade access to methods
 * that would violate the Assignment requirements.  For example, if Parade inherited ArrayList, a
 * Clown would be able to be added at any position in the Parade, rather than only the back.
 *
 * @author Nico Van den Hooff 
 * @version 1.0
 */

import java.util.ArrayList;

public class Parade
{
    // instance variables - replace the example below with your own
    private ArrayList<Clown> parade = new ArrayList<Clown>();

    /**
     * Adds a Clown to the end of the Parade.  The "end" of the Parade is considered to be the Clown
     * at the current highest index in the ArrayList, which is also interpreted as the "back" of the
     * Parade.  Uses the add method from ArrayList, which shares the same method name.
     * @param clown the Clown to add to the Parade
     */
    public void add(Clown clown)
    {
        parade.add(clown);
    }

    /**
     * Removes the clown at the head of the Parade, unless the parade is empty.  The "head" of the Parade
     * is the Clown (if any) at index 0, which is also interpreted as the "front" of the Parade.
     * Uses the remove method from ArrayList, which shares the same method name.
     */
    public void remove()
    {
        if (parade.get(0) != null)
            parade.remove(0);
    }

    /**
     * Returns the current number of Clowns in a Parade.  Uses the size method from ArrayList, which
     * shares the same method name.
     * @return      the current number of Clowns in a Parade.
     */
    public int size()
    {
        return parade.size();
    }

    /**
     * Used to determine if a Clown is at the front (index 0) of the parade.
     * @param clown the Clown whose position to check
     * @return      true if the Clown is at index 0, false otherwise
     */
    public boolean isFront(Clown clown)
    {
        return parade.get(0) == clown;
    }

    /**
     * Returns a formatted String representation of the Clown's in the parade.
     * @return a formatted String representation of the Clown's in the parade
     */
    public String toString()
    {
        String str = "";

        str += "Number of Clowns in the Parade: " + parade.size() + "\n";
        str += "Names and positions of Clowns in the Parade: \n";

        for (Clown clown : parade)
            str += "Position: " + parade.indexOf(clown) + "\t Name: " + clown.getName() + "\n";

        return str;
    }
}
