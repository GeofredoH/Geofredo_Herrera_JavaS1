package com.company.GeofredoHerreraU1Capstone.dao.dao;

import com.company.GeofredoHerreraU1Capstone.dao.dto.Invoice;

import java.util.List;

public interface InvoiceDao {

    Invoice addInvoice(Invoice invoice);

    Invoice getInvoiceById(int id);

    List<Invoice> getAllInvoices();

    void deleteInvoiceById(int id);

}
