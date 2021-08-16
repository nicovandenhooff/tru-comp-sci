//********************************************************************************************************
// Coin.java       
//
// COMP 1231 Assignment 2: Polymorphism (Question 2)
//
// Represents a coin with two sides that can be flipped. Redesigned to implement the Locked interface 
// which allows a user to lock and unlock an Account object.  If an Account object is "locked" the 
// methods do nothing.  If they are unlocked, they perform their actual task.
//********************************************************************************************************

public class Coin implements Locked {
    private final int HEADS = 0; // tails is 1

    private int face; // current side showing
    private int key; // key for lock
    private boolean lockedStatus; // to determine if a Coin is locked

    // -----------------------------------------------------------------
    // Sets up the coin by flipping it initially.
    // -----------------------------------------------------------------
    public Coin() {
        flip();
    }

    // -----------------------------------------------------------------
    // Establishes a coin key
    // -----------------------------------------------------------------
    public void setKey(int k) {
        key = k;
    }

    // -----------------------------------------------------------------
    // Used to lock a coin. Only works if the correct key is passed.
    // -----------------------------------------------------------------
    public void lock(int k) {
        if (k == key)
            lockedStatus = true;
        else
            System.out.println("Incorrect key");
    }

    // -----------------------------------------------------------------
    // Used to unlock a coin. Only works if the correct key is
    // passed.
    // -----------------------------------------------------------------
    public void unlock(int k) {
        if (k == key)
            lockedStatus = false;
        else
            System.out.println("Incorrect key");
    }

    // -----------------------------------------------------------------
    // Used determine if a coin is locked.
    // -----------------------------------------------------------------
    public boolean locked() {
        return lockedStatus;
    }

    // -----------------------------------------------------------------
    // Flips this coin by randomly choosing a face value.
    // Only works if coin is unclocked.
    // -----------------------------------------------------------------
    public void flip() {
        if (lockedStatus)
            System.out.println("Coin is locked, cannot flip");
        else
            face = (int) (Math.random() * 2);
    }

    // -----------------------------------------------------------------
    // Returns true if the current face of the coin is heads.
    // Works whether or not coin is locked as it is not a key method.
    // -----------------------------------------------------------------
    public boolean isHeads() {
        return (face == HEADS);
    }

    // -----------------------------------------------------------------
    // Returns the current face of the coin as a string, and it's
    // locked status.
    // -----------------------------------------------------------------
    public String toString() {
        return (((face == HEADS) ? "Heads" : "Tails") + "\tLocked: " + lockedStatus);
    }
}
