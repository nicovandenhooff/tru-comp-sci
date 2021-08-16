//******************************************************************************************************************************
// Miles_to_KM_Converter.java
//
// COMP 1131 Assignment 1 Question 1
// This application prompts the user for a distance in miles, coverts the amount to an equivalent distance in kilometers, 
// and then displays both distances.
//******************************************************************************************************************************

import java.util.Scanner;

public class Miles_to_KM_Converter {
    public static void main(String[] args) {
        // sets up conversion factor as a constant
        final float CONVERSION_FACTOR = 1.60935F;

        // prompt the user for input of a distance in miles
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Miles to Kilometers Converter");
        System.out.print("Please enter a distance: ");
        float miles = keyboard.nextFloat();

        // coverts user input into kilometers
        float kilometers = miles * CONVERSION_FACTOR;

        // displays the results
        System.out.println("Distance in miles = " + miles);
        System.out.println("Distance in kilometers = " + kilometers);
    }
}
