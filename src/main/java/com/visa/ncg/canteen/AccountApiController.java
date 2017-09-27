package com.visa.ncg.canteen;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountApiController {

    @GetMapping(value = "/api/accounts/{accountId}")
    public AccountResponse accountInfo(@PathVariable Long accountId) {
        AccountResponse accountResponse = new AccountResponse();
        accountResponse.setId(accountId);
        accountResponse.setBalance(10);

        return accountResponse;
    }

}
