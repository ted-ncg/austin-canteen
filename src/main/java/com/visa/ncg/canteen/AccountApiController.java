package com.visa.ncg.canteen;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountApiController {

    InMemAccountRepository inMemAccountRepository;


    public AccountApiController(InMemAccountRepository inMemAccountRepository) {
        this.inMemAccountRepository = inMemAccountRepository;
    }

    @GetMapping(value = "/api/accounts/{accountId}")
    public AccountResponse accountInfo(@PathVariable Long accountId) {

        Account account = inMemAccountRepository.findOne(accountId);

        if (account == null) {
            account = new Account(10);
            account.setId(accountId);

            inMemAccountRepository.save(account);
        }

        AccountResponse accountResponse = new AccountResponse();
        accountResponse.setId(account.getId());
        accountResponse.setBalance(account.balance());

        return accountResponse;
    }

}
