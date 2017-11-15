package com.visa.ncg.canteen;

import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OverdraftLimitTest {

    @Test
    public void withdraw10FromBalanceOf5WithOverdraftLimit5ResultsInABalanceOf5() {

        Account account = new Account(5);

        account.setOverdraftLimit(5);
        account.withdraw(10);

        assertThat(account.balance()).isEqualTo(new BigDecimal(-5));
    }

    @Test
    public void withdraw10OverOverdraftLimitResultsinException() {

        Account account = new Account(5);

        account.setOverdraftLimit(5);

        assertThatThrownBy(() -> { account.withdraw(15); })
                .isInstanceOf(InsufficientBalanceException.class);
    }

}
