package com.visa.ncg.canteen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountApiController {

    private AccountRepository repo;

    @Autowired
   public AccountApiController(AccountRepository acctrepo) { repo = acctrepo; }

    @GetMapping("/api/accounts/{id}")
    public AccountResponse accountinfo (@PathVariable("id") Long accountId) {
        Account account = repo.findOne(accountId);
        AccountResponse response = new AccountResponse(account);
        return response;
    }

}
