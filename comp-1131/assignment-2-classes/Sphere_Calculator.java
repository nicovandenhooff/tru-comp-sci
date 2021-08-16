//****************************************************************************************************
// Sphere_Calculator.java
//
// COMP 1131 Assignment 2 Question 3
// This application prompts the user for the radius of a sphere and then uses this to calculate
// the sphere's volume and surface area, both rounded to four decimal places.
//****************************************************************************************************

import java.util.Scanner;
import java.text.DecimalFormat;

public class Sphere_Calculator {
    public static void main(String[] args) {
        double radius, volume, surface_area;

        Scanner keyboard = new Scanner(System.in);
        DecimalFormat fmt = new DecimalFormat("0.####");

        // prompt the user for the radius of a sphere
        System.out.println("Calculator for the volume and surface area of a sphere\n");
        System.out.print("Please enter the radius of a sphere ");
        radius = keyboard.nextDouble();

        // calculates the volume of the sphere
        volume = 4.0 / 3.0 * Math.PI * Math.pow(radius, 3);

        // calculates the surface area of the sphere
        surface_area = 4 * Math.PI * Math.pow(radius, 2);

        // displays the results rounded to four decimal places
        System.out.println("\nFor a sphere with a raidus of " + radius);
        System.out.println("The volume of the sphere is " + fmt.format(volume));
        System.out.println("The surface area of the sphere is " + fmt.format(surface_area));
    }
}