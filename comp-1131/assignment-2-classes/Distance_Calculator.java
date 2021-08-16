//****************************************************************************************************
// Distance_Calculator.java
//
// COMP 1131 Assignment 2 Question 2
// This application prompts the user for two (x, y) coordinates, and then calculates and returns
// the distance between the two points.
//****************************************************************************************************

import java.util.Scanner;

public class Distance_Calculator {
    public static void main(String[] args) {
        int x1, y1, x2, y2;
        double power1, power2, distance;

        Scanner keyboard = new Scanner(System.in);

        // prompt user for the two sets of (x, y) coordinates
        System.out.println("Calculator for distance between two (x, y) coordinates\n");
        System.out.print("Please enter the first x coordinate: ");
        x1 = keyboard.nextInt();

        System.out.print("Please enter the first y coordinate: ");
        y1 = keyboard.nextInt();

        System.out.print("\nPlease enter the second x coordinate: ");
        x2 = keyboard.nextInt();

        System.out.print("Please enter the second y coordinate: ");
        y2 = keyboard.nextInt();

        // calculates the distance between the two points entered by the user
        power1 = Math.pow((x2 - x1), 2);
        power2 = Math.pow((y2 - y1), 2);
        distance = Math.sqrt(power1 + power2);

        // displays the results
        System.out.println(
                "\nThe distance between (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")" + " is: " + distance);
    }
}