//*************************************************************************************************************
// Sphere.java
//
// COMP 1231 Assignment 1: Inheritance
//
// Represents a sphere.  A child class of the Shape class.  Includes methods to calcuate the volume and surface
// area of a Sphere, access or change the radius of a Sphere, and includes a method to update the string
// representation inherited from the parent class to also include the radius of the Sphere.
//*************************************************************************************************************

import java.text.DecimalFormat;

public class Sphere extends Shape {
    private double radius; // radius of a sphere
    private final static String TYPE = "Sphere"; // type of shape

    // ---------------------------------------------------------------------------------------------------
    // Constructor: Sets up a Sphere object. Call's the parent's constructor and
    // set's the type of
    // Shape to "Sphere". Call's the Sphere method's to calculate volume and surface
    // area, and stores
    // these in the volume and surface area variables inherited from the parent
    // class.
    // ---------------------------------------------------------------------------------------------------
    public Sphere(double r) {
        super(TYPE);

        radius = r;
        volume = calcVolume();
        surface_area = calcSurfaceArea();
    }

    // ---------------------------------------------------------------------------------------------------
    // Calculates the volume of a Sphere. Overrides abstract parent method.
    // ---------------------------------------------------------------------------------------------------
    public double calcVolume() {
        volume = 4.0 / 3.0 * Math.PI * Math.pow(radius, 3);

        return volume;
    }

    // ---------------------------------------------------------------------------------------------------
    // Calculates the surface area of a Sphere. Overrides abstract parent method.
    // ---------------------------------------------------------------------------------------------------
    public double calcSurfaceArea() {
        surface_area = 4.0 * Math.PI * Math.pow(radius, 2);

        return surface_area;
    }

    // ---------------------------------------------------------------------------------------------------
    // Radius accesor.
    // ---------------------------------------------------------------------------------------------------
    public double getRadius() {
        return radius;
    }

    // ---------------------------------------------------------------------------------------------------
    // Radius mutator. Reclaculates volume and surface area.
    // ---------------------------------------------------------------------------------------------------
    public void setRadius(double r) {
        radius = r;
        volume = calcVolume();
        surface_area = calcSurfaceArea();
    }

    // ---------------------------------------------------------------------------------------------------
    // Overrides the Shape toString method to also include a nicely formatted string
    // representation of
    // the radius of a sphere.
    // ---------------------------------------------------------------------------------------------------
    public String toString() {
        DecimalFormat fmt = new DecimalFormat("0.##");
        return super.toString() + "\nRadius: " + fmt.format(radius);
    }
}