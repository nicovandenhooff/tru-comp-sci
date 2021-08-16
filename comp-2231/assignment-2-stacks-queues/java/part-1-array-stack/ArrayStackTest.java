/**
 * ArrayStackTest.Java COMP 2231 Assignment 2: Part 1 Driver
 *
 * Test driver class to test the updated ArrayStack class. Text exhibits include
 * a stack of Integer values, and a stack of String values in order to test
 * multiple data types.
 * 
 * @author Nico Van den Hooff
 * @version 1.0
 */

public class ArrayStackTest {
    public static void main(String[] args) {
        // create stack to hold Integer values
        ArrayStack<Integer> integerStack = new ArrayStack<Integer>();

        // create stack to hold String values
        ArrayStack<String> stringStack = new ArrayStack<String>();

        // first test exhibit: Integer stack
        System.out.println("-----------------Test case 1: Integer Stack-----------------");
        System.out.println("Pushing some Integers onto the stack...");
        System.out.println();

        // push 5 Integers onto the Intger stack
        integerStack.push(-5);
        integerStack.push(0);
        integerStack.push(7);
        integerStack.push(20);
        integerStack.push(1000);

        // print the Integer stack
        System.out.println("Printing the stack...");
        System.out.println(integerStack);

        // test out updated methods and print the results
        System.out.println("Testing some stack methods and printing the results...");
        System.out.println("The stack currently contains: " + integerStack.size() + " elements.");
        System.out.println("The top of the stack contains: " + integerStack.peek());
        System.out.println("The stack is empty: " + integerStack.isEmpty());
        System.out.println();

        // pop top 2 elements from the Integer stack
        System.out.println("Popping some elements from the stack...");
        System.out.println();
        integerStack.pop();
        integerStack.pop();

        // reprint the Integer stack
        System.out.println("Reprinting the stack...");
        System.out.println(integerStack);

        // test out updated methods and print the results
        System.out.println("Testing some stack methods and printing the results...");
        System.out.println("The stack currently contains: " + integerStack.size() + " elements.");
        System.out.println("The top of the stack contains: " + integerStack.peek());
        System.out.println("The stack is empty: " + integerStack.isEmpty());
        System.out.println();

        // pop all remaining elements from the integer Stack
        System.out.println("Popping the remaining elements from the stack...");
        System.out.println();
        integerStack.pop();
        integerStack.pop();
        integerStack.pop();

        // reprint the Integer stack
        System.out.println("Reprinting the stack...");
        System.out.println(integerStack);

        // test out updated methods and print the results
        System.out.println("Testing some stack methods and printing the results...");
        System.out.println("The stack currently contains: " + integerStack.size() + " elements.");
        System.out.println("The stack is empty: " + integerStack.isEmpty());
        System.out.println();

        // first test exhibit: String stack
        System.out.println("-----------------Test case 2: String Stack-----------------");

        System.out.println("Pushing some Strings onto the stack...");
        System.out.println();

        // push 6 Strings onto the String stack
        stringStack.push("Hello");
        stringStack.push("World");
        stringStack.push("Java");
        stringStack.push("is");
        stringStack.push("cool");
        stringStack.push("!!!");

        // print the String stack
        System.out.println("Printing the stack...");
        System.out.println(stringStack);

        // test out updated methods and print the results
        System.out.println("Testing some stack methods and printing the results...");
        System.out.println("The stack currently contains: " + stringStack.size() + " elements.");
        System.out.println("The top of the stack contains: " + stringStack.peek());
        System.out.println("The stack is empty: " + stringStack.isEmpty());
        System.out.println();

        // pop top 4 elements from the String stack
        System.out.println("Popping some elements from the stack...");
        System.out.println();
        stringStack.pop();
        stringStack.pop();
        stringStack.pop();
        stringStack.pop();

        // print the String stack
        System.out.println("Reprinting the stack...");
        System.out.println(stringStack);

        // test out updated methods and print the results
        System.out.println("Testing some stack methods and printing the results...");
        System.out.println("The stack currently contains: " + stringStack.size() + " elements.");
        System.out.println("The top of the stack contains: " + stringStack.peek());
        System.out.println("The stack is empty: " + stringStack.isEmpty());
        System.out.println();

        // pop all remaining elements from the String Stack
        System.out.println("Popping the remaining elements from the stack...");
        System.out.println();
        stringStack.pop();
        stringStack.pop();

        // print the String stack
        System.out.println("Reprinting the stack...");
        System.out.println(stringStack);

        // test out updated methods and print the results
        System.out.println("Testing some stack methods and printing the results...");
        System.out.println("The stack currently contains: " + stringStack.size() + " elements.");
        System.out.println("The stack is empty: " + stringStack.isEmpty());
        System.out.println();
    }
}
