package com.visa.ncg.canteen;

import java.math.BigDecimal;

public class AccountResponse {

    private Long id;
    private BigDecimal balance;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOverdrawn() {
        return balance.compareTo(BigDecimal.ZERO) > -1;
    }

    public static AccountResponse fromAccount(Account account) {

        AccountResponse accountResponse = new AccountResponse();
        accountResponse.setId(account.getId());
        accountResponse.setBalance(account.balance());
        accountResponse.setName(account.getName());

        return accountResponse;
    }

}
