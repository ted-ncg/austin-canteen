package com.visa.ncg.canteen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AccountWebController {

  private final AccountRepository accountRepository;

  @Autowired
  public AccountWebController(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  @GetMapping("/account/{id}")
  public String viewAccount(@PathVariable("id") String id,
      Model model) {
    Account account = accountRepository.findOne(Long.valueOf(id));

    AccountResponse accountResponse = new AccountResponse();
    accountResponse.setId(account.getId());
    accountResponse.setBalance(account.balance());
    accountResponse.setName(account.getName());

    model.addAttribute("account", accountResponse);
    return "account-view";
  }

}
