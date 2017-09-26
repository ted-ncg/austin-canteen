package com.visa.ncg.canteen;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AccountDepositTest {

  @Test
  public void newAccountsHaveZeroBalance() throws Exception {
    assertThat(new Account().balance())
        .isZero();
  }

  @Test
  public void deposit10DollarsToNewAccountResultsInAccountHaving10Dollars() throws Exception {

    Account account = new Account();

    account.deposit(10);

    assertThat(account.balance())
        .isEqualTo(10);
  }

  @Test
  public void twoDepositsOf10And5DollarsResultInAccountHaving15Dollars() throws Exception {
    Account account = new Account();

    account.deposit(10);
    account.deposit(5);

    assertThat(account.balance())
        .isEqualTo(15);
  }

  @Test
  public void depositOfNegative15DollarsResultInIllegalArgumentException() {
    Account account = new Account();

    assertThatThrownBy(() -> {account.deposit(-15);}).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  public void depositOfZeroDollarsResultInIllegalArgumentException() {
    Account account = new Account();

    assertThatThrownBy(() -> {account.deposit(0);}).isInstanceOf(IllegalArgumentException.class);
  }

}
