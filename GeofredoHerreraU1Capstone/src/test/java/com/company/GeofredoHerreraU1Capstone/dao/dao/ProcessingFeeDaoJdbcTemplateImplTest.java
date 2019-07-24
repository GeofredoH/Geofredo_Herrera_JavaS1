package com.company.GeofredoHerreraU1Capstone.dao.dao;

import com.company.GeofredoHerreraU1Capstone.dao.dto.ProcessingFee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ProcessingFeeDaoJdbcTemplateImplTest {

    @Autowired
    ProcessingFeeDao processingFeeDao;

    @Test
    public void getProcessingFee() {
        ProcessingFee processingFee = new ProcessingFee();
        processingFee.setProductType("Console");
        processingFee.setFee(new BigDecimal("14.99"));

        ProcessingFee processingFee2 = processingFeeDao.getProcessingFee("Console");

        assertEquals(processingFee, processingFee2);

        ProcessingFee processingFee3 = new ProcessingFee();
        processingFee3.setProductType("T-Shirt");
        processingFee3.setFee(new BigDecimal("1.98"));

        ProcessingFee processingFee4 = processingFeeDao.getProcessingFee("T-Shirt");

        assertEquals(processingFee3, processingFee4);
    }
}