package com.visa.ncg.canteen;

import org.junit.Test;

import java.math.BigDecimal;

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

    account.deposit(new BigDecimal(10));

    assertThat(account.balance())
        .isEqualTo(new BigDecimal(10));
  }

  @Test
  public void twoDepositsOf10And5DollarsResultInAccountHaving15Dollars() throws Exception {
    Account account = new Account();

    account.deposit(new BigDecimal(10));
    account.deposit(new BigDecimal(5));

    assertThat(account.balance())
        .isEqualTo(new BigDecimal(15));
  }

  @Test
  public void depositZeroAmountResultsInInvalidAmountException() throws Exception {
    Account account = new Account(new BigDecimal(10));

    assertThatThrownBy(() -> account.deposit(new BigDecimal(0)))
        .isInstanceOf(InvalidAmountException.class);
  }

}
