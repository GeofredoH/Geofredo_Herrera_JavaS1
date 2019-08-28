package com.example.bankcrudservice.controller;

import com.example.bankcrudservice.model.Account;
import com.example.bankcrudservice.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class BankCrudController {

    @Autowired
    BankService bankService;

    @GetMapping("/{id}")
    public Account getAccount(@PathVariable("id") int id){
        return bankService.getAccount(id);
    }

    @PutMapping
    public void updateAccount(@RequestBody Account account){
        bankService.updateAccountBalance(account);
    }

}
