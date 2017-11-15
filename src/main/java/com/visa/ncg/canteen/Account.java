package com.visa.ncg.canteen;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id = null;

    private BigDecimal balance;
    private String name;
    private int overdraftLimit;


    public Account() {
        balance = BigDecimal.ZERO;
        overdraftLimit = 0;
    }

    public Account(int initialBalance) {
        overdraftLimit = 0;
        balance = new BigDecimal(initialBalance); }

    public void setId(long id) { this.id = id; }

    public Long getId() { return id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOverdraftLimit(int overdraftLimit) {

        this.overdraftLimit = overdraftLimit;
    }

    public void validateWithdrawAmount(int amount) {

        if (amount < 0)
            throw new InvalidAmountException();
    }

    public void validateBalance(int amount) {

        if (balance.compareTo(new BigDecimal(amount - overdraftLimit)) == -1)
            throw new InsufficientBalanceException();
    }

    public void deposit(int amount) {

        validateWithdrawAmount(amount);

        balance = balance.add(new BigDecimal(amount));

    }

    public BigDecimal balance() { return balance; }

    public void withdraw(int amount) {

        validateWithdrawAmount(amount);

        validateBalance(amount);

        balance = balance.subtract(new BigDecimal(amount)) ;
    }

}
