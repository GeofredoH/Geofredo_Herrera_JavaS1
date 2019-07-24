package com.company.GeofredoHerreraU1Capstone.dao.dao;

import com.company.GeofredoHerreraU1Capstone.dao.dto.TShirt;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TShirtDaoJdbcTemplateImplTest {

    @Autowired
    TShirtDao tShirtDao;

    @Before
    public void setUp() throws Exception {
        List<TShirt> tShirtList = tShirtDao.getAllTShirts();
        tShirtList.stream()
                .forEach(t -> tShirtDao.deleteTShirt(t.gettShirtId()));
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addGetTShirt() {
        TShirt tShirt1 = new TShirt();
        tShirt1.setSize("Medium");
        tShirt1.setColor("Blue");
        tShirt1.setDescription("V-Neck");
        tShirt1.setPrice(new BigDecimal("19.99"));
        tShirt1.setQuantity(5);
        tShirt1 = tShirtDao.addTShirt(tShirt1);

        TShirt tShirt2 = tShirtDao.getTShirtById(tShirt1.gettShirtId());

        assertEquals(tShirt1, tShirt2);
    }

    @Test
    public void getAllTShirts() {
        List<TShirt> tShirts = new ArrayList<>();

        TShirt tShirt1 = new TShirt();
        tShirt1.setSize("Medium");
        tShirt1.setColor("Blue");
        tShirt1.setDescription("V-Neck");
        tShirt1.setPrice(new BigDecimal("19.99"));
        tShirt1.setQuantity(5);
        tShirt1 = tShirtDao.addTShirt(tShirt1);
        tShirts.add(tShirt1);

        TShirt tShirt2 = new TShirt();
        tShirt2.setSize("Large");
        tShirt2.setColor("Red");
        tShirt2.setDescription("long sleeve");
        tShirt2.setPrice(new BigDecimal("30.99"));
        tShirt2.setQuantity(8);
        tShirt2 = tShirtDao.addTShirt(tShirt2);
        tShirts.add(tShirt2);

        List<TShirt> tShirtsFromDb = tShirtDao.getAllTShirts();

        assertEquals(tShirts, tShirtsFromDb);

    }

    @Test
    public void updateTShirt() {

        TShirt tShirt1 = new TShirt();
        tShirt1.setSize("Medium");
        tShirt1.setColor("Blue");
        tShirt1.setDescription("V-Neck");
        tShirt1.setPrice(new BigDecimal("19.99"));
        tShirt1.setQuantity(5);
        tShirt1 = tShirtDao.addTShirt(tShirt1);

        tShirt1.setPrice(new BigDecimal("13.99"));
        tShirt1.setSize("Large");
        tShirt1.setQuantity(9);

        tShirtDao.updateTShirt(tShirt1);

        TShirt tShirt2 = tShirtDao.getTShirtById(tShirt1.gettShirtId());

        assertEquals(tShirt1, tShirt2);

    }

    @Test
    public void deleteTShirt() {

        TShirt tShirt1 = new TShirt();
        tShirt1.setSize("Medium");
        tShirt1.setColor("Blue");
        tShirt1.setDescription("V-Neck");
        tShirt1.setPrice(new BigDecimal("19.99"));
        tShirt1.setQuantity(5);
        tShirt1 = tShirtDao.addTShirt(tShirt1);

        tShirtDao.deleteTShirt(tShirt1.gettShirtId());

        tShirt1 = tShirtDao.getTShirtById(tShirt1.gettShirtId());

        assertNull(tShirt1);
    }

    @Test
    public void getTShirtByColor() {
        List<TShirt> tShirts = new ArrayList<>();

        TShirt tShirt1 = new TShirt();
        tShirt1.setSize("Medium");
        tShirt1.setColor("Blue");
        tShirt1.setDescription("V-Neck");
        tShirt1.setPrice(new BigDecimal("19.99"));
        tShirt1.setQuantity(5);
        tShirt1 = tShirtDao.addTShirt(tShirt1);
        tShirts.add(tShirt1);

        TShirt tShirt2 = new TShirt();
        tShirt2.setSize("Large");
        tShirt2.setColor("Blue");
        tShirt2.setDescription("long sleeve");
        tShirt2.setPrice(new BigDecimal("30.99"));
        tShirt2.setQuantity(8);
        tShirt2 = tShirtDao.addTShirt(tShirt2);
        tShirts.add(tShirt2);

        TShirt tShirt3 = new TShirt();
        tShirt3.setSize("small");
        tShirt3.setColor("orange");
        tShirt3.setDescription("sleeveless");
        tShirt3.setPrice(new BigDecimal("15.99"));
        tShirt3.setQuantity(3);
        tShirt3 = tShirtDao.addTShirt(tShirt3);

        List<TShirt> tShirtsFromDb = tShirtDao.getTShirtByColor(tShirt2.getColor());

        assertEquals(tShirts, tShirtsFromDb);

    }

    @Test
    public void getTShirtBySize() {
        List<TShirt> tShirts = new ArrayList<>();

        TShirt tShirt1 = new TShirt();
        tShirt1.setSize("Large");
        tShirt1.setColor("Blue");
        tShirt1.setDescription("V-Neck");
        tShirt1.setPrice(new BigDecimal("19.99"));
        tShirt1.setQuantity(5);
        tShirt1 = tShirtDao.addTShirt(tShirt1);
        tShirts.add(tShirt1);

        TShirt tShirt2 = new TShirt();
        tShirt2.setSize("Large");
        tShirt2.setColor("Blue");
        tShirt2.setDescription("long sleeve");
        tShirt2.setPrice(new BigDecimal("30.99"));
        tShirt2.setQuantity(8);
        tShirt2 = tShirtDao.addTShirt(tShirt2);
        tShirts.add(tShirt2);

        TShirt tShirt3 = new TShirt();
        tShirt3.setSize("small");
        tShirt3.setColor("orange");
        tShirt3.setDescription("sleeveless");
        tShirt3.setPrice(new BigDecimal("15.99"));
        tShirt3.setQuantity(3);
        tShirt3 = tShirtDao.addTShirt(tShirt3);

        List<TShirt> tShirtsFromDb = tShirtDao.getTShirtBySize(tShirt2.getSize());

        assertEquals(tShirts, tShirtsFromDb);

    }
}