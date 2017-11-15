package com.visa.ncg.canteen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
public class AccountWebController {

    AccountRepository accountRepository;
    CurrencyService currencyService;

    @Autowired
    public AccountWebController(AccountRepository accountRepository, CurrencyService currencyService) {
        this.accountRepository = accountRepository;
        this.currencyService = currencyService;
    }

    @GetMapping(value = "/account/{id}")
    public String accountView(@PathVariable(name = "id") String id,
                              Model model) {

        Account account = accountRepository.findOne(Long.parseLong(id));

        ConvertedCurrency convertedCurrency = new ConvertedCurrency();
        convertedCurrency.setConverted(currencyService.convertToGbp(account.balance()));

        AccountResponse accountResponse = AccountResponse.fromAccount(account);

        model.addAttribute("account", accountResponse);
        model.addAttribute("currency", convertedCurrency);

        return "account-view";
    }

    @GetMapping(value = "/account")
    public String allAccounts(Model model) {

        Iterable<Account> accounts = accountRepository.findAll();

        Iterable<AccountResponse> responses = StreamSupport.
                stream(accounts.spliterator(), false)
                .map(AccountResponse::fromAccount)
                .collect(Collectors.toList());

        model.addAttribute("accounts", responses);

        return "all-accounts";
    }

    @GetMapping(value = "/create-account")
    public String createAccountForm(Model model) {

        CreateForm createForm = new CreateForm();

        createForm.setInitialDeposit(10);
        createForm.setOverdraftLimit(0);
        createForm.setAccountName("");

        model.addAttribute("createForm", createForm);

        return "create-account";
    }

   @PostMapping(value = "/create-account")
   public String createAccount(@ModelAttribute("accountName") String name, @Valid CreateForm createForm,
                               BindingResult result) {

        Account account = new Account();
        account.setName(name);
        account.setOverdraftLimit(createForm.getOverdraftLimit());
        account.deposit(createForm.getInitialDeposit());

        if(result.hasErrors()) {
           return "create-account";
        }

        accountRepository.save(account);
        return "redirect:/account/" + account.getId();
   }



}
