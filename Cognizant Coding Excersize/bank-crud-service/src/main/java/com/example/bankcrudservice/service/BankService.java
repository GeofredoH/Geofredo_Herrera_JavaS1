package com.example.bankcrudservice.service;

import com.example.bankcrudservice.dao.BankRepository;
import com.example.bankcrudservice.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BankService {
    @Autowired
    private BankRepository repo;

    public BankService(BankRepository repo) {
        this.repo = repo;
    }

    public Account getAccount(int accountNumber){
        return null;
    }

    public BigDecimal getAccountBalanceByAccountNumber(int accountNumber){
        return null;
    }

    public void updateAccountBalance(Account account){
        repo.save(account);
    }


}
