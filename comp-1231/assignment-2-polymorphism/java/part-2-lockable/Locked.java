//********************************************************************************************************
// Lockable.java
//
// COMP 1231 Assignment 2: Polymorphism (Question 2)
//
// Represents the interface for an object that can be locked and unlocked.
//********************************************************************************************************

public interface Locked {
    public void setKey(int k);

    public void lock(int k);

    public void unlock(int k);

    public boolean locked();
}