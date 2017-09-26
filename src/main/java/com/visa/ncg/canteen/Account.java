package com.visa.ncg.canteen;

public class Account {


  private int balance = 0;
  private long id = 0L;

  public void deposit(int amount) {

    if(amount < 0) {
      throw new IllegalArgumentException();
    }
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


  public void setId(long l) { id = l;  }

  public long getId() { return id;}
}
