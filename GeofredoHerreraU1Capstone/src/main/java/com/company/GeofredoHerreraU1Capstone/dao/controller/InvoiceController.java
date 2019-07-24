package com.company.GeofredoHerreraU1Capstone.dao.controller;

import com.company.GeofredoHerreraU1Capstone.dao.Exception.NotFoundException;
import com.company.GeofredoHerreraU1Capstone.dao.service.ServiceLayer;
import com.company.GeofredoHerreraU1Capstone.dao.viewModel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/invoice")
public class InvoiceController {

    @Autowired
    ServiceLayer service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InvoiceViewModel purchaseItem(@RequestBody @Valid InvoiceViewModel invoiceViewModel) {
        invoiceViewModel = service.createInvoice(invoiceViewModel);
//        if(invoiceViewModel == null){
//            throw new IllegalArgumentException("Invoice quantity exceeds number of items in stock");
//        }
        return invoiceViewModel;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public InvoiceViewModel findInvoice(@PathVariable("id") int invoiceId) {
        InvoiceViewModel invoiceViewModel = service.getInvoiceViewModel(invoiceId);
        if (invoiceViewModel == null) {
            throw new NotFoundException("Invoice could not be retrieved for id " + invoiceId);
        } else {
            return invoiceViewModel;
        }
    }
}
