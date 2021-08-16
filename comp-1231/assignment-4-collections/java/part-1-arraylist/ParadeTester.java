/**
 * ParadeTester.Java
 * COMP 1231 Assignment 4: Collections (Question 1)
 *
 * Test driver for Parade and Clown classes.
 *
 * @author Nico Van den Hooff
 * @version 1.0
 */
public class ParadeTester
{
    /**
     * Creates a Parade of Clowns and tests the behaviors of both classes
     */
    public static void main(String[] args)
    {
        // create a new Parade
        System.out.println("Creating a new Parade...");
        Parade myParade = new Parade();

        // create 6 new Clowns
        System.out.println("Creating some Clowns...");
        Clown clown1 = new Clown("Nico");
        Clown clown2 = new Clown("Dominic");
        Clown clown3 = new Clown("Lela");
        Clown clown4 = new Clown("Jax");
        Clown clown5 = new Clown("Sophie");
        Clown clown6 = new Clown("Katie");

        // add the first 4 Clowns to the Parade
        System.out.println("Adding some Clowns to the parade...");
        myParade.add(clown1);
        myParade.add(clown2);
        myParade.add(clown3);
        myParade.add(clown4);

        // print the Parade
        System.out.println("Printing the Parade...");
        System.out.println();
        System.out.print(myParade);

        // test the isFront method from the Parade class
        System.out.println();
        System.out.println("Checking if these Clowns are at the front of the parade...");
        System.out.println("Nico is at the front of the parade: " + myParade.isFront(clown1));
        System.out.println("Lela is at the front of the parade: " + myParade.isFront(clown3));

        // test the size method from the Parade class
        System.out.println();
        System.out.println("Getting the size of the parade...");
        System.out.println("The current size of the parade is: " + myParade.size());

        // remove the first two Clowns from the Parade
        System.out.println();
        System.out.println("Removing the first two Clowns from the Parade...");
        myParade.remove();
        myParade.remove();

        // Reprint the parade showing the Clowns have been removed and indicies are updated
        System.out.println("Reprinting the Parade...");
        System.out.println();
        System.out.print(myParade);

        // Now add Clowns 5 and 6 to the Parade
        System.out.println();
        System.out.println("Adding some more Clowns to the Parade...");
        myParade.add(clown5);
        myParade.add(clown6);

        // Reprint the Parade
        System.out.println("Reprinting the Parade...");
        System.out.println();
        System.out.print(myParade);

        // Now this section will test the methods of Clown class
        System.out.println();
        System.out.println("Testing methods of Clown class now...");
        System.out.println("Changing the names some Clowns");

        // Change the name of Clowns 5 and 6
        clown5.setName("Bill");
        clown6.setName("Jack");

        // Test the equals method and toString method of the Clown class
        System.out.println();
        System.out.println("Testing to see if Clowns names are equal");
        System.out.println("clown5 name is " + clown5);
        System.out.println("clown6 name is " + clown6);
        System.out.println("Names are equal: " + clown5.equals(clown6));
    }
}
