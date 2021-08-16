//****************************************************************************************************
// Vowel_Counter.java
// 
// COMP 1131 Assignment 3 Question 2
// This application prompts the user to enter a string, and then will determine and display
// how many (of each) vowels (a, e, i, o, and u) appear in the string.  The number of non-vowel
// characters is also displayed. 
//****************************************************************************************************

import java.util.Scanner;

public class Vowel_Counter {
    public static void main(String[] args) {
        int a = 0, e = 0, i = 0, o = 0, u = 0, non_vowel = 0, spaces = 0, left = 0;
        String str;

        Scanner keyboard = new Scanner(System.in);

        // prompts the user to enter a String
        System.out.println("Welcome to the vowel counting program!\n");
        System.out.print("Please enter a string: ");
        str = keyboard.nextLine();

        // coverts String to lowercase for purposes of counting each character
        str = str.toLowerCase();

        // loop to count vowels and non-vowels in the String
        // loop terminates when String length = total characters counted
        while (str.length() != (a + e + i + o + u + non_vowel + spaces)) {
            // each case looks for a vowel, non-vowel, or space, at each index in the String
            switch (str.charAt(left)) {
                case 'a':
                    a++;
                    left++;
                    break;

                case 'e':
                    e++;
                    left++;
                    break;

                case 'i':
                    i++;
                    left++;
                    break;

                case 'o':
                    o++;
                    left++;
                    break;

                case 'u':
                    u++;
                    left++;
                    break;

                case ' ':
                    spaces++;
                    left++;
                    break;

                default:
                    non_vowel++;
                    left++;
            }
        }
        // displays the results (but does not display # of spaces)
        System.out.println("\nThe word you entered contains: " + "\na: " + a + "\ne: " + e + "\ni: " + i + "\no: " + o
                + "\nu: " + u + "\nnon-vowels: " + non_vowel);
    }
}
