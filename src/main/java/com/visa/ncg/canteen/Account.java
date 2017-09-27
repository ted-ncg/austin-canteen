package com.visa.ncg.canteen;

public class Account {

    private int balance;

    private Long id = null;

    public Account() { balance = 0; }

    public Account(int initialBalance) { balance = initialBalance; }

    public void setBalance(int balance) { this.balance = balance; }

    public int getBalance() { return balance;}

    public void setId(long id) { this.id = id; }

    public Long getId() { return id; }

    public void validateWithdrawAmount(int amount) {

        if (amount < 0)
            throw new InvalidAmountException();

    }

    public void validateBalance(int amount) {

        if (amount > balance)
            throw new InsufficientBalanceException();

    }

    public void deposit(int amount) {

        validateWithdrawAmount(amount);

        balance += amount;

    }

    public int balance() { return balance; }

    public void withdraw(int amount) {

        validateWithdrawAmount(amount);

        validateBalance(amount);

        balance -= amount;

    }

}
