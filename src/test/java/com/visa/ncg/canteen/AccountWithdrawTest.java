package com.visa.ncg.canteen;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AccountWithdrawTest {

    @Test
    public void withdraw3DollarsFromAccountHaving7DollarsResultsIn4DollarBalance() throws Exception {

        Account account = new Account(7);

        account.withdraw(3);

        assertThat(account.balance())
                .isEqualTo(4);
    }

    @Test
    public void withdraw6FromNewAccountResultsInNegative6Balance() throws Exception {
        Account account = new Account();

        account.withdraw(6);

        assertThat(account.balance())
                .isEqualTo(-6);
    }

    @Test
    public void withdrawNegativeAmountThrowsException() throws Exception {

        Account account = new Account();

        assertThatThrownBy(() -> { account.withdraw(-12); })
                .isInstanceOf(InsufficientBalanceException.class);
    }
}
