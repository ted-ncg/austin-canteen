package com.visa.ncg.canteen;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class InMemAccountRepositoryTest {

    @Test
    public void findAllShouldReturn2Accounts() {

        List<Account> accounts = new ArrayList<>();

        Account a1 = new Account();
        a1.setId(1L);
        Account a2 = new Account();
        a2.setId(2L);
        accounts.add(a1);
        accounts.add(a2);

        InMemAccountRepository repo = new InMemAccountRepository(accounts);
        assertThat(repo.findAll())
                .hasSize(2);

    }

    @Test
    public void saveNewAccountAssignsIdToAccount() throws Exception {

        Account account = new Account();

        InMemAccountRepository repo = new InMemAccountRepository();
        account = repo.save(account);

        assertThat(account.getId())
                .isNotNull();

    }

    @Test
    public void newlySavedAccountsHaveUniqueIds() {

        InMemAccountRepository inMemAccountRepository = new InMemAccountRepository();
        Account account1 = new Account();
        inMemAccountRepository.save(account1);
        Account account2 = new Account();
        inMemAccountRepository.save(account2);

        assertThat(account1.getId())
                .isNotEqualTo(account2.getId());

    }

    @Test
    public void findOneReturnsNullWhenIdDoesNotExist() {

        InMemAccountRepository accountRepo = new InMemAccountRepository();
        Account account = new Account();

        account.setId(2L);
        accountRepo.save(account);

        assertThat(accountRepo.findOne(1L))
                .isNull();

    }

    @Test
    public void findOneReturnsAccountWithGivenId() throws Exception {

        InMemAccountRepository repo = new InMemAccountRepository();

        Account account = new Account();
        account.setId(1L);

        repo.save(account);

        Account foundAccount = repo.findOne(1L);

        assertThat(foundAccount.getId())
                .isEqualTo(1L);

    }

}
