package com.dawn.accounts.controller;

import com.dawn.accounts.model.Accounts;
import com.dawn.accounts.model.Customer;
import com.dawn.accounts.repositories.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountsController {

  @Autowired
  private AccountsRepository accountsRepository;

  @PostMapping("/myAccount")
  public Accounts getAccountDetails(@RequestBody Customer customer) {

    Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId());
    if (accounts != null) {
      return accounts;
    } else {
      return null;
    }
  }
}
