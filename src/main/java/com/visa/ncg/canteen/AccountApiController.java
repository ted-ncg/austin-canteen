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

  @GetMapping("/api/accounts/{id}")
  public AccountResponse accountInfo(@PathVariable("id") String id) {
    Account account = accountRepository.findOne(Long.valueOf(id));

    // convert to a response object...
    AccountResponse accountResponse = new AccountResponse();
    accountResponse.setBalance(account.balance());
    accountResponse.setId(account.getId());

    return accountResponse;
  }

}
