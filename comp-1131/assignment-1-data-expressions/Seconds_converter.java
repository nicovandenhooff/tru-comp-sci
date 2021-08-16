//******************************************************************************************************************************
// Seconds_converter.java
//
// COMP 1131 Assignment 1 Question 2
// This application prompts the user for an amount of time in seconds, coverts the amount to an equivalent time in HH:MM:SS, 
// and then displays the results.  The converted time is displayed as "## Hours, ## Minutes, and ## of Seconds".
//******************************************************************************************************************************

import java.util.Scanner;

public class Seconds_converter {
    public static void main(String[] args) {
        // prompt the user for an input of time in seconds
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Seconds to detailed time converter");
        System.out.print("Please enter an amount of seconds: ");
        int seconds_input = keyboard.nextInt();

        // converts user input into hours, minutes, seconds
        int hours = seconds_input / 3600;
        int minutes = (seconds_input % 3600) / 60;
        int seconds_output = (seconds_input % 60);

        // displays the results
        System.out.println("This amount of seconds: " + seconds_input);
        System.out.println(
                "Is equivalent to " + hours + " Hours, " + minutes + " Minutes, and " + seconds_output + " seconds.");
    }
}
