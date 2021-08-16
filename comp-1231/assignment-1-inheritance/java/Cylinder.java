//*************************************************************************************************************
// Cylinder.java
//
// COMP 1231 Assignment 1: Inheritance
//
// Represents a cylinder. A child class of the Shape class. Includes methods to calcuate the volume and surface
// area of a Cylinder, access or change the radius or height of a Cylinder, and includes a method to update the 
// string representation inherited from the parent class to also include the radius and height of the Cylinder.
//*************************************************************************************************************

import java.text.DecimalFormat;

public class Cylinder extends Shape {
    private double radius, height; // radius and height of a cylinder
    private final static String TYPE = "Cylinder"; // type of shape

    // ---------------------------------------------------------------------------------------------------
    // Constructor: Sets up a Cylinder object. Call's the parent's constructor and
    // set's the type of
    // Shape to "Cylinder". Call's the Cylinder method's to calculate volume and
    // surface area, and stores
    // these in the volume and surface area variables inherited from the parent
    // class.
    // ---------------------------------------------------------------------------------------------------
    public Cylinder(double r, double h) {
        super(TYPE);

        radius = r;
        height = h;
        volume = calcVolume();
        surface_area = calcSurfaceArea();
    }

    // ---------------------------------------------------------------------------------------------------
    // Calculates the volume of a Cylinder. Overrides abstract parent method.
    // ---------------------------------------------------------------------------------------------------
    public double calcVolume() {
        volume = Math.PI * Math.pow(radius, 2) * height;

        return volume;
    }

    // ---------------------------------------------------------------------------------------------------
    // Calculates the surface area of a Cylinder. Overrides abstract parent method.
    // ---------------------------------------------------------------------------------------------------
    public double calcSurfaceArea() {
        surface_area = (2.0 * Math.PI * radius * height) + (2.0 * Math.PI * Math.pow(radius, 2));

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
    // Height accesor.
    // ---------------------------------------------------------------------------------------------------
    public double getHeight() {
        return height;
    }

    // ---------------------------------------------------------------------------------------------------
    // Height mutator. Recalculates volume and surface area.
    // ---------------------------------------------------------------------------------------------------
    public void setHeight(double h) {
        height = h;
        volume = calcVolume();
        surface_area = calcSurfaceArea();
    }

    // ---------------------------------------------------------------------------------------------------
    // Overrides the Shape toString method to also include a nicely formatted string
    // representation of
    // the radius and height of a cylinder.
    // ---------------------------------------------------------------------------------------------------
    public String toString() {
        DecimalFormat fmt = new DecimalFormat("0.##");
        return super.toString() + "\nRadius: " + fmt.format(radius) + "\nHeight: " + fmt.format(height);
    }
}