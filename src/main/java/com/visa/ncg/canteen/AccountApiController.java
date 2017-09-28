package com.visa.ncg.canteen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountApiController {

    private AccountRepository accountRepository;

    @Autowired
    public AccountApiController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    @GetMapping("api/accounts/{id}")
    public AccountResponse accountInfo(@PathVariable("id") String accountId) {
        Account account = accountRepository.findOne(Long.valueOf(accountId));
        AccountResponse response = new AccountResponse();
        response.setId(account.getId());
        response.setBalance(account.balance());
        return response;
    }

}
