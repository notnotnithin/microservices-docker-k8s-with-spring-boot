package com.dawn.cards.controller;

import com.dawn.cards.model.Cards;
import com.dawn.cards.model.Customer;
import com.dawn.cards.repository.CardsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class CardsController {

  @Autowired
  private CardsRepository cardsRepository;

  @PostMapping("/myCards")
  public List<Cards> getCardDetails(@RequestBody Customer customer) {
    log.info("getCardDetails() method started");
    List<Cards> cards = cardsRepository.findByCustomerId(customer.getCustomerId());
    log.info("getCardDetails() method ended");
    if (cards != null) {
      return cards;
    } else {
      return null;
    }
  }
}