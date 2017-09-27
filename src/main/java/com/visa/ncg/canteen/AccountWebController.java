package com.visa.ncg.canteen;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountWebController {

    @GetMapping(value = "/account/{id}")
    public String accountView(@PathVariable(name = "id") String id,
                              Model model) {
        return "account-view";
    }

}
