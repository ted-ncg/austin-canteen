package com.visa.ncg.canteen;

import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AccountWithdrawTest {

  @Test
  public void withdraw3DollarsFromAccountHaving7DollarsResultsIn4DollarBalance() throws Exception {
    Account account = new Account(new BigDecimal(7));

    account.withdraw(new BigDecimal(3));

    assertThat(account.balance())
        .isEqualTo(new BigDecimal(4));
  }

  @Test
  public void withdrawNegativeAmountResultsInInvalidAmountException() throws Exception {
    Account account = new Account(new BigDecimal(10));

    assertThatThrownBy(() ->  { account.withdraw(new BigDecimal(-1)); })
        .isInstanceOf(InvalidAmountException.class);
  }

  @Test
  public void withdrawMoneyFromAccountWithInsufficientBalanceThrowsException() throws Exception {
    Account account = new Account(new BigDecimal(2));

    assertThatThrownBy(() -> { account.withdraw(new BigDecimal(12)); })
        .isInstanceOf(InsufficientBalanceException.class);
  }

  @Test
  public void withdrawMoneyFromAccountBelowOverDraftLimitDoesNotThrow() throws Exception {
    Account account = new Account(new BigDecimal(10), new BigDecimal(5));
    account.withdraw(new BigDecimal(15));

  }

  @Test
  public void withdrawMoneyFromAccountOverDraftLimitThrowsException() throws Exception {
      Account account = new Account(new BigDecimal(10), new BigDecimal(5));
      assertThatThrownBy(() -> {account.withdraw(new BigDecimal(15.01)); }).isInstanceOf(InsufficientBalanceException.class);

  }

}
