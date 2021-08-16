//********************************************************************************************************
// Shape.java
//
// COMP 1231 Assignment 1: Inheritance
//
// Represents a three-dimensional shape.  To be used as the parent of a derived class.  Contains abstract
// methods to calculate volume and surface area which are defined in detail in each child class.  Also 
// contains non-abstract methods to access a shape's volume or surface area, as well as to print a nicely
// formatted string representation of a shape.
//********************************************************************************************************

import java.text.DecimalFormat;

public abstract class Shape {
    protected double volume, surface_area; // volume and surface area of a Shape
    protected String shape_type; // the type of shape (e.g. sphere)

    // ---------------------------------------------------------------------------------------------------
    // Constructor: Sets up a Shape object with the specificed Shape type.
    // ---------------------------------------------------------------------------------------------------
    public Shape(String type) {
        shape_type = type;
    }

    // ---------------------------------------------------------------------------------------------------
    // Calculates the volume of a Shape. Explicitly defined in each child class
    // since the calculation
    // of volume depends on the type of Shape.
    // ---------------------------------------------------------------------------------------------------
    public abstract double calcVolume();

    // ---------------------------------------------------------------------------------------------------
    // Calculates the surface area of a Shape. Explicitly defined in each child
    // class since the
    // calculation of surface area depends on the type of Shape.
    // ---------------------------------------------------------------------------------------------------
    public abstract double calcSurfaceArea();

    // ---------------------------------------------------------------------------------------------------
    // Volume accesor. Declared with final so that child class cannot override by
    // accident.
    // ---------------------------------------------------------------------------------------------------
    public final double getVolume() {
        return volume;
    }

    // ---------------------------------------------------------------------------------------------------
    // Surface Area accesor. Declared with final so that child class cannot override
    // by accident.
    // ---------------------------------------------------------------------------------------------------
    public final double getSurfaceArea() {
        return surface_area;
    }

    // ---------------------------------------------------------------------------------------------------
    // Returns a nicely formatted string representation of a Shape, including the
    // type of Shape, it's
    // volume, and it's surface area.
    // ---------------------------------------------------------------------------------------------------
    public String toString() {
        String description;
        DecimalFormat fmt = new DecimalFormat("0.##");

        description = "Shape Type: " + shape_type + "\n" + "Volume : " + fmt.format(volume) + "\n" + "Surface Area : "
                + fmt.format(surface_area);

        return description;
    }
}