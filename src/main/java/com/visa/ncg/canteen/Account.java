package com.visa.ncg.canteen;

public class Account {


  private int balance = 0;

  public void deposit(int amount) {
    balance += amount;
  }

  public int balance() {
    return balance;
  }

  public void withdraw(int i) throws InsufficientBalanceException {
    if (i < 0) {
      throw new IllegalArgumentException();
    }
    if (i > balance) {
      throw new InsufficientBalanceException("insufficient balance");
    }
    balance -= i;
  }


}
