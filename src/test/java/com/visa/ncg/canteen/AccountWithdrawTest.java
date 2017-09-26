package com.visa.ncg.canteen;

import org.junit.Test;

import java.security.InvalidParameterException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class AccountWithdrawTest {

    @Test
    public void withdraw30FromAccountWith70ResultsIn40() {
        Account account = new Account();

        account.deposit(70);
        try {
            account.withdraw(30);
        } catch (InsufficientBalanceException e) {
            e.printStackTrace();
        }

        assertThat(account.balance()).isEqualTo(40);
    }

    @Test
    public void withdraw50FromAccountWith20ResultsError() {
        Account account = new Account();

        account.deposit(20);

        assertThatThrownBy(() -> {account.withdraw(50);}).isInstanceOf(InsufficientBalanceException.class);

    }

    @Test (expected = IllegalArgumentException.class)
    public void withdrawNegativeAmountResultsInError() {
        Account account = new Account();

        account.deposit(20);
        try {
            account.withdraw(-10);
        } catch (InsufficientBalanceException e) {
            e.printStackTrace();
        }
    }
}
