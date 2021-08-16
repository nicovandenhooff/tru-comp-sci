////******************************************************************************************************************************
// Fraction_to_Decimal.java
//
// COMP 1131 Assignment 1 Question 3
// This application prompts the user for a fraction, coverts the amount to the decimal equivalent, and displays the results.
//*******************************************************************************************************************************

import java.util.Scanner;

public class Fraction_to_Decimal {
    public static void main(String[] args) {
        // prompt the user for the numerator of the fraction
        System.out.println("Fraction to decimal converter");
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Please enter the numerator of the fraction:  ");
        int numerator = keyboard.nextInt();

        // prompt the user for the denominator of the fraction
        System.out.print("Please enter the denominator of the fraction:  ");
        int denominator = keyboard.nextInt();

        // calculates the decimal equivalent
        double decimal_equivalent = (double) numerator / denominator;

        // displays the results
        System.out.println(
                "The fraction " + numerator + "/" + denominator + " has a decimal equivalent of " + decimal_equivalent);
    }
}
