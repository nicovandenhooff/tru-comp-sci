/**
 * DequeTest.Java
 * COMP 2231 Assignment 2: Part 3 Driver
 *
 * Test driver class to test the Deque class.  Test exhibit creates a deque of five elements.
 * First part of the test tests the addition of elements to both the front and back of the deque.
 * Second part of the test tests the removal of elements from both the front and back of the 
 * deque until it is empty.
 * 
 * @author Nico Van den Hooff
 * @version 1.0
 */
public class DequeTest
{
    public static void main (String [] args)
    {
        // create deque for test
        System.out.println("Creating a deque...\n");
        LinkedDeque<String> deque = new LinkedDeque<String>();
        
        System.out.println("---------------Test Part 1: Adding Elements to the Deque---------------");
        
        // add an element to the deque
        System.out.println("Adding an element to the empty deque...");
        deque.enqueueFirst("C");
        
        // output information on the deque
        System.out.println("Printing the deque...");
        System.out.println(deque);
        System.out.println("The front element is: " + deque.getFirst());
        System.out.println("The rear element is: " + deque.getLast());
        System.out.println("The deque contains: " + deque.size() + " elements");
        System.out.println("The deque is empty: " + deque.isEmpty() + "\n");
        
        // add an element to the front of the deque
        System.out.println("Adding an element to the front of the deque...");
        deque.enqueueFirst("B"); 
        
        // output information on the deque
        System.out.println("Printing the deque...");
        System.out.println(deque);
        System.out.println("The front element is: " + deque.getFirst());
        System.out.println("The rear element is: " + deque.getLast());
        System.out.println("The deque contains: " + deque.size() + " elements");
        System.out.println("The deque is empty: " + deque.isEmpty() + "\n");
        
        // add an element to the rear of the deque
        System.out.println("Adding an element to the rear of the deque...");
        deque.enqueueLast("D");
        
        // output information on the deque
        System.out.println("Printing the deque...");
        System.out.println(deque);
        System.out.println("The front element is: " + deque.getFirst());
        System.out.println("The rear element is: " + deque.getLast());
        System.out.println("The deque contains: " + deque.size() + " elements");
        System.out.println("The deque is empty: " + deque.isEmpty() + "\n");
        
        // add an element to the rear of the deque
        System.out.println("Adding an element to the rear of the deque...");
        deque.enqueueLast("E");
        
        // output information on the deque
        System.out.println("Printing the deque...");
        System.out.println(deque);
        System.out.println("The front element is: " + deque.getFirst());
        System.out.println("The rear element is: " + deque.getLast());
        System.out.println("The deque contains: " + deque.size() + " elements");
        System.out.println("The deque is empty: " + deque.isEmpty() + "\n");
        
        // add an element to the front of the deque
        System.out.println("Adding an element to the front of the deque...");
        deque.enqueueFirst("A"); 
        
        // output information on the deque
        System.out.println("Printing the deque...");
        System.out.println(deque);
        System.out.println("The front element is: " + deque.getFirst());
        System.out.println("The rear element is: " + deque.getLast());
        System.out.println("The deque contains: " + deque.size() + " elements");
        System.out.println("The deque is empty: " + deque.isEmpty() + "\n");
        
        System.out.println("---------------Test Part 2: Removing Elements to the Deque---------------");
        
        // remove an element from the front of the deque
        System.out.println("Removing the front element of the deque...");
        deque.dequeueFirst(); 
        
        // output information on the deque
        System.out.println("Printing the deque...");
        System.out.println(deque);
        System.out.println("The front element is: " + deque.getFirst());
        System.out.println("The rear element is: " + deque.getLast());
        System.out.println("The deque contains: " + deque.size() + " elements");
        System.out.println("The deque is empty: " + deque.isEmpty() + "\n");
        
        // remove an element from the rear of the deque
        System.out.println("Removing the rear element of the deque...");
        deque.dequeueLast(); 
        
        // output information on the deque
        System.out.println("Printing the deque...");
        System.out.println(deque);
        System.out.println("The front element is: " + deque.getFirst());
        System.out.println("The rear element is: " + deque.getLast());
        System.out.println("The deque contains: " + deque.size() + " elements");
        System.out.println("The deque is empty: " + deque.isEmpty() + "\n");
        
        // remove an element from the rear of the deque
        System.out.println("Removing the rear element of the deque...");
        deque.dequeueLast(); 
        
        // output information on the deque
        System.out.println("Printing the deque...");
        System.out.println(deque);
        System.out.println("The front element is: " + deque.getFirst());
        System.out.println("The rear element is: " + deque.getLast());
        System.out.println("The deque contains: " + deque.size() + " elements");
        System.out.println("The deque is empty: " + deque.isEmpty() + "\n");
        
        // remove an element from the front of the deque
        System.out.println("Removing the front element of the deque...");
        deque.dequeueFirst(); 
        
        // output information on the deque
        System.out.println("Printing the deque...");
        System.out.println(deque);
        System.out.println("The front element is: " + deque.getFirst());
        System.out.println("The rear element is: " + deque.getLast());
        System.out.println("The deque contains: " + deque.size() + " elements");
        System.out.println("The deque is empty: " + deque.isEmpty() + "\n");
        
        // remove the last element from the the deque
        System.out.println("Removing the last element of the deque...");
        deque.dequeueFirst(); 
        
        // output information on the deque
        System.out.println("Printing the deque...");
        System.out.println(deque);
        System.out.println("The deque contains: " + deque.size() + " elements");
        System.out.println("The deque is empty: " + deque.isEmpty() + "\n");
    }
}
