package com.visa.ncg.canteen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AccountWebController {

    private AccountRepository repo;
    private CurrencyService converter;

    @Autowired
    private AccountWebController(AccountRepository acctrepo, CurrencyService currencyConverter) {

        repo = acctrepo;
        converter = currencyConverter;
    }


    @GetMapping("/account/{id}")
    public String accountView(@PathVariable("id") String id, Model model) {
        Account account = repo.findOne(Long.parseLong(id));
        AccountResponse response = new AccountResponse(account);
        response.setGbpBalance(converter.convertToGBP(response.getBalance()));
        model.addAttribute("account", response);
        return "account-view";
    }

    @GetMapping("/account")
    public String allAccountsView(Model model) {
        List<Account> accounts = repo.findAll();
        List<AccountResponse>  responses = new ArrayList<AccountResponse>();
        for (Account account : accounts) {
            responses.add(new AccountResponse(account));
        }
        model.addAttribute("accounts", responses);
        return "all-accounts";


    }

    @GetMapping("/create-account")
    public String createAccountForm() {
        return "create-account";
    }

    @PostMapping("/create-account")
    public String createAccount(@ModelAttribute("accountName") String name) {
        Account account = new Account();
        account.setName(name);
        repo.save(account);
        return ("redirect:/account/" + account.getId());

    }

}
