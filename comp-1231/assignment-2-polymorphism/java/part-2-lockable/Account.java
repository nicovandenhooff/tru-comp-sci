//********************************************************************************************************
// Account.java       
//
// COMP 1231 Assignment 2: Polymorphism (Question 2)
//
// Represents a bank account with basic services such as deposit and withdraw.  Redesigned to implement
// the Locked interface which allows a user to lock and unlock an Account object.  If an Account object
// is "locked" the methods do nothing.  If they are unlocked, they perform their actual task.
//********************************************************************************************************

import java.text.NumberFormat;

public class Account implements Locked {
    private final double RATE = 0.035; // interest rate of 3.5%

    private long acctNumber;
    private double balance;
    private String name;
    private int key; // key for lock
    private boolean lockedStatus; // to determine if an Account is locked

    // -----------------------------------------------------------------
    // Sets up the account by defining its owner, account number,
    // and initial balance.
    // -----------------------------------------------------------------
    public Account(String owner, long account, double initial) {
        name = owner;
        acctNumber = account;
        balance = initial;
    }

    // -----------------------------------------------------------------
    // Establishes an account key
    // -----------------------------------------------------------------
    public void setKey(int k) {
        key = k;
    }

    // -----------------------------------------------------------------
    // Used to lock an account. Only works if the correct key is passed.
    // -----------------------------------------------------------------
    public void lock(int k) {
        if (k == key)
            lockedStatus = true;
        else
            System.out.println("Incorrect key");
    }

    // -----------------------------------------------------------------
    // Used to unlock an account. Only works if the correct key is
    // passed.
    // -----------------------------------------------------------------
    public void unlock(int k) {
        if (k == key)
            lockedStatus = false;
        else
            System.out.println("Incorrect key");
    }

    // -----------------------------------------------------------------
    // Used determine if an account is locked.
    // -----------------------------------------------------------------
    public boolean locked() {
        return lockedStatus;
    }

    // -----------------------------------------------------------------
    // Deposits the specified amount into the account and returns
    // the new balance. The balance is not modified if the deposit
    // amount is invalid. Only works if accunt is unlocked.
    // -----------------------------------------------------------------
    public double deposit(double amount) {
        if (lockedStatus)
            System.out.println("Account is locked, deposit failed");
        else if (amount > 0)
            balance = balance + amount;

        return balance;
    }

    // -----------------------------------------------------------------
    // Withdraws the specified amount and fee from this account and
    // returns the new balance. The balance is not modified if the
    // withdraw amount is invalid or the balance is insufficient.
    // only works if account is unlocked.
    // -----------------------------------------------------------------
    public double withdraw(double amount, double fee) {
        if (lockedStatus)
            System.out.println("Account is locked, withdrawal failed");
        else if (amount + fee > 0 && amount + fee < balance)
            balance = balance - amount - fee;

        return balance;
    }

    // -----------------------------------------------------------------
    // Adds interest to the account and returns the new balance.
    // Only works if account is unlocked.
    // -----------------------------------------------------------------
    public double addInterest() {
        if (lockedStatus)
            System.out.println("Account is locked, cannot add interest");
        else
            balance += (balance * RATE);

        return balance;
    }

    // -----------------------------------------------------------------
    // Returns the current balance of this account.
    // Only works if account is unlocked.
    // -----------------------------------------------------------------
    public double getBalance() {
        if (lockedStatus) {
            System.out.println("Account is locked, cannot access balance");
            return 0;
        } else
            return balance;
    }

    // -----------------------------------------------------------------
    // Returns a one-line description of this account as a string.
    // Includes whether or not the account is locked.
    // -----------------------------------------------------------------
    public String toString() {
        NumberFormat fmt = NumberFormat.getCurrencyInstance();

        return (acctNumber + "\t" + name + "\t" + fmt.format(balance) + "\tLocked: " + lockedStatus);
    }
}
