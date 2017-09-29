package com.visa.ncg.canteen;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Account {

  private BigDecimal balance;
  private BigDecimal overdraftLimit;
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Long id;
  private String name;

  public Account() {
    balance = new BigDecimal(0);
    overdraftLimit = new BigDecimal(0);
  }

  public Account(BigDecimal initialBalance) {
    balance = initialBalance;
    overdraftLimit = new BigDecimal(0);
  }

  public Account (BigDecimal initialBalance, BigDecimal overdraftLimit) {
      balance = initialBalance;
      this.overdraftLimit = overdraftLimit;
  }

  public void deposit(BigDecimal amount) {
    validateAmount(amount);
    balance = balance.add(amount);
    System.out.println(balance());
  }

  private void validateAmount(BigDecimal amount) {
    if (amount.compareTo(new BigDecimal(0)) <= 0) {
      throw new InvalidAmountException();
    }
  }

  public BigDecimal balance() {
    return balance;
  }

  public void withdraw(BigDecimal amount) {
    validateAmount(amount);
    validateSufficientBalance(amount);

    balance = balance.subtract(amount);
  }

  private void validateSufficientBalance(BigDecimal amount) {
      BigDecimal temp;
      temp = balance.add(overdraftLimit);
      if (amount.compareTo(temp) == 1) {
        throw new InsufficientBalanceException();
    }
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

    public BigDecimal getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(BigDecimal overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }
}
