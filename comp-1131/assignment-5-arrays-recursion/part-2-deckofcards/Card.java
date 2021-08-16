//****************************************************************************************************
// Card.java
//
// COMP 1131 Assignment 5 Question 2 (Part 3: Card Class)
// Note: This class has been carried foward from assignment 4.
// This is a class that represents a standard playing card.  Each card will have a suit and face
// value.  The class contains private support methods that provide the text equivalent for the
// numeric face and suit value. 
//****************************************************************************************************

import java.util.Random;

public class Card {
    private int faceValue, suitValue; // numeric face & suit values
    private final int MAX_faceValue = 13; // max numeric face value (equivalent to "king")
    private final int MAX_suitValue = 4; // max suit value
    private String faceText, suitText; // text face & suit values

    // -----------------------------------------------------------------------------------------------
    // sets up a random card
    // -----------------------------------------------------------------------------------------------
    public Card() {
        Random generator = new Random();
        faceValue = generator.nextInt(MAX_faceValue) + 1;
        suitValue = generator.nextInt(MAX_suitValue) + 1;
        setFaceText();
        setSuitText();
    }

    // -----------------------------------------------------------------------------------------------
    // sets up a card, where the face value and suit value can be specified
    // -----------------------------------------------------------------------------------------------
    public Card(int num1, int num2) {
        faceValue = num1;
        suitValue = num2;
        setFaceText();
        setSuitText();
    }

    // face value mutator (the face value is not modified if the specified value is
    // not valid)
    public void setFaceValue(int value1) {
        if (value1 > 0 && value1 <= MAX_faceValue)
            faceValue = value1;
        setFaceText();
    }

    // face value accessor (numeric)
    public int getFaceValue() {
        return faceValue;
    }

    // face value accessor (text)
    public String getFaceText() {
        return faceText;
    }

    // suit value mutator (the suit value is not modified if the specified value is
    // not valid
    public void setSuitValue(int value2) {
        if (value2 > 0 && value2 <= MAX_suitValue)
            suitValue = value2;
        setSuitText();
    }

    // suit value accessor (numeric)
    public int getSuitValue() {
        return suitValue;
    }

    // suit value accessor (text)
    public String getSuitText() {
        return suitText;
    }

    // returns a string representation of a card
    public String toString() {
        String fullCard;

        fullCard = faceText + " of " + suitText;

        return fullCard;
    }

    // sets the string equivalent of a card's face value
    private void setFaceText() {
        switch (faceValue) {
            case 1:
                faceText = "Ace";
                break;
            case 2:
                faceText = "Two";
                break;
            case 3:
                faceText = "Three";
                break;
            case 4:
                faceText = "Four";
                break;
            case 5:
                faceText = "Five";
                break;
            case 6:
                faceText = "Six";
                break;
            case 7:
                faceText = "Seven";
                break;
            case 8:
                faceText = "Eight";
                break;
            case 9:
                faceText = "Nine";
                break;
            case 10:
                faceText = "Ten";
                break;
            case 11:
                faceText = "Jack";
                break;
            case 12:
                faceText = "Queen";
                break;
            case 13:
                faceText = "King";
                break;
            default:
                faceText = "Invalid card";
        }
    }

    // sets the text equivalent of a card's face value
    private void setSuitText() {
        switch (suitValue) {
            case 1:
                suitText = "Clubs";
                break;
            case 2:
                suitText = "Diamonds";
                break;
            case 3:
                suitText = "Hearts";
                break;
            case 4:
                suitText = "Spades";
                break;
            default:
                suitText = "Invalid suit";
        }
    }
}