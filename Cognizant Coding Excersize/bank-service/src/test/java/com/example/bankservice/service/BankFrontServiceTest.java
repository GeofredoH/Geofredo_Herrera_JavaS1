package com.example.bankservice.service;

import com.example.bankservice.model.Account;
import com.example.bankservice.util.feign.BankCrudClient;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BankFrontServiceTest {

    @Mock
    BankCrudClient client;

    @InjectMocks
    BankFrontService service;

    @Before
    public void setUp() {
    }


    @Test
    public void getAccount() {
       Account account = new Account();
       account.setAccountNumber(100);
       account.setCredit(BigDecimal.valueOf(500));

        Mockito.when(client.getAccount(100)).thenReturn(account);

        BigDecimal account1 = service.getBalance(100);

        assertEquals(account.getCredit(), account1);


    }

    @Test
    public void updateBalance() {
        Account account = new Account();
        account.setAccountNumber(100);
        account.setCredit(BigDecimal.valueOf(500));

        Mockito.when(client.getAccount(100)).thenReturn(account);
//        verify(client.updateAccount(any(Account.class));

    }


}