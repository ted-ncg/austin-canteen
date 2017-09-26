package com.visa.ncg.canteen;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class AccountWithdrawTest {

    @Test
    public void withdraw30FromAccountWith70ResultsIn40() {
        Account account = new Account();

        account.deposit(70);
        account.withdraw(30);

        assertThat(account.balance()).isEqualTo(40);
    }
   @Test (expected = IllegalArgumentException.class)
    public void withdrraw50FromAccountWith20ResultsError() {
        Account account = new Account();

        account.deposit(20);
        account.withdraw(50);

    }
}
