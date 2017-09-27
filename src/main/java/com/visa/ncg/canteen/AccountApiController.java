package com.visa.ncg.canteen;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountApiController {

  @GetMapping("/api/accounts/{id}")
  public AccountResponse accountInfo(@PathVariable("id") String id) {
    Account account = new Account(10);
    account.setId(Long.valueOf(id));

    // convert to a response object...
    AccountResponse accountResponse = new AccountResponse();
    accountResponse.setBalance(account.balance());
    accountResponse.setId(account.getId());

    return accountResponse;
  }

}
