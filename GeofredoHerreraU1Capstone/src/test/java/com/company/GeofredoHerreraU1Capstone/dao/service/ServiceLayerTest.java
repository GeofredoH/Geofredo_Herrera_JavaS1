package com.company.GeofredoHerreraU1Capstone.dao.service;

import com.company.GeofredoHerreraU1Capstone.dao.dao.*;
import com.company.GeofredoHerreraU1Capstone.dao.dto.*;
import com.company.GeofredoHerreraU1Capstone.dao.viewModel.ConsoleViewModel;
import com.company.GeofredoHerreraU1Capstone.dao.viewModel.GameViewModel;
import com.company.GeofredoHerreraU1Capstone.dao.viewModel.InvoiceViewModel;
import com.company.GeofredoHerreraU1Capstone.dao.viewModel.TShirtViewModel;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ServiceLayerTest {

    ConsoleDao consoleDao;
    GameDao gameDao;
    TShirtDao tShirtDao;
    InvoiceDao invoiceDao;
    ProcessingFeeDao processingFeeDao;
    TaxDao taxDao;
    ServiceLayer service;

    @Before
    public void setUp() throws Exception {

        setUpConsoleDaoMock();
        setUpGameDaoMock();
        setUpTShirtDaoMock();
        setUpInvoiceDaoMock();
        setUpProcessingFeeDaoMock();
        setUpTaxDaoMock();

        service = new ServiceLayer(gameDao, consoleDao, tShirtDao, invoiceDao, taxDao, processingFeeDao);
    }

    private void setUpConsoleDaoMock() {

        consoleDao = mock(ConsoleDaoJdbcTemplateImpl.class);

        List<Console> consoleByManufacturer = new ArrayList<>();

        Console console1 = new Console();
        console1.setConsoleId(40);
        console1.setModel("Playstation");
        console1.setManufacturer("Sony");
        console1.setMemoryAmount("120gb");
        console1.setProcessor("Intel I7-9750H");
        console1.setPrice(new BigDecimal("299.99"));
        console1.setQuantity(4);
        consoleByManufacturer.add(console1);

        Console console2 = new Console();
        console2.setModel("Playstation");
        console2.setManufacturer("Sony");
        console2.setMemoryAmount("120gb");
        console2.setProcessor("Intel I7-9750H");
        console2.setPrice(new BigDecimal("299.99"));
        console2.setQuantity(4);

        Console console3 = new Console();
        console3.setModel("Xbox");
        console3.setManufacturer("Sony");
        console3.setMemoryAmount("256gb");
        console3.setProcessor("Intel I7-9750H");
        console3.setPrice(new BigDecimal("399.99"));
        console3.setQuantity(4);

        Console console4 = new Console();
        console4.setConsoleId(34);
        console4.setModel("Xbox");
        console4.setManufacturer("Sony");
        console4.setMemoryAmount("256gb");
        console4.setProcessor("Intel I7-9750H");
        console4.setPrice(new BigDecimal("399.99"));
        console4.setQuantity(4);
        consoleByManufacturer.add(console4);


        doReturn(console1).when(consoleDao).addConsole(console2);
        doReturn(console4).when(consoleDao).addConsole(console3);
        doReturn(console1).when(consoleDao).getConsoleById(40);
        doReturn(consoleByManufacturer).when(consoleDao).getConsoleByManufacturer("Sony");


    }

    private void setUpGameDaoMock() {
        gameDao = mock(GameDaoJdbcTemplateImpl.class);

        List<Game> gamesByEsrb = new ArrayList<>();
        List<Game> gamesByTitle = new ArrayList<>();
        List<Game> gamesByStudio = new ArrayList<>();

        //No ID in this "game" object
        Game game = new Game();
        game.setTitle("Halo");
        game.setEsrbRating("E10+");
        game.setDescription("Puzzles and Math");
        game.setPrice(new BigDecimal("23.99"));
        game.setStudio("Xbox Game Studios");
        game.setQuantity(5);

        Game game1 = new Game();
        game1.setGameId(32);
        game1.setTitle("Halo");
        game1.setEsrbRating("E10+");
        game1.setDescription("Puzzles and Math");
        game1.setPrice(new BigDecimal("23.99"));
        game1.setStudio("Xbox Game Studios");
        game1.setQuantity(5);
        gamesByEsrb.add(game1);
        gamesByTitle.add(game1);

        Game gameExtra2 = new Game();
        gameExtra2.setTitle("Tetris");
        gameExtra2.setEsrbRating("E10+");
        gameExtra2.setDescription("block puzzle game");
        gameExtra2.setPrice(new BigDecimal("10.99"));
        gameExtra2.setStudio("Dolby Studios");
        gameExtra2.setQuantity(9);

        Game game2 = new Game();
        game2.setGameId(25);
        game2.setTitle("Tetris");
        game2.setEsrbRating("E10+");
        game2.setDescription("block puzzle game");
        game2.setPrice(new BigDecimal("10.99"));
        game2.setStudio("Dolby Studios");
        game2.setQuantity(9);
        gamesByEsrb.add(game2);
        gamesByStudio.add(game2);

        Game gameExtra3 = new Game();
        gameExtra3.setTitle("Halo Origins");
        gameExtra3.setEsrbRating("M");
        gameExtra3.setDescription("Zombie shooter game");
        gameExtra3.setPrice(new BigDecimal("17.99"));
        gameExtra3.setStudio("Dolby Studios");
        gameExtra3.setQuantity(3);

        Game game3 = new Game();
        game3.setGameId(60);
        game3.setTitle("Halo Origins");
        game3.setEsrbRating("M");
        game3.setDescription("Zombie shooter game");
        game3.setPrice(new BigDecimal("17.99"));
        game3.setStudio("Dolby Studios");
        game3.setQuantity(3);
        gamesByTitle.add(game3);
        gamesByStudio.add(game3);

        doReturn(game1).when(gameDao).addGame(game);
        doReturn(game3).when(gameDao).getGame(60);
        doReturn(game1).when(gameDao).getGame(32);
        doReturn(game2).when(gameDao).addGame(gameExtra2);
        doReturn(game3).when(gameDao).addGame(gameExtra3);

        doReturn(gamesByEsrb).when(gameDao).getGameByEsrbRating("E10+");
        doReturn(gamesByStudio).when(gameDao).getGameByStudio("Dolby Studios");
        doReturn(gamesByTitle).when(gameDao).getGameByTitle("Halo");

    }

    private void setUpTShirtDaoMock() {
        tShirtDao = mock(TShirtDaoJdbcTemplateImpl.class);

        List<TShirt> tShirtsByColor = new ArrayList<>();
        List<TShirt> tShirtsBySize = new ArrayList<>();

        TShirt tShirt = new TShirt();
        tShirt.setSize("Medium");
        tShirt.setColor("Blue");
        tShirt.setDescription("V-Neck");
        tShirt.setPrice(new BigDecimal("19.99").setScale(2, RoundingMode.HALF_UP));
        tShirt.setQuantity(5);

        TShirt tShirt1 = new TShirt();
        tShirt1.settShirtId(54);
        tShirt1.setSize("Medium");
        tShirt1.setColor("Blue");
        tShirt1.setDescription("V-Neck");
        tShirt1.setPrice(new BigDecimal("19.99"));
        tShirt1.setQuantity(5);
        tShirtsByColor.add(tShirt1);
        tShirtsBySize.add(tShirt1);

        TShirt tShirtExtra2 = new TShirt();
        tShirtExtra2.setSize("Large");
        tShirtExtra2.setColor("Blue");
        tShirtExtra2.setDescription("long sleeve");
        tShirtExtra2.setPrice(new BigDecimal("30.99"));
        tShirtExtra2.setQuantity(8);

        TShirt tShirt2 = new TShirt();
        tShirt2.settShirtId(60);
        tShirt2.setSize("Large");
        tShirt2.setColor("Blue");
        tShirt2.setDescription("long sleeve");
        tShirt2.setPrice(new BigDecimal("30.99"));
        tShirt2.setQuantity(8);
        tShirtsByColor.add(tShirt2);

        TShirt tShirtExtra3 = new TShirt();
        tShirtExtra3.setSize("Medium");
        tShirtExtra3.setColor("orange");
        tShirtExtra3.setDescription("sleeveless");
        tShirtExtra3.setPrice(new BigDecimal("15.99"));
        tShirtExtra3.setQuantity(3);

        TShirt tShirt3 = new TShirt();
        tShirt3.settShirtId(72);
        tShirt3.setSize("Medium");
        tShirt3.setColor("orange");
        tShirt3.setDescription("sleeveless");
        tShirt3.setPrice(new BigDecimal("15.99"));
        tShirt3.setQuantity(3);
        tShirtsBySize.add(tShirt3);

        doReturn(tShirt1).when(tShirtDao).addTShirt(tShirt);
        doReturn(tShirt2).when(tShirtDao).addTShirt(tShirtExtra2);
        doReturn(tShirt3).when(tShirtDao).addTShirt(tShirtExtra3);
        doReturn(tShirt3).when(tShirtDao).getTShirtById(72);
        doReturn(tShirt1).when(tShirtDao).getTShirtById(54);

        doReturn(tShirtsByColor).when(tShirtDao).getTShirtByColor("Blue");
        doReturn(tShirtsBySize).when(tShirtDao).getTShirtBySize("Medium");

    }

    private void setUpInvoiceDaoMock() {
        invoiceDao = mock(InvoiceDaoJdbcTemplateImpl.class);

        Invoice invoice = new Invoice();
        invoice.setName("John Jake");
        invoice.setStreet("street");
        invoice.setCity("Charlotte");
        invoice.setState("NC");
        invoice.setZipcode("83749");
        invoice.setItemType("T-Shirt");
        invoice.setItemId(54);
        invoice.setUnitPrice(new BigDecimal(19.99).setScale(2, RoundingMode.HALF_UP));
        invoice.setQuantity(2);
        invoice.setSubtotal(new BigDecimal(39.98).setScale(2, RoundingMode.HALF_UP));
        invoice.setTax(new BigDecimal(2).setScale(2, RoundingMode.HALF_UP));
        invoice.setProcessingFee(new BigDecimal(1.98).setScale(2, RoundingMode.HALF_UP));
        invoice.setTotal(new BigDecimal(43.96).setScale(2, RoundingMode.HALF_UP));

        Invoice invoice1 = new Invoice();
        invoice1.setInvoiceId(20);
        invoice1.setName("John Jake");
        invoice1.setStreet("street");
        invoice1.setCity("Charlotte");
        invoice1.setState("NC");
        invoice1.setZipcode("83749");
        invoice1.setItemType("T-Shirt");
        invoice1.setItemId(54);
        invoice1.setUnitPrice(new BigDecimal(19.99).setScale(2, RoundingMode.HALF_UP));
        invoice1.setQuantity(2);
        invoice1.setSubtotal(new BigDecimal(39.98).setScale(2, RoundingMode.HALF_UP));
        invoice1.setTax(new BigDecimal(2).setScale(2, RoundingMode.HALF_UP));
        invoice1.setProcessingFee(new BigDecimal(1.98).setScale(2, RoundingMode.HALF_UP));
        invoice1.setTotal(new BigDecimal(43.96).setScale(2, RoundingMode.HALF_UP));

        doReturn(invoice1).when(invoiceDao).addInvoice(invoice);
        doReturn(invoice1).when(invoiceDao).getInvoiceById(20);

    }

    private void setUpProcessingFeeDaoMock() {

        processingFeeDao = mock(ProcessingFeeDaoJdbcTemplateImpl.class);

        ProcessingFee processingFee = new ProcessingFee();
        processingFee.setFee(new BigDecimal(1.98).setScale(2, RoundingMode.HALF_UP));
        processingFee.setProductType("T-Shirt");

        doReturn(processingFee).when(processingFeeDao).getProcessingFee("T-Shirt");

    }

    private void setUpTaxDaoMock() {
        taxDao = mock(TaxDaoJdbcTemplateImpl.class);

        Tax tax = new Tax();
        tax.setRate(new BigDecimal(.05).setScale(2, RoundingMode.HALF_UP));
        tax.setState("NC");

        doReturn(tax).when(taxDao).getTaxRate("NC");

    }

    @Test
    public void createFindInvoice() {
        TShirtViewModel tShirt = new TShirtViewModel();
        tShirt.setSize("Medium");
        tShirt.setColor("Blue");
        tShirt.setDescription("V-Neck");
        tShirt.setPrice(new BigDecimal("19.99").setScale(2, RoundingMode.HALF_UP));
        tShirt.setQuantity(5);
        tShirt = service.createTShirt(tShirt);

        InvoiceViewModel invoiceViewModel = new InvoiceViewModel();
        invoiceViewModel.setName("John Jake");
        invoiceViewModel.setStreet("street");
        invoiceViewModel.setCity("Charlotte");
        invoiceViewModel.setState("NC");
        invoiceViewModel.setZipcode("83749");
        invoiceViewModel.setItemType("T-Shirt");
        invoiceViewModel.setItemId(54);
        invoiceViewModel.setQuantity(2);

        invoiceViewModel = service.createInvoice(invoiceViewModel);

        InvoiceViewModel ivmfromService = service.getInvoiceViewModel(invoiceViewModel.getInvoiceId());

        assertEquals(invoiceViewModel, ivmfromService);

    }

    @Test
    public void createFindGame() {

        GameViewModel gameViewModel = new GameViewModel();
        gameViewModel.setTitle("Halo");
        gameViewModel.setEsrbRating("E10+");
        gameViewModel.setDescription("Puzzles and Math");
        gameViewModel.setPrice(new BigDecimal("23.99"));
        gameViewModel.setStudio("Xbox Game Studios");
        gameViewModel.setQuantity(5);
        gameViewModel = service.createGame(gameViewModel);

        GameViewModel gameViewModel2 = service.getGameViewModelById(32);

        assertEquals(gameViewModel, gameViewModel2);

    }

    @Test
    public void updateGameViewModel() {

        GameViewModel game = new GameViewModel();
        game.setTitle("Halo");
        game.setEsrbRating("E10+");
        game.setDescription("Puzzles and Math");
        game.setPrice(new BigDecimal("23.99"));
        game.setStudio("Xbox Game Studios");
        game.setQuantity(5);
        game = service.createGame(game);

        game.setPrice(new BigDecimal("20.99"));
        game.setQuantity(3);
        service.updateGameViewModel(game);

        verify(gameDao).updateGame(any(Game.class));

    }

    @Test
    public void deleteGameViewModel() {

        GameViewModel game = new GameViewModel();
        game.setTitle("Halo");
        game.setEsrbRating("E10+");
        game.setDescription("Puzzles and Math");
        game.setPrice(new BigDecimal("23.99"));
        game.setStudio("Xbox Game Studios");
        game.setQuantity(5);
        game = service.createGame(game);

        service.deleteGameViewModel(game.getGameId());

        verify(gameDao).deleteGame(any(Integer.class));

    }

    @Test
    public void getGameViewModelByEsrb() {

        List<GameViewModel> gamesByEsrb = new ArrayList<>();

        GameViewModel game1 = new GameViewModel();
        game1.setTitle("Halo");
        game1.setEsrbRating("E10+");
        game1.setDescription("Puzzles and Math");
        game1.setPrice(new BigDecimal("23.99"));
        game1.setStudio("Xbox Game Studios");
        game1.setQuantity(5);
        game1 = service.createGame(game1);
        gamesByEsrb.add(game1);

        GameViewModel gameExtra = new GameViewModel();
        gameExtra.setTitle("Tetris");
        gameExtra.setEsrbRating("E10+");
        gameExtra.setDescription("block puzzle game");
        gameExtra.setPrice(new BigDecimal("10.99"));
        gameExtra.setStudio("Dolby Studios");
        gameExtra.setQuantity(9);
        gameExtra = service.createGame(gameExtra);
        gamesByEsrb.add(gameExtra);

        List<GameViewModel> gvmFromService = service.getGameViewModelByEsrb("E10+");

        assertEquals(gamesByEsrb, gvmFromService);
    }

    @Test
    public void getGameViewModelByTitle() {
        List<GameViewModel> gvmList = new ArrayList<>();

        GameViewModel game = new GameViewModel();
        game.setTitle("Halo");
        game.setEsrbRating("E10+");
        game.setDescription("Puzzles and Math");
        game.setPrice(new BigDecimal("23.99"));
        game.setStudio("Xbox Game Studios");
        game.setQuantity(5);
        game = service.createGame(game);
        gvmList.add(game);

        GameViewModel game2 = new GameViewModel();
        game2.setTitle("Halo Origins");
        game2.setEsrbRating("M");
        game2.setDescription("Zombie shooter game");
        game2.setPrice(new BigDecimal("17.99"));
        game2.setStudio("Dolby Studios");
        game2.setQuantity(3);
        game2 = service.createGame(game2);
        gvmList.add(game2);

        List<GameViewModel> gvmFromService = service.getGameViewModelByTitle("Halo");

    }

    @Test
    public void getGameViewModelByStudio() {
        List<GameViewModel> gvmList = new ArrayList<>();

        GameViewModel gameExtra2 = new GameViewModel();
        gameExtra2.setTitle("Tetris");
        gameExtra2.setEsrbRating("E10+");
        gameExtra2.setDescription("block puzzle game");
        gameExtra2.setPrice(new BigDecimal("10.99"));
        gameExtra2.setStudio("Dolby Studios");
        gameExtra2.setQuantity(9);
        gameExtra2 = service.createGame(gameExtra2);
        gvmList.add(gameExtra2);

        GameViewModel gameExtra3 = new GameViewModel();
        gameExtra3.setTitle("Halo Origins");
        gameExtra3.setEsrbRating("M");
        gameExtra3.setDescription("Zombie shooter game");
        gameExtra3.setPrice(new BigDecimal("17.99"));
        gameExtra3.setStudio("Dolby Studios");
        gameExtra3.setQuantity(3);
        gameExtra3 = service.createGame(gameExtra3);
        gvmList.add(gameExtra3);

        List<GameViewModel> gvmFromService = service.getGameViewModelByStudio("Dolby Studios");

        assertEquals(gvmList, gvmFromService);
    }

    @Test
    public void createGetConsoleViewModel() {

        ConsoleViewModel console = new ConsoleViewModel();
        console.setModel("Playstation");
        console.setManufacturer("Sony");
        console.setMemoryAmount("120gb");
        console.setProcessor("Intel I7-9750H");
        console.setPrice(new BigDecimal("299.99"));
        console.setQuantity(4);
        console = service.createConsoleViewModel(console);

        ConsoleViewModel console1 = service.getConsoleViewModelById(console.getConsoleId());

        assertEquals(console, console1);


    }

    @Test
    public void updateConsoleViewModel() {
        ConsoleViewModel console2 = new ConsoleViewModel();
        console2.setModel("Playstation");
        console2.setManufacturer("Sony");
        console2.setMemoryAmount("120gb");
        console2.setProcessor("Intel I7-9750H");
        console2.setPrice(new BigDecimal("299.99"));
        console2.setQuantity(4);
        console2 = service.createConsoleViewModel(console2);

        console2.setQuantity(6);
        console2.setPrice(new BigDecimal(289.99));

        service.updateConsoleViewModel(console2);

        verify(consoleDao).updateConsole(any(Console.class));

    }

    @Test
    public void deleteConsoleViewModel() {

        ConsoleViewModel console2 = new ConsoleViewModel();
        console2.setModel("Playstation");
        console2.setManufacturer("Sony");
        console2.setMemoryAmount("120gb");
        console2.setProcessor("Intel I7-9750H");
        console2.setPrice(new BigDecimal("299.99"));
        console2.setQuantity(4);
        console2 = service.createConsoleViewModel(console2);

        service.deleteConsoleViewModel(console2.getConsoleId());

        verify(consoleDao).deleteConsoleById(console2.getConsoleId());
    }

    @Test
    public void getConsoleViewModelByManufacturer() {
        List<ConsoleViewModel> cvmList = new ArrayList<>();

        ConsoleViewModel console2 = new ConsoleViewModel();
        console2.setModel("Playstation");
        console2.setManufacturer("Sony");
        console2.setMemoryAmount("120gb");
        console2.setProcessor("Intel I7-9750H");
        console2.setPrice(new BigDecimal("299.99"));
        console2.setQuantity(4);
        console2 = service.createConsoleViewModel(console2);
        cvmList.add(console2);

        ConsoleViewModel console3 = new ConsoleViewModel();
        console3.setModel("Xbox");
        console3.setManufacturer("Sony");
        console3.setMemoryAmount("256gb");
        console3.setProcessor("Intel I7-9750H");
        console3.setPrice(new BigDecimal("399.99"));
        console3.setQuantity(4);
        console3 = service.createConsoleViewModel(console3);
        cvmList.add(console3);

        List<ConsoleViewModel> cvmFromService = service.getConsoleViewModelByManufacturer("Sony");

        assertEquals(cvmList, cvmFromService);
    }

    @Test
    public void createTShirt() {
        TShirtViewModel tShirt = new TShirtViewModel();
        tShirt.setSize("Medium");
        tShirt.setColor("Blue");
        tShirt.setDescription("V-Neck");
        tShirt.setPrice(new BigDecimal("19.99"));
        tShirt.setQuantity(5);
        tShirt = service.createTShirt(tShirt);

        TShirtViewModel tShirtFromService = service.getTShirtViewModel(tShirt.gettShirtId());

        assertEquals(tShirt, tShirtFromService);

    }

    @Test
    public void updateTShirtViewModel() {

        TShirtViewModel tShirt = new TShirtViewModel();
        tShirt.setSize("Medium");
        tShirt.setColor("Blue");
        tShirt.setDescription("V-Neck");
        tShirt.setPrice(new BigDecimal(19.99).setScale(2, RoundingMode.HALF_UP));
        tShirt.setQuantity(5);
        tShirt = service.createTShirt(tShirt);

        tShirt.setQuantity(3);
        tShirt.setPrice(new BigDecimal(18.99).setScale(2, RoundingMode.HALF_UP));

        service.updateTShirtViewModel(tShirt);

        verify(tShirtDao).updateTShirt(any(TShirt.class));

    }

    @Test
    public void deleteTShirtViewModel() {

        TShirtViewModel tShirt = new TShirtViewModel();
        tShirt.setSize("Medium");
        tShirt.setColor("Blue");
        tShirt.setDescription("V-Neck");
        tShirt.setPrice(new BigDecimal("19.99"));
        tShirt.setQuantity(5);
        tShirt = service.createTShirt(tShirt);

        service.deleteTShirtViewModel(tShirt.gettShirtId());

        verify(tShirtDao).deleteTShirt(any(Integer.class));

    }

    @Test
    public void getTShirtViewModelByColor() {
        List<TShirtViewModel> tvmList = new ArrayList<>();

        TShirtViewModel tShirt = new TShirtViewModel();
        tShirt.setSize("Medium");
        tShirt.setColor("Blue");
        tShirt.setDescription("V-Neck");
        tShirt.setPrice(new BigDecimal("19.99"));
        tShirt.setQuantity(5);
        tShirt = service.createTShirt(tShirt);
        tvmList.add(tShirt);

        TShirtViewModel tShirtExtra2 = new TShirtViewModel();
        tShirtExtra2.setSize("Large");
        tShirtExtra2.setColor("Blue");
        tShirtExtra2.setDescription("long sleeve");
        tShirtExtra2.setPrice(new BigDecimal("30.99"));
        tShirtExtra2.setQuantity(8);
        tShirtExtra2 = service.createTShirt(tShirtExtra2);
        tvmList.add(tShirtExtra2);

        List<TShirtViewModel> tvmFromService = service.getTShirtViewModelByColor("Blue");

        assertEquals(tvmList, tvmFromService);

    }

    @Test
    public void getTShirtViewModelBySize() {
        List<TShirtViewModel> tvmList = new ArrayList<>();

        TShirtViewModel tShirt = new TShirtViewModel();
        tShirt.setSize("Medium");
        tShirt.setColor("Blue");
        tShirt.setDescription("V-Neck");
        tShirt.setPrice(new BigDecimal("19.99"));
        tShirt.setQuantity(5);
        tShirt = service.createTShirt(tShirt);
        tvmList.add(tShirt);

        TShirtViewModel tShirtExtra3 = new TShirtViewModel();
        tShirtExtra3.setSize("Medium");
        tShirtExtra3.setColor("orange");
        tShirtExtra3.setDescription("sleeveless");
        tShirtExtra3.setPrice(new BigDecimal("15.99"));
        tShirtExtra3.setQuantity(3);
        tShirtExtra3 = service.createTShirt(tShirtExtra3);
        tvmList.add(tShirtExtra3);

        List<TShirtViewModel> tvmFromService = service.getTShirtViewModelBySize("Medium");

        assertEquals(tvmList, tvmFromService);

    }
}