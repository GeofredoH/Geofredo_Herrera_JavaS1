package com.example.bankservice.controller;

import com.example.bankservice.model.Account;
import com.example.bankservice.service.BankFrontService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/admin")
public class BankController {

    @Autowired
    BankFrontService service;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BigDecimal getBalance(@PathVariable int accountNumber){
        return service.getBalance(accountNumber);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void creditAccountBalance(@RequestBody Account account){
        service.updateBalance(account);
    }


}
