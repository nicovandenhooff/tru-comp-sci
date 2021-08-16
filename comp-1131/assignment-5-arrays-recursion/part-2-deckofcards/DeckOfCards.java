//****************************************************************************************************
// DeckOfCards.java
//
// COMP 1131 Assignment 5 Question 2 (Part 1: DeckOfCards Class)
// This is a class that stores 52 objects of the Card class to represent a full deck of cards.
// The class includes methods to shuffle the deck, deal a card, and report the number of cards that
// remain in the deck.
//****************************************************************************************************

import java.util.Random;

public class DeckOfCards {
    private Card[] deckofcards; // array to hold a deck of cards
    private int topcard; // top card on a deck
    private final int MAX_CARDS = 52; // max # of cards in a deck

    // -----------------------------------------------------------------------------------------------
    // sets up a deck of cards
    // -----------------------------------------------------------------------------------------------
    public DeckOfCards() {
        deckofcards = new Card[MAX_CARDS];
        int index = 0;

        // nested for loops to assign one of each face/suit pair to the deck
        for (int face = 1; face <= 13; face++)
            for (int suit = 1; suit <= 4; suit++) {
                deckofcards[index++] = new Card(face, suit);
            }

        // sets the top card of the deck as 0
        topcard = 0;
    }

    // -----------------------------------------------------------------------------------------------
    // shuffles the deck of cards
    // -----------------------------------------------------------------------------------------------
    public void shuffle() {
        Random generator = new Random();
        Card temp = new Card();
        int rand_card1, rand_card2;

        // loop that swaps random pairs of cards in the deck 52 times, to simulate
        // shuffling
        for (int cards = 1; cards <= MAX_CARDS; cards++) {
            rand_card1 = generator.nextInt(MAX_CARDS);
            rand_card2 = generator.nextInt(MAX_CARDS);

            // temporary memory space to store first random card value
            temp = deckofcards[rand_card1];

            // swaps location of the two random cards generated
            deckofcards[rand_card1] = deckofcards[rand_card2];
            deckofcards[rand_card2] = temp;
        }
    }

    // -----------------------------------------------------------------------------------------------
    // deals the top card of the deck
    // -----------------------------------------------------------------------------------------------
    public String deal() {
        String card_dealt = "";

        // returns current top card of the deck, unless all cards have been dealt
        if (topcard < MAX_CARDS) {
            card_dealt = deckofcards[topcard].toString();
            topcard++;
        } else
            card_dealt = "There are no more cards in the deck to deal!";

        return card_dealt;
    }

    // -----------------------------------------------------------------------------------------------
    // returns the number of cards remaining in the deck
    // -----------------------------------------------------------------------------------------------
    public int remainingCards() {
        return MAX_CARDS - topcard;
    }

    // -----------------------------------------------------------------------------------------------
    // returns a string representation of the deck of cards
    // -----------------------------------------------------------------------------------------------
    public String toString() {
        String deckString = "";
        int index = 0;

        // nested loops to print cards in rows that have 4 columns each
        for (int face = 1; face <= 13; face++) {
            for (int suit = 1; suit <= 4; suit++) {
                // formats each card string to print uniformly in table
                deckString += String.format("%-17s", deckofcards[index]) + "\t";
                index++;
            }
            deckString += "\n";
        }

        return deckString;
    }
}