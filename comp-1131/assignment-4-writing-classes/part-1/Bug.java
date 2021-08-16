//****************************************************************************************************
// Bug.java
//
// COMP 1131 Assignment 4 Question 1 (Part 1: Bug Class)
//
// This is a class that represents a bug and contains methods that allow it to land and move along
// a horizontal wire.  The bug "lands" on the middle of the wire (represented by 0), the methods
// in the class then allow a user to output the bugs position on the wire, move the bug one unit
// in the direction it is facing, or turn the bug to face the other direction.
//****************************************************************************************************

public class Bug {
    // instance variables: location of bug, direction bug is facing
    private int location;
    private String direction_facing;

    // -----------------------------------------------------------------------------------------------
    // sets up a bug (i.e. bug "lands" on the wire, facing right)
    // -----------------------------------------------------------------------------------------------

    public Bug() {
        location = 0;
        direction_facing = "right";
    }

    // -----------------------------------------------------------------------------------------------
    // move the bug in the direction it is facing by one unit
    // -----------------------------------------------------------------------------------------------
    public void move() {
        if (direction_facing == "right")
            location++;
        else
            location--;
    }

    // -----------------------------------------------------------------------------------------------
    // turn the bug to face the opposite direction
    // -----------------------------------------------------------------------------------------------
    public void turn() {
        if (direction_facing == "right")
            direction_facing = "left";
        else
            direction_facing = "right";
    }

    // -----------------------------------------------------------------------------------------------
    // output the bugs location and the direction that it is facing
    // -----------------------------------------------------------------------------------------------
    public String toString() {
        String str;

        if (location == 0)
            str = ("The bug is in the middle of the wire and is facing " + direction_facing + "\n");
        else if (location > 0)
            str = ("The bug is " + location + " steps to the right and is facing " + direction_facing + "\n");
        else
            str = ("The bug is " + location * -1 + " steps to the left and is facing " + direction_facing + "\n");

        return str;
    }
}