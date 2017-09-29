package com.visa.ncg.canteen;

import java.math.BigDecimal;

public class AccountResponse {

    private BigDecimal balance;
    private BigDecimal gbpBalance;
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

    public BigDecimal getBalance() { return balance; }

    public void setBalance() { this.balance = balance; }

    public BigDecimal getGbpBalance() {
        return gbpBalance;
    }

    public void setGbpBalance(BigDecimal gbpBalance) {
        this.gbpBalance = gbpBalance;
    }

    public boolean isOverdrawn () {

        if (balance.compareTo(new BigDecimal(0)) < 0) {

            return true;
        }

        else return false;
    }
}
