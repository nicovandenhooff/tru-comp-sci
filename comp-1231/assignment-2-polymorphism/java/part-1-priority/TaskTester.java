//*************************************************************************************************************
// TaskTester.java
//
// COMP 1231 Assignment 2: Polymorphism (Question 1)
//
// Driver class to test the Task class and Priority inteface.
//*************************************************************************************************************

import java.util.*;

public class TaskTester {
    public static void main(String[] args) {
        Random generator = new Random(); // used to reassign priorities later
        Task[] tasks = new Task[5]; // set up array to hold 5 Tasks

        // create 5 Task objects, testing both constructors
        System.out.println("Creating some tasks...");
        tasks[0] = new Task("Do homework", 8);
        tasks[1] = new Task("Grocery shopping", 4);
        tasks[2] = new Task("Buy new shoes", 1);
        tasks[3] = new Task("Call mom", 10);
        tasks[4] = new Task("Workout");

        // set the 5th Task's priority since alternative constructor was used to
        // initialize it
        tasks[4].setPriority(7);

        // print the tasks
        System.out.println("Printing the tasks...");
        for (Task task : tasks) {
            System.out.println("-----------------------------------------");
            System.out.println(task);
            System.out.println("-----------------------------------------");
        }

        // randomly reassign priority values between 1 to 10
        System.out.println("\nRandomly reassigning priorities...");
        for (Task task : tasks) {
            int randomPriority = generator.nextInt(10) + 1;
            task.setPriority(randomPriority);
        }

        // print the tasks again with new priority values
        System.out.println("Reprinting the tasks...");
        for (Task task : tasks) {
            System.out.println("-----------------------------------------");
            System.out.println(task);
            System.out.println("-----------------------------------------");
        }

        // sort the tasks based on highest priority to lowest
        System.out.println("\nSorting the tasks...");
        Arrays.sort(tasks, Collections.reverseOrder());

        // print the tasks again with ranked priorities
        System.out.println("Printing the sorted tasks...");
        for (Task task : tasks) {
            System.out.println("-----------------------------------------");
            System.out.println(task);
            System.out.println("-----------------------------------------");
        }

        // reset tasks 1, 2, 3, 4 to priorities LOW (1), MEDIUM (5), HIGH (10), and HIGH
        // (10)
        System.out.println("\nResetting priorities for tasks 1 to 4...");
        tasks[0].setPriority(Priority.LOW);
        tasks[1].setPriority(Priority.MEDIUM);
        tasks[2].setPriority(Priority.HIGH);
        tasks[3].setPriority(Priority.HIGH);

        // print the updated priorities
        System.out.println("Printing updated priorities for tasks 1 to 4...");
        System.out.println(tasks[0].getPriority());
        System.out.println(tasks[1].getPriority());
        System.out.println(tasks[2].getPriority());
        System.out.println(tasks[3].getPriority());

        // test and print each compareTo scenario
        System.out.println("\nTesting compareTo method...");
        System.out.println(tasks[0].compareTo(tasks[1])); // return should be -1
        System.out.println(tasks[2].compareTo(tasks[1])); // return should be 1
        System.out.println(tasks[2].compareTo(tasks[3])); // return should be 0
    }
}
