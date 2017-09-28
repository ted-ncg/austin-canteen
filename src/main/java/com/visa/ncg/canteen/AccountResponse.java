package com.visa.ncg.canteen;

public class AccountResponse {

    private int balance;
    private Long id;
    private String name;


    public AccountResponse() { }

    public AccountResponse (Account account) {

        this.id = account.getId();
        this.balance = account.balance();
        this.name = account.getName();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() { return id; }

    public void setId(Long id) {this.id = id;}

    public int getBalance() { return balance; }

    public void setBalance() { this.balance = balance; }

}
