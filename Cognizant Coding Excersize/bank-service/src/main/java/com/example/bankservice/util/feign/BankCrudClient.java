package com.example.bankservice.util.feign;

import com.example.bankservice.model.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "bank-crud-service")
@RequestMapping("/account")
public interface BankCrudClient {

    @GetMapping("/{id}")
    public Account getAccount(@PathVariable("id") int id);

    @PutMapping
    public void updateAccount(@RequestBody Account account);
}
