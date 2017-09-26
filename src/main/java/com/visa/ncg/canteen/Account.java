package com.visa.ncg.canteen;

public class Account {

  private int balance;

  public Account() {
    balance = 0;
  }

  public Account(int initialBalance) {
    balance = initialBalance;
  }

  public void deposit(int amount) {
    validateAmount(amount);

    balance += amount;
  }

  private void validateAmount(int amount) {
    if (amount <= 0) {
      throw new InvalidAmountException();
    }
  }

  public int balance() {
    return balance;
  }

  public void withdraw(int amount) {
    validateAmount(amount);
    validateSufficientBalance(amount);

    balance -= amount;
  }

  private void validateSufficientBalance(int amount) {
    if (amount > balance) {
      throw new InsufficientBalanceException();
    }
  }
}
