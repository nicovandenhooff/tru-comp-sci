/**
 * LinkedStackTest.Java COMP 2231 Assignment 3: Part 1 Driver
 * 
 * Test driver class for the LinkedStack class.
 * 
 * @author Nico Van den Hooff
 * @version 1.0
 */
public class LinkedStackTest {
    public static void main(String[] args) {
        // create a new stack
        System.out.println("Creating a new LinkedStack...");
        LinkedStack<String> stack = new LinkedStack<String>();

        // push three items onto the stack
        System.out.println("Pushing three items onto the stack...");
        stack.push("A");
        stack.push("B");
        stack.push("C");

        // print the stack and test stack methods
        System.out.println("Printing the stack...");
        System.out.println(stack);
        System.out.println("The top element is: " + stack.peek());
        System.out.println("The stack contains: " + stack.size() + " elements");
        System.out.println("The stack is empty: " + stack.isEmpty());
        System.out.println();

        // push two more items onto the stack
        System.out.println("Pushing two more items onto the stack...");
        stack.push("D");
        stack.push("E");

        // print the stack and test stack methods
        System.out.println("Printing the stack...");
        System.out.println(stack);
        System.out.println("The top element is: " + stack.peek());
        System.out.println("The stack contains: " + stack.size() + " elements");
        System.out.println("The stack is empty: " + stack.isEmpty());
        System.out.println();

        // pop top two items from the stack
        System.out.println("Popping the top two items from the stack...");
        stack.pop();
        stack.pop();

        // print the stack and test stack methods
        System.out.println("Printing the stack...");
        System.out.println(stack);
        System.out.println("The top element is: " + stack.peek());
        System.out.println("The stack contains: " + stack.size() + " elements");
        System.out.println("The stack is empty: " + stack.isEmpty());
        System.out.println();

        // pop remaining items from the stack
        System.out.println("Popping the remaining items from the stack...");
        stack.pop();
        stack.pop();
        stack.pop();

        // print the stack and test stack methods
        System.out.println("Printing the stack...");
        System.out.println(stack);
        System.out.println("The top element is: " + stack.peek());
        System.out.println("The stack contains: " + stack.size() + " elements");
        System.out.println("The stack is empty: " + stack.isEmpty());
        System.out.println();
    }
}
