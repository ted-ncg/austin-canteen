package com.visa.ncg.canteen;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountApiController {

    AccountRepository accountRepository;


    public AccountApiController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @GetMapping(value = "/api/accounts/{accountId}")
    public AccountResponse accountInfo(@PathVariable Long accountId) {

        Account account = accountRepository.findOne(accountId);

        if (account == null) {
            account = new Account(10);
            account.setId(accountId);

            accountRepository.save(account);
        }

        AccountResponse accountResponse = new AccountResponse();
        accountResponse.setId(account.getId());
        accountResponse.setBalance(account.balance());

        return accountResponse;
    }

}
