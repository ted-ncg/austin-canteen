package com.visa.ncg.canteen;

import java.security.InvalidParameterException;

public class Account {

  private int balance = 0;

  public void deposit(int amount) {
    if(amount <= 0) {
      throw new IllegalArgumentException();
    } else {
      balance += amount;
    }
  }

  public void withdraw(int amount) {
    if(amount <= 0) {
      throw new IllegalArgumentException();
    } else if(amount > balance) {
        throw new InsufficientBalanceException();

    } else {
      balance -= amount;
    }
  }

  public int balance() {
    return balance;
  }
}
