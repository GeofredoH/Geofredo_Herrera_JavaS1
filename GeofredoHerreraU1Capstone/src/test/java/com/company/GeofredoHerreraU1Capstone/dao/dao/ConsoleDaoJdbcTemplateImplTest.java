package com.company.GeofredoHerreraU1Capstone.dao.dao;

import com.company.GeofredoHerreraU1Capstone.dao.dto.Console;
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
public class ConsoleDaoJdbcTemplateImplTest {
    @Autowired
    ConsoleDao consoleDao;

    @Before
    public void setUp() throws Exception {
        List<Console> gameList = consoleDao.getAllConsoles();
        gameList.stream()
                .forEach(g -> consoleDao.deleteConsoleById(g.getConsoleId()));
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addConsole() {
        Console console1 = new Console();
        console1.setModel("Playstation");
        console1.setManufacturer("Sony");
        console1.setMemoryAmount("120gb");
        console1.setProcessor("Intel I7-9750H");
        console1.setPrice(new BigDecimal("299.99"));
        console1.setQuantity(4);
        console1 = consoleDao.addConsole(console1);

        Console consoleFromDb = consoleDao.getConsoleById(console1.getConsoleId());

        assertEquals(console1, consoleFromDb);
    }

    @Test
    public void getAllConsoles() {
        List<Console> consoleList = new ArrayList<>();

        Console console1 = new Console();
        console1.setModel("Playstation");
        console1.setManufacturer("Sony");
        console1.setMemoryAmount("120gb");
        console1.setProcessor("Intel I7-9750H");
        console1.setPrice(new BigDecimal("299.99"));
        console1.setQuantity(4);
        console1 = consoleDao.addConsole(console1);
        consoleList.add(console1);

        Console console2 = new Console();
        console2.setModel("XBox");
        console2.setManufacturer("Microsoft");
        console2.setMemoryAmount("256gb");
        console2.setProcessor("AMD Zion");
        console2.setPrice(new BigDecimal("199.99"));
        console2.setQuantity(6);
        console2 = consoleDao.addConsole(console2);
        consoleList.add(console2);

        List<Console> consoleList2 = consoleDao.getAllConsoles();

        assertEquals(consoleList, consoleList2);
    }

    @Test
    public void updateConsole() {

        Console console1 = new Console();
        console1.setModel("Playstation");
        console1.setManufacturer("Sony");
        console1.setMemoryAmount("120gb");
        console1.setProcessor("Intel I7-9750H");
        console1.setPrice(new BigDecimal("299.99"));
        console1.setQuantity(4);
        console1 = consoleDao.addConsole(console1);

        console1.setQuantity(2);
        console1.setPrice(new BigDecimal("259.99"));

        consoleDao.updateConsole(console1);

        Console console2 = consoleDao.getConsoleById(console1.getConsoleId());

        assertEquals(console1, console2);

    }

    @Test
    public void deleteConsoleById() {
        Console console1 = new Console();
        console1.setModel("Playstation");
        console1.setManufacturer("Sony");
        console1.setMemoryAmount("120gb");
        console1.setProcessor("Intel I7-9750H");
        console1.setPrice(new BigDecimal("299.99"));
        console1.setQuantity(4);
        console1 = consoleDao.addConsole(console1);

        consoleDao.deleteConsoleById(console1.getConsoleId());

        console1 = consoleDao.getConsoleById(console1.getConsoleId());

        assertNull(console1);
    }

    @Test
    public void getConsoleByManufacturer() {
        List<Console> consoleList = new ArrayList<>();

        Console console1 = new Console();
        console1.setModel("Playstation");
        console1.setManufacturer("Sony");
        console1.setMemoryAmount("120gb");
        console1.setProcessor("Intel I7-9750H");
        console1.setPrice(new BigDecimal("299.99"));
        console1.setQuantity(4);
        console1 = consoleDao.addConsole(console1);
        consoleList.add(console1);

        Console console2 = new Console();
        console2.setModel("XBox");
        console2.setManufacturer("Microsoft");
        console2.setMemoryAmount("256gb");
        console2.setProcessor("AMD Zion");
        console2.setPrice(new BigDecimal("199.99"));
        console2.setQuantity(6);

        Console console3 = new Console();
        console3.setModel("PSP");
        console3.setManufacturer("Sony");
        console3.setMemoryAmount("100gb");
        console3.setProcessor("Intel I5");
        console3.setPrice(new BigDecimal("139.99"));
        console3.setQuantity(9);
        console3 = consoleDao.addConsole(console3);
        consoleList.add(console3);

        List<Console> consoleList2 = consoleDao.getConsoleByManufacturer("sony");

        assertEquals(consoleList, consoleList2);
    }
}