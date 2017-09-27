package com.visa.ncg.canteen;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AccountDataLoader implements ApplicationRunner {

    private AccountRepository accountRepository;

    public AccountDataLoader(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Account account = new Account();
        Account account1 = new Account();

        account.deposit(5);
        account1.deposit(10);

        accountRepository.save(account);
        accountRepository.save(account1);
    }

}