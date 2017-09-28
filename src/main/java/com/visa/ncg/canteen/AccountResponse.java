package com.visa.ncg.canteen;

public class AccountResponse {
  private Long id;
  private int balance;
  private String name;

  public int getBalance() {
    return balance;
  }

  public void setBalance(int balance) {
    this.balance = balance;
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

  public static AccountResponse fromAccount(Account account) {
    AccountResponse accountResponse = new AccountResponse();
    accountResponse.setId(account.getId());
    accountResponse.setBalance(account.balance());
    accountResponse.setName(account.getName());
    return accountResponse;
  }

}
