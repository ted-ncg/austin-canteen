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
        account.deposit(100);
        account.setName("Luxuries");
        accountRepository.save(account);

        account = new Account();
        account.deposit(2000000000);
        account.setName("Necessities");
        accountRepository.save(account);

        account = new Account();
        account.deposit(50);
        account.setName("Luxuries");
        accountRepository.save(account);
    }
}