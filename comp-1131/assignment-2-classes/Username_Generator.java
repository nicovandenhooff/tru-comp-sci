//****************************************************************************************************
// Username_Generator.java
//
// COMP 1131 Assignment 2 Question 1
// This application prompts the user for their first and last name, and then uses this to create a
// username, consisting of the first letter of their first name, first five characters of their last
// name, and a random number in the range 10 to 99.
//****************************************************************************************************

import java.util.*;

public class Username_Generator {
    public static void main(String[] args) {
        String first_name, last_name, part2;
        char part1;
        int random_num, part3;

        Scanner keyboard = new Scanner(System.in);
        Random generator = new Random();

        // prompt user for first and last name
        System.out.println("Username Generator");
        System.out.print("Please enter your first name: ");
        first_name = keyboard.next();

        System.out.print("Please enter your last name: ");
        last_name = keyboard.next();

        // generates a username using first letter of first name, last 5 characters of
        // last name
        // and a random number in the range of 10 to 99

        random_num = generator.nextInt(90) + 10;
        part1 = first_name.charAt(0);
        part2 = last_name.substring(0, 5);
        part3 = random_num;

        // displays the username
        System.out.println("Your username is: " + part1 + part2 + part3);
    }
}
