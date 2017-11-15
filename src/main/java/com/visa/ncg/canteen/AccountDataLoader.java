package com.visa.ncg.canteen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AccountDataLoader implements ApplicationRunner {

    private InMemAccountRepository inMemAccountRepository;

    @Autowired
    public AccountDataLoader(InMemAccountRepository inMemAccountRepository) {
        this.inMemAccountRepository = inMemAccountRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Account account = new Account();
        Account account1 = new Account();
        Account account2 = new Account(-4003);

        account.deposit(10);
        account1.deposit(5);


        account.setName("Foo");
        account1.setName("Bar");
        account2.setName("PoorBoy");

        inMemAccountRepository.save(account);
        inMemAccountRepository.save(account1);
        inMemAccountRepository.save(account2);
    }

}