//****************************************************************************************************
// Bug_Program.java
//
// COMP 1131 Assignment 4 Question 1 (Part 2: Bug Test Driver)
//
// This is a test driver for the class Bug that was created as part of Assignment 4 Question 1.
//****************************************************************************************************

import java.util.Scanner;

public class Bug_Program {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String command;

        // welcomes user to program, explains controls to user
        System.out.println("Buzz Buzz... welcome to the Bug on-a-wire program!\n");

        System.out.println(
                "To control the bug, type: \n" + "\"Move\" to move the bug one step in the direction it's facing\n"
                        + "\"Turn\" to turn the bug to face the opposite direction\n"
                        + "\"Output\" to display the bug's location and direction to the screen\n"
                        + "Or type any other value to terminate the program\n");

        // instantiates a bug and displays initial location & direction facing
        Bug bug = new Bug();
        System.out.println("A bug landed on the wire!");
        System.out.println(bug);

        // prompts user for first command to control bug
        System.out.print("Enter your command: ");
        command = keyboard.next();
        command = command.toLowerCase();

        // loop to allow user to continue to control bug with defined controls, until a
        // non-control
        // string is entered (i.e. any string besides "move", "turn", or "output")
        while (command.equalsIgnoreCase("move") || command.equalsIgnoreCase("turn")
                || command.equalsIgnoreCase("output")) {
            if (command.equals("move"))
                bug.move();
            else if (command.equals("turn"))
                bug.turn();
            else if (command.equals("output"))
                System.out.println(bug);

            System.out.print("Enter your command: ");
            command = keyboard.next();
            command = command.toLowerCase();
        }
    }
}
