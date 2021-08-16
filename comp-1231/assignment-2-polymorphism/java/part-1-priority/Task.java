//*************************************************************************************************************
// Task.java
//
// COMP 1231 Assignment 2: Polymorphism (Question 1)
//
// Represents a task (e.g. something on a to-do list).  Implements the Priority and Comparable interfaces.
// Each Task object contains instance data for it's description, priority (numeric and text represetations).
// Includes two constructors, one to set up a Task object by specifying both a description and numeric priority
// and an alternative one to set up a Task only based on a Task's description.  Includes public methods to:
// get or set a Task's numeric priority, get or set a Task's description, compare one Task object to another,
// print a nicely formatted version of a Task.  Also includes a private support method to set the text
// representation of a numeric priority based on a range that utilizes the constants from the priority  
// interface.  Text priorities are set as: LOW (1 to 4), MEDIUM (5 to 7), HIGH (8 to 10).
//*************************************************************************************************************

public class Task implements Priority, Comparable {
    private String description; // a Task's description
    private int priority; // a Task's numeric priority (e.g. 1)
    private String priorityText; // a Task's text priority (LOW)

    // ---------------------------------------------------------------------------------------------------
    // Constructor #1: Sets up a Task object. Accepts a Task's description as a
    // string and priority
    // level as an integer. Calls support method setPriorityText to initially set a
    // Task's text
    // representation of it's numeric priority.
    // ---------------------------------------------------------------------------------------------------
    public Task(String d, int p) {
        description = d;
        priority = p;
        setPriorityText();
    }

    // ---------------------------------------------------------------------------------------------------
    // Constructor #2: Alternative constructor to set up a Task. Only requires user
    // to pass a String
    // for a Task's description.
    // ---------------------------------------------------------------------------------------------------
    public Task(String d) {
        description = d;
    }

    // ---------------------------------------------------------------------------------------------------
    // Priority accessor.
    // ---------------------------------------------------------------------------------------------------
    public int getPriority() {
        return priority;
    }

    // ---------------------------------------------------------------------------------------------------
    // Priority mutator. Calls setPriorityText to update the text representation of
    // a Task's priority.
    // ---------------------------------------------------------------------------------------------------
    public void setPriority(int p) {
        priority = p;
        setPriorityText();
    }

    // ---------------------------------------------------------------------------------------------------
    // Description accessor.
    // ---------------------------------------------------------------------------------------------------
    public String getDescription() {
        return description;
    }

    // ---------------------------------------------------------------------------------------------------
    // Description mutator.
    // ---------------------------------------------------------------------------------------------------
    public void setDescription(String d) {
        description = d;
    }

    // ---------------------------------------------------------------------------------------------------
    // Overrides compareTo method from the java.lang package. Compares two Task's
    // based on their
    // numeric priority. Returns -1 if Task1 < Task2, 0 if Task1 = Task2, 1 if Task1
    // > Task2.
    // ---------------------------------------------------------------------------------------------------
    public int compareTo(Object obj) {
        // stores integer value to return based on comparison
        int result;

        // typecast for Object parameter
        Task task2 = (Task) obj;

        // comparisons to determine appropriate value to return
        if (this.priority == task2.priority)
            result = 0;
        else if (this.priority > task2.priority)
            result = 1;
        else
            result = -1;

        return result;
    }

    // ---------------------------------------------------------------------------------------------------
    // Returns a nicely formatted string representation of a Task's description and
    // priority.
    // ---------------------------------------------------------------------------------------------------
    public String toString() {
        String str;

        str = "Task priority: " + priority + " - " + priorityText + "\n" + "Task description: " + description;

        return str;
    }

    // ---------------------------------------------------------------------------------------------------
    // Support method to set the text equivalent of a numeric priority value.
    // Utilizes the constants
    // from the Priority interface in setting the appropriate ranges which are LOW
    // (1-4), MEDIUM (5-7),
    // HIGH (8-10);
    // ---------------------------------------------------------------------------------------------------
    private void setPriorityText() {
        if (this.priority >= LOW & this.priority < MEDIUM)
            priorityText = "LOW";
        else if (this.priority >= MEDIUM & this.priority < 8)
            priorityText = "MEDIUM";
        else
            priorityText = "HIGH";
    }
}