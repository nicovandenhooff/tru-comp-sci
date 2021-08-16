//********************************************************************************************************
// Priority.java
//
// COMP 1231 Assignment 2: Polymorphism (Question 1)
//
// Represents an interface for purposes of establishing a numeric priority among a set of objects.
// Contains constants for priority levels and methods to set/get a priority.
//********************************************************************************************************

public interface Priority {
    // priority constants
    public int LOW = 1;
    public int MEDIUM = 5;
    public int HIGH = 10;

    // methods to get or set a priority
    public int getPriority();

    public void setPriority(int p);
}