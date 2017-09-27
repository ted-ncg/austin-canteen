package com.visa.ncg.canteen;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountRepositoryFindTest {

  @Test
  public void findAllForEmptyRepositoryReturnsEmptyList() throws Exception {
    AccountRepository accountRepository = new AccountRepository(new FakeIdGenerator());

    assertThat(accountRepository.findAll())
        .isEmpty();
  }

  @Test
  public void findAllForRepositoryWithTwoAccountsReturnsItInList() throws Exception {
    List<Account> accounts = new ArrayList<>();
    Account a1 = new Account();
    a1.setId(1L);
    Account a2 = new Account();
    a2.setId(2L);
    accounts.add(a1);
    accounts.add(a2);

    IdGenerator idGenerator = new AtomicLongIdGenerator();
    AccountRepository accountRepository = new AccountRepository(accounts, idGenerator);

    assertThat(accountRepository.findAll())
        .containsAll(accounts)
        .hasSize(2);
  }

  @Test
  public void findExistingAccountReturnsAccount() throws Exception {
    AccountRepository accountRepository = new AccountRepository(new FakeIdGenerator(1L));

    Account a1 = new Account();
    accountRepository.save(a1);

    assertThat(accountRepository.findOne(1L))
        .isEqualTo(a1);

  }

  @Test
  public void findAccountForNonExistentIdReturnsNull() throws Exception {
    AccountRepository accountRepository = new AccountRepository(new FakeIdGenerator());

    assertThat(accountRepository.findOne(2L))
        .isNull();
  }

}
