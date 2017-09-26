package com.visa.ncg.canteen;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

public class AccountRepositoryTest {

    @Test
    public void findAllShouldReturn2Accounts() {
        List<Account> accounts = new ArrayList<>();

        Account a1 = new Account();
        a1.setId(1L);
        Account a2 = new Account();
        a2.setId(2L);
        accounts.add(a1);
        accounts.add(a2);

        AccountRepository repo = new AccountRepository(accounts);
        assertThat(repo.findAll())
                .hasSize(2);
    }

    @Test
    public void newlySavedAccountsHaveUniqueIds() {
        AccountRepository accountRepository = new AccountRepository();
        Account account1 = new Account();
        accountRepository.save(account1);
        Account account2 = new Account();
        accountRepository.save(account2);

        assertThat(account1.getId())
                .isNotEqualTo(account2.getId());
    }

    @Test
    public void findAnAccountThatDoesntExist() {
        Account account = new Account();
        AccountRepository accountRepository = new AccountRepository();

        accountRepository.save(account);

        assertThat(accountRepository.findOne(5L)).isNull();
    }

    @Test
    public void overWriteExisingAccountReturnOne() {
        List<Account> accounts = new ArrayList<>();

        Account a1 = new Account();
        a1.setId(1L);
        Account a2 = new Account();
        a2.setId(1L);
        Account a3 = new Account();
        a2.setId(1L);
        accounts.add(a1);
        accounts.add(a2);

        AccountRepository repo = new AccountRepository(accounts);
        assertThat(repo.findAll())
                .hasSize(1);
    }

    @Test
    public void checkifreposacescorrectly() {
        Account a1 = new Account();
        a1.setId(1L);
        Account a2 = new Account();
        Account a3 = new Account();
        a2.setId(3L);

        AccountRepository repo = new AccountRepository();
        repo.save(a1);
        repo.save(a2);
        repo.save(a3);
        assertThat(a1.getId())
                .isNotEqualTo(a2.getId())
                .isNotEqualTo(a3.getId());
    }
}
