//****************************************************************************************************
// RandomArray_Tester.java
//
// COMP 1131 Assignment 5 Question 2 (Part 2: DeskOfCards Test Driver)
// This is a test driver for the DeckOfCards Class created in Assignment 5 Question 1.
// It generate a deck of 52 cards, displays the cards, shuffles them and then deals the cards
// four at a time, displaying the # of cards left and cards dealt each deal.
//****************************************************************************************************

public class DeckOfCards_Tester {
    public static void main(String[] args) {
        // welcomes user to program, instantiates new deck of cards
        System.out.println("Card Dealing Program\n");
        DeckOfCards deck = new DeckOfCards();

        // prints out the cards in deck and then shuffles deck
        System.out.println("There are the following " + deck.remainingCards() + " cards in the deck:");
        System.out.println(deck);

        // deals deck of cards, four at a time, reporting # of cards left in deck after
        // each deal
        System.out.println("The cards were shuffled, and will now be dealt four at a time\n");
        deck.shuffle();

        for (int card = 1; card <= 13; card++) {
            for (int number = 1; number <= 4; number++)
                if (number < 4)
                    System.out.print(deck.deal() + ", ");
                else
                    System.out.print(deck.deal());

            System.out.println("\nThere are now " + deck.remainingCards() + " cards in the deck\n");
        }

        System.out.println(deck.deal());
    }
}