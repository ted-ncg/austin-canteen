package com.visa.ncg.canteen;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountWebController {

  @GetMapping("/account/{id}")
  public String viewAccount(Model model) {
    // retrieve account from repository
    // convert it to accountResponse (POJO)
    return "account-view";
  }

}
