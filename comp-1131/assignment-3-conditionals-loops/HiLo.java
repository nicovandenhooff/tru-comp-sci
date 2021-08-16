//****************************************************************************************************
// Hi_Lo_Game.java
//
// COMP 1131 Assignment 3 Question 1
// This application is a program that plays the Hi-Lo guessing game with a user.  The program 
// randomly generates a number between 1 to 100, and the user guesses a number.  On each guess,
// the program will report to the user if they are correct, or if the guess was high/low.
// the game continues until the user guesses right, or the user quits.  On the correct guess, the
// total number of guesses is reported.  The game will prompt the user whether or not they want
// to play again once the game finishes (when they guess right, or when they quit).
//****************************************************************************************************

import java.util.*;

public class HiLo {
    public static void main(String[] args) {
        int number, guess, total_guesses = 0;
        String again;

        Scanner keyboard = new Scanner(System.in);
        Random generator = new Random();

        // prompts the user, asks if they would like to play
        System.out.println("Welcome to the Hi-Lo guessing game!\n");
        System.out.print("Would you like to play a game? (Y / N): ");
        again = keyboard.next();

        // outer loop runs if user wants to play, and generates the correct (random)
        // number
        while (again.equalsIgnoreCase("Y")) {
            System.out.print("\nI'm thinking of a number between 1 and 100...\n");
            number = generator.nextInt(100) + 1;

            // initialize guess so that it does not match random number, and prevents
            // infinite
            // loop if user quits first game but wants to play another
            guess = -1;

            // inner loop that runs until user wins or user quits (sentinal value = 0)
            while (guess != number && guess != 0) {
                // prompts user for their guess and increments number of guesses
                System.out.print("\nEnter your guess! (0 to quit): ");
                guess = keyboard.nextInt();
                total_guesses++;

                // determines if number out of range (>= 100) or too high
                if (guess > number && guess != 0) {
                    if (guess >= 101)
                        System.out.println("Your guess should be between 1 and 100!");
                    else
                        System.out.println("Your guess is too high!");
                } else
                // determines if number out of range (<= -1) or too low
                if (guess < number && guess != 0) {
                    if (guess <= -1)
                        System.out.println("Your guess should be between 1 and 100!");
                    else
                        System.out.println("Your guess is too low!");
                } else
                // notifies user they won, asks to play again, resets guess counter
                if (guess == number) {
                    System.out.println("You got it right!  That took you " + total_guesses + " guesses\n");

                    System.out.print("Would you like to play another game? (Y / N): ");
                    again = keyboard.next();
                    total_guesses = 0;
                } else
                // notifies user they quit, asks to play again, resets guess counter
                {
                    System.out.println("You quit the game...\n");

                    System.out.print("Would you like to play another game? (Y / N): ");
                    again = keyboard.next();
                    total_guesses = 0;
                }
            }
        }
    }
}