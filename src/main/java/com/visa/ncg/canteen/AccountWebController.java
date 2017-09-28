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

    private AccountRepository accountRepository;
    private CurrencyService currencyService;

    @Autowired
    public AccountWebController(AccountRepository accountRepository,CurrencyService currencyService) {
        this.accountRepository = accountRepository;
        this.currencyService = currencyService;
    }


    @GetMapping("account/{id}")
    public String accountView(@PathVariable("id") String id,
                              Model model) {
        Account account = accountRepository.findOne(Long.valueOf(id));
        AccountResponse response = new AccountResponse();
        response.setName(account.getName());
        response.setId(account.getId());
        response.setBalance(account.balance());

        model.addAttribute("account", response);
        model.addAttribute("gbpConversion", currencyService.convertToGbp(account.balance()));
        return "account-view";
    }


    @GetMapping("/create-account")
    public String createAccountForm(){
        return "create-account";
    }

    @PostMapping("/create-account")
    public String createAccount(@ModelAttribute("accountName") String name) {
        Account account=new Account();
        account.setName(name);
        accountRepository.save(account);
        return "redirect:/accounts";
    }

    @GetMapping("/accounts")
    public String allAccountsView(Model model) {
        List<AccountResponse> accountResponseList = new ArrayList<>();
        AccountResponse accountResponse;
        for (Account account :
                accountRepository.findAll()) {

            accountResponse = new AccountResponse();
            accountResponse.setBalance(account.balance());
            accountResponse.setId(account.getId());
            accountResponse.setName(account.getName());
            accountResponseList.add(accountResponse);
        }

        model.addAttribute("accounts", accountResponseList);

        return "all-accounts";
    }
}
