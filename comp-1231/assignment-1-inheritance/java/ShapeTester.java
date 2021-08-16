//*************************************************************************************************************
// ShapeTester.java
//
// COMP 1231 Assignment 1: Inheritance
//
// Driver class to test the following classes: Parent class - Shape.  Child classes - Cube, Cylinder, Sphere.
//*************************************************************************************************************

import java.text.DecimalFormat;

public class ShapeTester {

    public static void main(String[] args) {
        DecimalFormat fmt = new DecimalFormat("0.##"); // formatter for printing volume/area totals
        Shape[] shapes = new Shape[6]; // array with space for 6 shapes
        double totalVolume = 0, totalSArea = 0; // counters for total volume and surface areas

        // shape # tracker used in for each loops. only need for tests, so not built
        // into parent/child classes
        int shape_number = 1;

        // create two cubes, two cylinders and two spheres
        shapes[0] = new Cube(1.7);
        shapes[1] = new Cube(1023.9);
        shapes[2] = new Cylinder(4.2, 8.7);
        shapes[3] = new Cylinder(600, 1085);
        shapes[4] = new Sphere(10000);
        shapes[5] = new Sphere(98.4);

        // print out summaries of each shape created above
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Original Shapes:");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        for (Shape shape : shapes) {
            System.out.println("Shape Number: " + shape_number);
            System.out.println(shape);
            System.out.println();
            shape_number++;
        }

        // sum the volume and surface area accross all shapes and print results
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Totals:");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        for (Shape shape : shapes) {
            totalVolume += shape.getVolume();
            totalSArea += shape.getSurfaceArea();
        }

        System.out.println("Total volume: " + fmt.format(totalVolume));
        System.out.println("Total surface area: " + fmt.format(totalSArea));

        // change the dimensions the first cube, cylinder, and sphere,which initally all
        // had zero dimensions
        ((Cube) shapes[0]).setSideLength(100);
        ((Cylinder) shapes[2]).setRadius(400);
        ((Cylinder) shapes[2]).setHeight(500);
        ((Sphere) shapes[4]).setRadius(600);

        // print out summaries of the updated shapes above
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Updated Shapes:");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        shape_number = 1; // reset shape number tracker

        // only shapes 1, 3, and 5 were updated so for loop has been coded respectively
        for (int i = 0; i < 6; i += 2) {
            System.out.println("Shape Number: " + shape_number);
            System.out.println(shapes[i]);
            System.out.println();
            shape_number += 2;
        }

        // reset total volume and surface area counters
        totalVolume = 0;
        totalSArea = 0;

        // recalculate and print out updated volume and surface area totals
        for (Shape shape : shapes) {
            totalVolume += shape.getVolume();
            totalSArea += shape.getSurfaceArea();
        }

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Updated Totals:");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Total volume: " + fmt.format(totalVolume));
        System.out.println("Total surface area: " + fmt.format(totalSArea));

        // final test for accessor methods
        // these are the same/similar accross all classes so only tested for the first
        // shape (cube 1)
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Test accessor methods (Cube 1):");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println(shapes[0].getVolume());
        System.out.println(shapes[0].getSurfaceArea());
        System.out.println(((Cube) shapes[0]).getSideLength());
    }
}
