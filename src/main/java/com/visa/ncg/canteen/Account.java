package com.visa.ncg.canteen;

public class Account {

  private int balance = 0;

  public void deposit(int amount) {
    balance += amount;
  }

  public void withdraw(int amount) {
    if(amount > balance) {
      throw new IllegalArgumentException();
    } else {
      balance -= amount;
    }
  }

  public int balance() {
    return balance;
  }
}
