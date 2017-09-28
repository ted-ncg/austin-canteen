package com.visa.ncg.canteen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AccountWebController {

    private AccountRepository repo;

    @Autowired
    public AccountWebController(AccountRepository acctrepo) { repo = acctrepo; }


    @GetMapping("/account/{id}")
    public String accountView(@PathVariable("id") String id, Model model) {
        Account account = repo.findOne(Long.parseLong(id));
        AccountResponse response = new AccountResponse(account);
        model.addAttribute("account", response);
        return "account-view";
    }

    @GetMapping("/accounts/")
    public String allAccountsView(Model model) {
        List<Account> accounts = repo.findAll();
        List<AccountResponse>  responses = new ArrayList<AccountResponse>();
        for (Account account : accounts) {
            responses.add(new AccountResponse(account));
        }
        model.addAttribute("accounts", responses);
        return "all-accounts";


    }

}
