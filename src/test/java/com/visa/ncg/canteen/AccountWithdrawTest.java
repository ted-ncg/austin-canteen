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
  public void withdrawNegativeAmountResultsInInvalidAmountException() throws Exception {
    Account account = new Account(10);

    assertThatThrownBy(() -> account.withdraw(-1))
        .isInstanceOf(InvalidAmountException.class);
  }

  @Test
  public void withdrawMoneyFromAccountWithInsufficientBalanceThrowsException() throws Exception {
    Account account = new Account(2);

    assertThatThrownBy(() -> { account.withdraw(12); })
        .isInstanceOf(InsufficientBalanceException.class);
  }



}
