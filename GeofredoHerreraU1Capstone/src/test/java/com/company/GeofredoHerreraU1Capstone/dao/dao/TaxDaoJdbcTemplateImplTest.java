package com.company.GeofredoHerreraU1Capstone.dao.dao;

import com.company.GeofredoHerreraU1Capstone.dao.dto.Tax;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TaxDaoJdbcTemplateImplTest {

    @Autowired
    TaxDao taxDao;

    @Test
    public void getTaxRate() {

        Tax tax1 = new Tax();

        tax1.setState("NC");
        tax1.setRate(new BigDecimal(".05"));

        Tax tax2 = taxDao.getTaxRate("nc");

        assertEquals(tax2, tax1);
    }
}