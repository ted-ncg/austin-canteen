package com.visa.ncg.canteen;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountWithdrawTest {

    @Test
    public void withdraw3DollarsFromAccountHaving7DollarsResultsIn4DollarBalance() throws Exception {

        Account account = new Account(7);

        account.withdraw(3);

        assertThat(account.balance())
                .isEqualTo(4);

    }

}
