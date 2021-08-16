/**
 * DropoutStackTest.Java
 * COMP 2231 Assignment 2: Part 2 Driver
 *
 * Test driver class to test the DropoutStack class.  Text exhibits includes a drop-out stack
 * of String elements.  A drop-out stack that can hold 5 Strings is tested.  Near the end of the
 * program the drop-out stack capacity is updated to 7 and then re-tested.
 * 
 * @author Nico Van den Hooff
 * @version 1.0
 */
public class DropoutStackTest
{
    public static void main (String [] args)
    {   
        // create a drop-out stack that can hold five String objects
        System.out.println("Creating a drop-out stack that can hold 5 names...");
        DropoutStack<String> names = new DropoutStack<String>(5);
        
        // add five Strings to drop-out stack
        System.out.println("Pushing five names onto the stack...");
        System.out.println();
        names.push("Nico");
        names.push("Michael");
        names.push("Andy");
        names.push("Pamela");
        names.push("Jim");
        
        // print the contents of the drop-out stack
        System.out.println("Testing the toString, peek, and size methods...");
        System.out.println("Contents of the stack: ");
        System.out.println(names);
        
        // print the output of the peek() and size() methods
        System.out.println("Top element: " + names.peek());
        System.out.println("Number of elements: " + names.size());
        System.out.println();
               
        // push a new String to the drop-out stack
        System.out.println("Adding a new name to the drop-out stack...");
        names.push("Dwight");
               
        // reprint the contents and results of the peek() and size() methods
        System.out.println("Testing the toString, peek, and size methods...");
        System.out.println("Contents of the stack: ");
        System.out.println(names);
        System.out.println("Top element: " + names.peek());
        System.out.println("Number of elements: " + names.size());
        System.out.println();
        
        // push a new String to the drop-out stack
        System.out.println("Adding a new name to the drop-out stack...");
        names.push("Kelly");
        
        // reprint the contents and results of the peek() and size() methods        
        System.out.println("Testing the toString, peek, and size methods...");
        System.out.println("Contents of the stack: ");
        System.out.println(names);
        System.out.println("Top element: " + names.peek());
        System.out.println("Number of elements: " + names.size());
        System.out.println();
        
        // pop off the top two elements of the drop-out stack
        System.out.println("Popping the top two elements from the drop-out stack...");
        System.out.println();
        names.pop();
        names.pop();
        
        // reprint the contents and results of the peek() and size() methods
        System.out.println("Testing the toString, peek, and size methods...");
        System.out.println("Contents of the stack: ");
        System.out.println(names);
        System.out.println("Top element: " + names.peek());
        System.out.println("Number of elements: " + names.size());
        System.out.println();
        
        // update max size of the drop-out stack to be seven String objects
        System.out.println("Updating the max size of the drop-out stack 7 names");
        names.setMaxSize(7);
        
        // push seven new Strings onto the drop-out stack
        System.out.println("Pushing 7 new names to the drop-out stack");
        System.out.println();
        names.push("Ryan");
        names.push("Kevin");
        names.push("Angela");
        names.push("Oscar");
        names.push("Creed");
        names.push("Daryl");
        names.push("Hank");
        
        // reprint the contents and results of the peek() and size() methods 
        System.out.println("Testing the toString, peek, and size methods...");
        System.out.println("Contents of the stack: ");
        System.out.println(names);
        System.out.println("Top element: " + names.peek());
        System.out.println("Number of elements: " + names.size());
        System.out.println();
        
    }
}
