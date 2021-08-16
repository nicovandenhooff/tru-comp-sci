//****************************************************************************************************
// RandomArray.java
//
// COMP 1131 Assignment 5 Question 1 (Part 1: RandomArray Class)
// This is a class that has an integer array.  Specifically, it's constructor receives the size of
// the array to be allocated, and populates the array with random numbers from 0 to the size of the
// array.  Thee are also methods that return the minimum, maximum, and average values of the array,
// as well as a method that returns a String representation of the array values.
//****************************************************************************************************

import java.util.Random;

public class RandomArray {
    private int[] array;
    private int minimum, maximum;

    // -----------------------------------------------------------------------------------------------
    // sets up an integer array
    // -----------------------------------------------------------------------------------------------
    public RandomArray(int size) {
        Random generator = new Random();
        array = new int[size];

        // loop to fill the array with random values
        for (int value = 0; value < array.length; value++)
            array[value] = generator.nextInt(size);
    }

    // -----------------------------------------------------------------------------------------------
    // returns the minimum value in the integer array
    // -----------------------------------------------------------------------------------------------
    public int getMinimum() {
        minimum = array[0];

        // loop that cycles through array values to find the minimum
        for (int index = 0; index < array.length; index++) {
            if (array[index] < minimum)
                minimum = array[index];
        }
        return minimum;
    }

    // -----------------------------------------------------------------------------------------------
    // returns the maximum value in the integer array
    // -----------------------------------------------------------------------------------------------
    public int getMaximum() {
        maximum = array[0];

        // loop that cycles through array values to find the maximum
        for (int index = 0; index < array.length; index++) {
            if (array[index] > maximum)
                maximum = array[index];
        }
        return maximum;
    }

    // -----------------------------------------------------------------------------------------------
    // returns the average of the integer array
    // -----------------------------------------------------------------------------------------------
    public int getAverage() {
        int total = 0;

        // loop that sums the array values
        for (int index = 0; index < array.length; index++)
            total += array[index];

        // divides the sum calculated above by the number of values in the array
        return total / array.length;
    }

    // -----------------------------------------------------------------------------------------------
    // returns a string representation of the integer array
    // -----------------------------------------------------------------------------------------------
    public String toString() {
        String arrayString = "";

        // adds all array values formatted with a comma, except last value
        for (int index = 0; index < array.length - 1; index++)
            arrayString += array[index] + ", ";

        // adds last array value to the string, with no comma at the end
        arrayString += array[array.length - 1];

        return arrayString;
    }
}