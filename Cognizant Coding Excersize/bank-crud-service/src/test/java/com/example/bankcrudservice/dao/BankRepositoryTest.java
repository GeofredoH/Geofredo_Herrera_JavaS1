package com.example.bankcrudservice.dao;

import com.example.bankcrudservice.model.Account;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BankRepositoryTest {

    @Autowired
    BankRepository bankRepository;

    @Before
    public void setUp() throws Exception {
        bankRepository.deleteAll();
    }

    @Test
    public void shouldReturnAccountBalance(){
        Account account = new Account();
//        account.setAccountNumber(100);
        account.setCredit(BigDecimal.valueOf(1000));

        account = bankRepository.save(account);

        Account accountFromDb = bankRepository.getOne(account.getAccountNumber());

        assertEquals(account.getCredit(), accountFromDb.getCredit());

    }

//    @Test
//    public void shouldCreditAccountBalance(){
//        Account account = new Account();
//        account.setCredit(BigDecimal.valueOf(1000));
//
//        account = bankRepository.save(account);
//
//        //This is the account that will be in request body for adding funds
//        Account account1 = new Account();
//        account1.setAccountNumber(account.getAccountNumber());
//        account1.setCredit(BigDecimal.valueOf(500));
//
//        bankRepository.save(account1);
//
//        bankRepository.findBalanceById(account.getAccountNumber());
//
//    }

    @Test
    public void createAccountAndVerifyItReturns(){
        Account account = new Account();
        account.setCredit(BigDecimal.valueOf(1000));

        account = bankRepository.save(account);

        Account account1 = bankRepository.getOne(account.getAccountNumber());

        assertEquals(account, account1);
    }

    @Test
    public void updateAccount(){
        Account account = new Account();
        account.setCredit(BigDecimal.valueOf(1000));

        account = bankRepository.save(account);

        account.setCredit(BigDecimal.valueOf(2500));

        bankRepository.save(account);

        Account account1 = bankRepository.getOne(account.getAccountNumber());

        assertEquals(account, account1);
    }

//    @Test
//    public void updateAccountForNonExistingAccount(){
//        Account account = new Account();
//        account.setAccountNumber(222);
//        account.setCredit(BigDecimal.valueOf(1000));
//////
//////        account = bankRepository.save(account);
//////
//////        account.setAccountNumber(999);
//////        account.setCredit(BigDecimal.valueOf(2500));
//////
//////        bankRepository.save(account);
//
//
//        //not sure if jpa creates a new account if the id does not exist
//        //intention is to test for situation where we pass a non existing acount to be updated
//        //expected a null
//        bankRepository.save(account);
//
//        assertNull(account);
//    }

}