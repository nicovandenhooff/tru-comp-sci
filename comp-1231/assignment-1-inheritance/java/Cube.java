//*************************************************************************************************************
// Cube.java
//
// COMP 1231 Assignment 1: Inheritance
//
// Represents a cube.  A child class of the Shape class.  Includes methods to calcuate the volume and surface
// area of a Cube, access or change the side length of a Cube, and includes a method to update the string
// representation inherited from the parent class to also include the side length of the Cube.
//*************************************************************************************************************

import java.text.DecimalFormat;

public class Cube extends Shape {
    private double sideLength; // side length of a cube
    private final static String TYPE = "Cube"; // type of shape

    // ---------------------------------------------------------------------------------------------------
    // Constructor: Sets up a Cube object. Call's the parent's constructor and set's
    // the type of
    // Shape to "Cube". Call's the Cube method's to calculate volume and surface
    // area, and stores
    // these in the volume and surface area variables inherited from the parent
    // class.
    // ---------------------------------------------------------------------------------------------------
    public Cube(double s) {
        super(TYPE);

        sideLength = s;
        volume = calcVolume();
        surface_area = calcSurfaceArea();
    }

    // ---------------------------------------------------------------------------------------------------
    // Calculates the volume of a Cube. Overrides abstract parent method.
    // ---------------------------------------------------------------------------------------------------
    public double calcVolume() {
        volume = Math.pow(sideLength, 3);

        return volume;
    }

    // ---------------------------------------------------------------------------------------------------
    // Calculates the surface area of a Cube. Overrides abstract parent method.
    // ---------------------------------------------------------------------------------------------------
    public double calcSurfaceArea() {
        surface_area = 6.0 * Math.pow(sideLength, 2);

        return surface_area;
    }

    // ---------------------------------------------------------------------------------------------------
    // Side length accesor.
    // ---------------------------------------------------------------------------------------------------
    public double getSideLength() {
        return sideLength;
    }

    // ---------------------------------------------------------------------------------------------------
    // Side length mutator. Recalculates volume and surface area.
    // ---------------------------------------------------------------------------------------------------
    public void setSideLength(double s) {
        sideLength = s;
        volume = calcVolume();
        surface_area = calcSurfaceArea();
    }

    // ---------------------------------------------------------------------------------------------------
    // Overrides the Shape toString method to also include a nicely formatted string
    // representation of
    // the sideLength of a sphere.
    // ---------------------------------------------------------------------------------------------------
    public String toString() {
        DecimalFormat fmt = new DecimalFormat("0.##");
        return super.toString() + "\nSide Length: " + fmt.format(sideLength);
    }
}