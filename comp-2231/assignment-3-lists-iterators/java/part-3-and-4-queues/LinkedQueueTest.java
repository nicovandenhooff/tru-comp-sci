/**
 * LinkedQueueTest.Java COMP 2231 Assignment 3: Part 3 Driver
 * 
 * Test driver class for the LinkedQueue class.
 * 
 * @author Nico Van den Hooff
 * @version 1.0
 */
public class LinkedQueueTest {
    public static void main(String[] args) {
        // create a new queue
        System.out.println("Creating a new LinkedQueue...");
        LinkedQueue<String> queue = new LinkedQueue<String>();

        // enqueue three items onto the queue
        System.out.println("Enqueue three items onto the queue...");
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");

        // print the queue and test queue methods
        System.out.println("Printing the queue...");
        System.out.println(queue);
        System.out.println("The first element is: " + queue.first());
        System.out.println("The queue contains: " + queue.size() + " elements");
        System.out.println("The queue is empty: " + queue.isEmpty());
        System.out.println();

        // enqueue two more items onto the queue
        System.out.println("Enqueue two more items onto the queue...");
        queue.enqueue("D");
        queue.enqueue("E");

        // print the queue and test queue methods
        System.out.println("Printing the queue...");
        System.out.println(queue);
        System.out.println("The first element is: " + queue.first());
        System.out.println("The queue contains: " + queue.size() + " elements");
        System.out.println("The queue is empty: " + queue.isEmpty());
        System.out.println();

        // Dequeue first two items from the queue
        System.out.println("Dequeue the first two items from the queue...");
        queue.dequeue();
        queue.dequeue();

        // print the queue and test queue methods
        System.out.println("Printing the queue...");
        System.out.println(queue);
        System.out.println("The first element is: " + queue.first());
        System.out.println("The queue contains: " + queue.size() + " elements");
        System.out.println("The queue is empty: " + queue.isEmpty());
        System.out.println();

        // Dequeue remaining items from the queue
        System.out.println("Dequeue the remaining items from the queue...");
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        // print the queue and test queue methods
        System.out.println("Printing the queue...");
        System.out.println(queue);
        System.out.println("The first element is: " + queue.first());
        System.out.println("The queue contains: " + queue.size() + " elements");
        System.out.println("The queue is empty: " + queue.isEmpty());
        System.out.println();
    }
}
