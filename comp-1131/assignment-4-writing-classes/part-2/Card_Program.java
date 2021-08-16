//****************************************************************************************************
// Card_Program.java
//
// COMP 1131 Assignment 4 Question 2 (Part2: Card Test Driver)
// This is a test driver for the Card Class created as part of Assignment 4 Question 2.  It creates
// five random cards, five specified cards, and outputs them all.
//****************************************************************************************************

public class Card_Program {
    public static void main(String[] args) {
        System.out.println("Playing Card Program\n");

        // sets up the five random cards
        Card card1 = new Card();
        Card card2 = new Card();
        Card card3 = new Card();
        Card card4 = new Card();
        Card card5 = new Card();

        // sets up the five specific cards
        Card card6 = new Card(1, 1);
        Card card7 = new Card(3, 2);
        Card card8 = new Card(7, 3);
        Card card9 = new Card(13, 4);
        Card card10 = new Card(15, 5);

        // outputs the 10 cards create above
        System.out.println("Card 1: " + card1);
        System.out.println("Card 2: " + card2);
        System.out.println("Card 3: " + card3);
        System.out.println("Card 4: " + card4);
        System.out.println("Card 5: " + card5);
        System.out.println("Card 6: " + card6);
        System.out.println("Card 7: " + card7);
        System.out.println("Card 8: " + card8);
        System.out.println("Card 9: " + card9);
        System.out.println("Card 10: " + card10);
    }
}
