package com.visa.ncg.canteen;

public class AccountResponse {

    private int balance;
    private Long id;
    private String name;

    public int getBalance() {
        return balance;
    }

    public String getName(){
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name)
    {
        this.name=name;
    }

    public AccountResponse fromAccount(Account account) {
        AccountResponse accountResponse = new AccountResponse();
        return accountResponse;
    }

}
