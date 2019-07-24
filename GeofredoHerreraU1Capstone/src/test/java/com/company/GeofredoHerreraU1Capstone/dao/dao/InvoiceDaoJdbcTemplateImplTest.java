package com.company.GeofredoHerreraU1Capstone.dao.dao;

import com.company.GeofredoHerreraU1Capstone.dao.dto.Console;
import com.company.GeofredoHerreraU1Capstone.dao.dto.Game;
import com.company.GeofredoHerreraU1Capstone.dao.dto.Invoice;
import com.company.GeofredoHerreraU1Capstone.dao.dto.TShirt;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class InvoiceDaoJdbcTemplateImplTest {

    @Autowired
    InvoiceDao invoiceDao;
    @Autowired
    TShirtDao tShirtDao;
    @Autowired
    GameDao gameDao;
    @Autowired
    ConsoleDao consoleDao;
    @Autowired
    TaxDao taxDao;
    @Autowired
    ProcessingFeeDao processingFeeDao;

    @Before
    public void setUp() throws Exception {
        List<Console> consoleList = consoleDao.getAllConsoles();
        consoleList.stream()
                .forEach(i -> consoleDao.deleteConsoleById(i.getConsoleId()));

        List<Game> gameList = gameDao.getAllGames();
        gameList.stream()
                .forEach(i -> gameDao.deleteGame(i.getGameId()));

        List<TShirt> tShirtList = tShirtDao.getAllTShirts();
        tShirtList.stream()
                .forEach(i -> tShirtDao.deleteTShirt(i.gettShirtId()));

        List<Invoice> invoiceList = invoiceDao.getAllInvoices();
        invoiceList.stream()
                .forEach(i -> invoiceDao.deleteInvoiceById(i.getInvoiceId()));
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addGetInvoice() {
        TShirt tShirt1 = new TShirt();
        tShirt1.setSize("medium");
        tShirt1.setColor("Blue");
        tShirt1.setDescription("v-neck short sleeve");
        tShirt1.setPrice(new BigDecimal(15.99).setScale(2, RoundingMode.HALF_UP));
        tShirt1.setQuantity(8);
        tShirt1 = tShirtDao.addTShirt(tShirt1);

        Invoice invoice1 = new Invoice();
        invoice1.setName("John Jake");
        invoice1.setStreet("street");
        invoice1.setCity("Charlotte");
        invoice1.setState("NC");
        invoice1.setZipcode("83749");
        invoice1.setItemType("T-Shirt");
        invoice1.setItemId(tShirt1.gettShirtId());
        invoice1.setUnitPrice(tShirt1.getPrice().setScale(2, RoundingMode.HALF_UP));
        invoice1.setQuantity(2);
        invoice1.setSubtotal(tShirt1.getPrice().multiply(new BigDecimal(invoice1.getQuantity())).setScale(2, RoundingMode.HALF_UP));
        invoice1.setTax(invoice1.getSubtotal().multiply(taxDao.getTaxRate(invoice1.getState()).getRate()).setScale(2, RoundingMode.HALF_UP));
        invoice1.setProcessingFee(processingFeeDao.getProcessingFee(invoice1.getItemType()).getFee().setScale(2, RoundingMode.HALF_UP));
        invoice1.setTotal(invoice1.getSubtotal().add(invoice1.getTax()).add(invoice1.getProcessingFee()).setScale(2, RoundingMode.HALF_UP));
        invoice1 = invoiceDao.addInvoice(invoice1);

        Invoice invoice2 = invoiceDao.getInvoiceById(invoice1.getInvoiceId());

        assertEquals(invoice1, invoice2);
    }
}