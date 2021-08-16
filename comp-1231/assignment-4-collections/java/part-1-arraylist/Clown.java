/**
 * Clown.Java COMP 1231 Assignment 4: Collections (Question 1)
 *
 * A class that represents a Clown. Includes an instance variable to store the
 * Clown's name. Includes one constructor to set up a Clown object and it's
 * name. Includes methods to get or set a Clown's name, and a method to print a
 * Clown's name. Also overrides the equals method to determine if two Clowns
 * share the same name.
 *
 * @author Nico Van den Hooff
 * @version 1.0
 */
public class Clown {
    private String name; // used to store a Clown's name

    /**
     * Constructor for objects of class Clown
     *
     * @param n the name of a Clown
     */
    public Clown(String n) {
        name = n;
    }

    /**
     * Allows a user to access the name of a Clown.
     *
     * @return the name of a Clown
     */
    public String getName() {
        return name;
    }

    /**
     * Allows a user to modify the name of a Clown.
     *
     * @param n the new name of a Clown
     */
    public void setName(String n) {
        name = n;
    }

    /**
     * Compares the name of a Clown with that of another Clown.
     *
     * @param obj the other Clown object for purposes of the comparison
     * @return true if names match, false otherwise
     */
    public boolean equals(Object obj) {
        Clown otherClown = (Clown) obj;

        return this.name.equalsIgnoreCase(otherClown.getName());
    }

    /**
     * Returns a nicely formatted string representation of a Clown's name
     *
     * @return a nicely formatted string representation of a Clown's name
     */
    public String toString() {
        return name;
    }
}
