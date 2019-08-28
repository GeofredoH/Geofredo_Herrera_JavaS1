package com.example.bankservice.service;

import com.example.bankservice.model.Account;
import com.example.bankservice.util.feign.BankCrudClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BankFrontService {
    @Autowired
    BankCrudClient client;

    public BankFrontService(BankCrudClient client) {
        this.client = client;
    }

    public BigDecimal getBalance(int id){
         return client.getAccount(id).getCredit();
    }

    public void updateBalance(Account account){
        Account account1 = client.getAccount(account.getAccountNumber());

        account1.setCredit(account1.getCredit().add(account.getCredit()));

        client.updateAccount(account1);
    }
}
