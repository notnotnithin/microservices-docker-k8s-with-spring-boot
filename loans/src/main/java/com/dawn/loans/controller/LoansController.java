package com.dawn.loans.controller;

import com.dawn.loans.model.Customer;
import com.dawn.loans.model.Loans;
import com.dawn.loans.repository.LoansRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class LoansController {

  @Autowired
  private LoansRepository loansRepository;

  @PostMapping("/myLoans")
  public List<Loans> getLoansDetails(@RequestBody Customer customer) {
    log.info("getLoansDetails() method started");
    List<Loans> loans = loansRepository.findByCustomerIdOrderByStartDtDesc(customer.getCustomerId());
    log.info("getLoansDetails() method ended");
    if (loans != null) {
      return loans;
    } else {
      return null;
    }
  }

}
