package com.visa.ncg.canteen;

public class Account {

    private int balance;

    private Long id = null;

    public Account() {
        balance = 0;
    }

    public Account(int initialBalance) {
        balance = initialBalance;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void deposit(int amount) {
        if (amount < 0) {
            throw new InvalidAmountException();
        }

        balance += amount;
    }

    public int balance() {
        return balance;
    }

    public void withdraw(int amount) {
        if (amount < 0) {
            throw new InvalidAmountException();
        }

        if (amount > balance) {
            throw new InsufficientBalanceException();
        }

        balance -= amount;
    }

    public Long getId() {
        return id;
    }
}
