//********************************************************************************************************
// AverageCalculator.java
//
// COMP 1231 Assignment 3: Exceptions (Question 1)
//
// A program that reads a series of integers from the user and continually prints their average after
// every reading.  Input stops when the user enters "stop" as the input value.  Each input value is read
// as a string.  If the string is "stop" the program ends.  If the string is not "stop", the program first
// attempts to convert the input value to an integer.  If it is unsuccessful, a NumberFormatException is 
// thrown with an appropriate error message and the user is prompted again.  The program will continue
// until the user enters "stop".
//********************************************************************************************************

import java.util.Scanner;

public class AverageCalculator {
    public static void main(String[] args) {
        String number; // to store user input
        double n; // to convert user input to Integer as needed
        double sum = 0, average = 0; // to store the sum and average of the values entered
        int values = 0; // to store the number of values entered

        Scanner scan = new Scanner(System.in);

        // prompt the user for the first integer value
        System.out.print("Enter an integer (or stop to quit): ");
        number = scan.nextLine();

        // runs until the user enters "stop"
        while (!number.equalsIgnoreCase("stop")) {
            // attempt to convert user input to Integer and update sum, avg, and number of
            // values entered
            try {
                n = Integer.parseInt(number);

                sum += n;
                values++;
                average = sum / values;
            }
            // catches NumberFormatExceptions and notifies user of the problem
            catch (NumberFormatException exception) {
                System.out.println("Input is not an integer: " + number);
            }
            // prints the number of valid integers entered and their average after every
            // value entered
            finally {
                System.out.println("You have entered " + values + " valid integers");
                System.out.println("The average of these values is: " + average);
                System.out.println();
            }

            // prompts the user for the next integer value
            System.out.print("Enter an integer (or stop to quit): ");
            number = scan.nextLine();
        }

        // exit message
        System.out.println("Thank you for using the Average Calculator");
        System.out.println("The program will now terminate");
    }
}
