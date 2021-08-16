//*************************************************************************************************************
// LockTester.java
//
// COMP 1231 Assignment 2: Polymorphism (Question 2)
//
// Driver class to test the Locked interface which has been implemented on the Account and Coin class.
//*************************************************************************************************************

public class LockTester {
    public static void main(String[] args) {
        // ----------------------------------------------------------------------
        // This section of the code tests the implementation of Locked with the
        // Account class
        // ----------------------------------------------------------------------
        System.out.println("Now testing Account's implementation of Locked...");
        System.out.println("Creating a new account and locking it...");

        // create a new account
        Account acct = new Account("Nico", 123456789, 50000);

        // set the account key
        acct.setKey(123);

        // lock the account
        acct.lock(123);

        // print out the account
        System.out.println(acct);

        // attempt all key methods on locked account
        System.out.println("\nAttemping methods on locked account...");
        acct.deposit(10);
        acct.withdraw(10, 1);
        acct.addInterest();
        acct.getBalance();

        // reprint the account to show no changes
        System.out.println(acct);

        // attempt to unlock with wrong key
        System.out.println("\nAttemping to unlock account with the wrong key...");
        acct.unlock(567);

        // unlock account
        System.out.println("\nUnlocking account and reattempting methods...");
        acct.unlock(123);

        // reperform methods
        acct.deposit(10);
        acct.withdraw(10, 1);
        acct.addInterest();

        // reprint the account
        System.out.println(acct);

        // attempt to lock with the wrong key
        System.out.println("\nAttemping to lock account with the wrong key...");
        acct.lock(2);

        // ----------------------------------------------------------------------
        // This section of the code tests the implementation of Locked with the
        // Coin class
        // ----------------------------------------------------------------------
        System.out.println("\nNow testing Coin's implementation of Locked...");
        System.out.println("Creating a new coin and locking it...");

        // create a new coin
        Coin coin = new Coin();

        // set the coin key
        coin.setKey(789);

        // lock the coin
        coin.lock(789);

        // print out the coin
        System.out.println(coin);

        // attempt to flip locked coin
        System.out.println("\nAttemping methods on locked coin...");
        coin.flip();

        // reprint the coin to show no changes
        System.out.println(coin);

        // attempt to unlock with wrong key
        System.out.println("\nAttemping to unlock coin with the wrong key...");
        coin.unlock(999);

        // unlock coin
        System.out.println("\nUnlocking coin and reattempting methods...");
        coin.unlock(789);

        // reperform methods
        coin.flip();

        // reprint the coin
        System.out.println(coin);

        // attempt to lock with the wrong key
        System.out.println("\nAttemping to lock coin with the wrong key...");
        coin.lock(2);
    }
}
