package com.example.bankcrudservice.dao;

import com.example.bankcrudservice.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
@Repository
public interface BankRepository extends JpaRepository<Account, Integer> {

        BigDecimal findBalanceById(Integer id);

}
