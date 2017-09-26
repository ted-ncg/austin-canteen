package com.visa.ncg.canteen;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountDepositTest {

  @Test
  public void newAccountsHaveZeroBalance()  {
    assertThat(new Account().balance())
        .isZero();
  }

  @Test
  public void deposit10DollarsToNewAccountResultsInAccountHaving10Dollars()  {

    Account account = new Account();

    account.deposit(10);

    assertThat(account.balance())
        .isEqualTo(10);
  }

  @Test
  public void twoDepositsOf10And5DollarsResultInAccountHaving15Dollars()  {
    Account account = new Account();

    account.deposit(10);
    account.deposit(5);

    assertThat(account.balance())
        .isEqualTo(15);
  }

  //TODO: Check deposit negative balance

}
