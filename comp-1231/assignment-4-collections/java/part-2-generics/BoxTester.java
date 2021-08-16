/**
 * BoxTester.Java COMP 1231 Assigment 4: Collections (Question 2)
 * 
 * Test driver class for the Box generic class.
 *
 * @author Nico Van den Hooff
 * @version 1.0
 */
public class BoxTester {
    /**
     * Creates two boxes, one with the names of five people, and another with the
     * numbers between one and five, representing seating at a table. Tests Box's
     * methods and uses the drawItem() method to determine which seat a person will
     * occupy.
     */
    public static void main(String[] args) {
        // create two boxes with capacities of 5 each to hold names and numbers
        System.out.println("Creating a Box to hold names, and Box to hold numbers...");
        Box<String> names = new Box<String>(5);
        Box<Integer> numbers = new Box<Integer>(5);

        // add 5 names to the names box
        System.out.println("Adding some names to the names box...");
        names.add("Nico");
        names.add("John");
        names.add("Jayden");
        names.add("David");
        names.add("Rachel");

        // add the numbers 1 thru 5 to the number box
        System.out.println("Adding some numbers to the number box...");
        for (int i = 1; i <= 5; i++)
            numbers.add(i);

        // test Box's isEmpty method and print results
        System.out.println();
        System.out.println("Testing if the boxes are empty...");
        System.out.println("The names box is empty: " + names.isEmpty());
        System.out.println("The numbers box is empty: " + names.isEmpty());
        System.out.println();

        // test Box's toString method by printing the contents of the boxes
        System.out.println("Printing the contents of the boxes...");
        System.out.println("The names box contains: \n" + names);
        System.out.println("The numbers box contains: \n" + numbers);

        // randomly select both a name and a number and assign each person to the random
        // seat
        System.out.println("Deciding who will sit at each seat...");
        for (int i = 1; i <= 5; i++) {
            System.out.println(names.drawItem() + " will sit at seat " + numbers.drawItem());
        }

        // retest the isEmpty method on the empty boxes
        System.out.println();
        System.out.println("Testing if the boxes are empty...");
        System.out.println("The names box is empty: " + names.isEmpty());
        System.out.println("The numbers box is empty: " + names.isEmpty());

        // reprint the contents of the boxes which should be empty
        System.out.println();
        System.out.println("Printing the contents of the boxes...");
        System.out.println("The names box contains: \n" + names);
        System.out.println("The numbers box contains: \n" + numbers);

        // try to draw an item from the empty boxes and print the results
        System.out.println();
        System.out.println("Attemping to draw an item from the empty boxes...");
        System.out.println("Names box draw: " + names.drawItem());
        System.out.println("Number box draw: " + numbers.drawItem());
    }
}
