package com.softserveinc.task01;

public class Account {
    private long balance;

    public Account(long balance) {
        this.balance = balance;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    /**
     * @param amount, should be positive
     */
//    public void deposit(long amount) throws IllegalArgumentException {
    public void deposit(long amount) throws IllegalArgumentException {
        // TODO: if amount is negative - throw IllegalArgumentException
        if (amount < 0) {
            throw new IllegalArgumentException("Amount should be positive");
        }
        balance += amount;
    }

    /**
     * @param amount, should be positive
     */
    public void withdraw(long amount) throws IllegalArgumentException, NotMoneyEnoughException {
        // TODO: if amount is negative - throw IllegalArgumentException
        // TODO: if amount higher than balance - throw NoManyEnoughException
        if (amount < 0) {
            throw new IllegalArgumentException("Amount should be positive");
        }
        if(amount > balance) {
            throw new NotMoneyEnoughException("Not enough money on balance for withdrow " + amount + "$");
        }
        balance -= amount;
    }
}
