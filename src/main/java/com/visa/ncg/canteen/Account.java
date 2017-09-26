package com.visa.ncg.canteen;

public class Account {

  private int balance;
  private Long id;

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

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
