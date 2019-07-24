package com.company.GeofredoHerreraU1Capstone.dao.service;

import com.company.GeofredoHerreraU1Capstone.dao.Exception.NotFoundException;
import com.company.GeofredoHerreraU1Capstone.dao.dao.*;
import com.company.GeofredoHerreraU1Capstone.dao.dto.*;
import com.company.GeofredoHerreraU1Capstone.dao.viewModel.ConsoleViewModel;
import com.company.GeofredoHerreraU1Capstone.dao.viewModel.GameViewModel;
import com.company.GeofredoHerreraU1Capstone.dao.viewModel.InvoiceViewModel;
import com.company.GeofredoHerreraU1Capstone.dao.viewModel.TShirtViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Component
public class ServiceLayer {

    GameDao gameDao;
    ConsoleDao consoleDao;
    TShirtDao tShirtDao;
    InvoiceDao invoiceDao;
    TaxDao taxDao;
    ProcessingFeeDao processingFeeDao;

    @Autowired
    public ServiceLayer(GameDao gameDao, ConsoleDao consoleDao, TShirtDao tShirtDao, InvoiceDao invoiceDao, TaxDao taxDao, ProcessingFeeDao processingFeeDao) {
        this.gameDao = gameDao;
        this.consoleDao = consoleDao;
        this.tShirtDao = tShirtDao;
        this.invoiceDao = invoiceDao;
        this.taxDao = taxDao;
        this.processingFeeDao = processingFeeDao;
    }

    //INVOICE SERVICE LAYER METHODS, CREATE AND READ********************************************************************

    public InvoiceViewModel createInvoice(InvoiceViewModel invoiceViewModel) {

        Invoice invoice = new Invoice();
        invoice.setName(invoiceViewModel.getName());
        invoice.setStreet(invoiceViewModel.getStreet());
        invoice.setCity(invoiceViewModel.getCity());
        invoice.setState(invoiceViewModel.getState());
        invoice.setZipcode(invoiceViewModel.getZipcode());
        invoice.setItemType(invoiceViewModel.getItemType());
        invoice.setItemId(invoiceViewModel.getItemId());

        //Checks the item type in the invoiceViewModel to query the database and get the correct unit price
        try {
            if (invoiceViewModel.getItemType().equalsIgnoreCase("Console")) {
                invoice.setUnitPrice(consoleDao.getConsoleById(invoiceViewModel.getItemId()).getPrice());
            } else if (invoiceViewModel.getItemType().equalsIgnoreCase("Game")) {
                invoice.setUnitPrice(gameDao.getGame(invoiceViewModel.getItemId()).getPrice());
            } else if (invoiceViewModel.getItemType().equalsIgnoreCase("T-shirt")) {
                invoice.setUnitPrice(tShirtDao.getTShirtById(invoiceViewModel.getItemId()).getPrice());
            } else {
                throw new IllegalArgumentException("The item-type must be a Game , Console , or T-shirt ");
            }
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("Item-id is invalid, no item found.");
        }
        invoice.setQuantity(invoiceViewModel.getQuantity());
        invoice.setSubtotal(invoice.getUnitPrice().multiply(new BigDecimal(invoiceViewModel.getQuantity())).setScale(2, RoundingMode.HALF_UP));

        //Throw Exception if subtotal is greater than 999.99
        if ((invoice.getSubtotal().compareTo(new BigDecimal(999.99)) > 0)) {
            throw new IllegalArgumentException("Subtotal exceeds maximum purchase price of $999.99");
        }

        try {
            invoice.setTax((taxDao.getTaxRate(invoice.getState()).getRate()).multiply(invoice.getSubtotal()));
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("State code is invalid. Could not find tax rate for " + invoice.getState());
        }

        //Checks that a tax rate was returned for the state entered.
        if (invoice.getTax() == null) {
            throw new IllegalArgumentException("Invalid state code. Could not find tax rate for " + invoice.getState());
        }

        invoice.setProcessingFee(processingFeeDao.getProcessingFee(invoiceViewModel.getItemType()).getFee());

        //Checks that a processing fee was returned for the item-type
        if (invoice.getProcessingFee() == null) {
            throw new IllegalArgumentException("Invalid item-type. Could not find processing fee for " + invoice.getItemType()
                    + "item-type must be Console, Game, or T-Shirt ");
        }

        //Checks if quantity of items if greater than 10 and adds additional processing fee
        if (invoiceViewModel.getQuantity() > 10) {
            invoice.setProcessingFee(invoice.getProcessingFee().add(new BigDecimal(15.49)).setScale(2, RoundingMode.HALF_UP));
        }

        invoice.setTotal(invoice.getSubtotal().add(invoice.getProcessingFee()).add(invoice.getTax()));

        //checks total for validation
        if ((invoice.getTotal().compareTo(new BigDecimal(999.99)) > 0)) {
            throw new IllegalArgumentException("Subtotal exceeds maximum purchase price of $999.99");
        }

        //business rule - verify order quantity is less than or equal to quantity in stock
        //subtracts invoice quantity from quantity in stock
        try {
            if (invoiceViewModel.getItemType().equalsIgnoreCase("Console")) {
                if (invoiceViewModel.getQuantity() > (consoleDao.getConsoleById(invoiceViewModel.getItemId()).getQuantity())) {
                    throw new IllegalArgumentException("Order quantity exceeds available quantity");
                } else {
                    Console console = consoleDao.getConsoleById(invoiceViewModel.getItemId());
                    console.setQuantity(console.getQuantity() - invoiceViewModel.getQuantity());
                    consoleDao.updateConsole(console);
                }
            } else if (invoiceViewModel.getItemType().equalsIgnoreCase("Game")) {
                if (invoiceViewModel.getQuantity() > (gameDao.getGame(invoiceViewModel.getItemId()).getQuantity())) {
                    throw new IllegalArgumentException("Order quantity exceeds available quantity");
                } else {
                    Game game = gameDao.getGame(invoiceViewModel.getItemId());
                    game.setQuantity(game.getQuantity() - invoiceViewModel.getQuantity());
                    gameDao.updateGame(game);
                }
            } else if (invoiceViewModel.getItemType().equalsIgnoreCase("T-shirt")) {
                if (invoiceViewModel.getQuantity() > (tShirtDao.getTShirtById(invoiceViewModel.getItemId()).getQuantity())) {
                    throw new IllegalArgumentException("Order quantity exceeds available quantity");
                } else {
                    TShirt tShirt = tShirtDao.getTShirtById(invoiceViewModel.getItemId());
                    tShirt.setQuantity(tShirt.getQuantity() - invoiceViewModel.getQuantity());
                    tShirtDao.updateTShirt(tShirt);
                }
            }
        } catch (NullPointerException e) {
            throw new NotFoundException("No item found for item-id");
        }


        invoice = invoiceDao.addInvoice(invoice);


        return buildInvoiceViewModel(invoice);

    }

    public InvoiceViewModel getInvoiceViewModel(int id) {
        Invoice invoice = invoiceDao.getInvoiceById(id);
        if (invoice == null)
            return null;
        else
            return buildInvoiceViewModel(invoice);
    }


    //GAME SERVICE LAYER METHODS CRUD, GET BY ESRB, GET BY TITLE, GET BY STUDIO*****************************************

    public GameViewModel createGame(GameViewModel gameViewModel) {
        Game game = new Game();
        game.setTitle(gameViewModel.getTitle());
        game.setEsrbRating(gameViewModel.getEsrbRating());
        game.setDescription(gameViewModel.getDescription());
        game.setPrice(gameViewModel.getPrice());
        game.setQuantity(gameViewModel.getQuantity());
        game.setStudio(gameViewModel.getStudio());

        return buildGameViewModel(gameDao.addGame(game));
    }

    public GameViewModel getGameViewModelById(int id) {
        Game game = gameDao.getGame(id);
        if (game == null)
            return null;
        else
            return buildGameViewModel(game);
    }

    public void updateGameViewModel(GameViewModel gameViewModel) {
        Game game = new Game();
        game.setGameId(gameViewModel.getGameId());
        game.setTitle(gameViewModel.getTitle());
        game.setEsrbRating(gameViewModel.getEsrbRating());
        game.setDescription(gameViewModel.getDescription());
        game.setPrice(gameViewModel.getPrice());
        game.setQuantity(gameViewModel.getQuantity());
        game.setStudio(gameViewModel.getStudio());

        gameDao.updateGame(game);
    }

    public void deleteGameViewModel(int id) {
        gameDao.deleteGame(id);
    }

    public List<GameViewModel> getGameViewModelByEsrb(String esrb) {
        List<Game> gameList = gameDao.getGameByEsrbRating(esrb);
        List<GameViewModel> gvmList = new ArrayList<>();
        if (gameList == null)
            return null;
        else

            gameList.stream()
                    .forEach(g -> gvmList.add(buildGameViewModel(g)));

        return gvmList;

    }

    public List<GameViewModel> getGameViewModelByTitle(String title) {
        List<Game> gameList = gameDao.getGameByTitle(title);
        List<GameViewModel> gvmList = new ArrayList<>();
        List<GameViewModel> exceptionList = null;

        if (gameList == null) {
            return exceptionList;
        } else {
            gameList.stream()
                    .forEach(g -> gvmList.add(buildGameViewModel(g)));
        }

        return gvmList;

    }

    public List<GameViewModel> getGameViewModelByStudio(String studio) {
        List<Game> gameList = gameDao.getGameByStudio(studio);
        List<GameViewModel> gvmList = new ArrayList<>();

        if (gameList == null)
            return null;
        else

            gameList.stream()
                    .forEach(g -> gvmList.add(buildGameViewModel(g)));

        return gvmList;
    }

    //CONSOLE SERVICE LAYER METHODS CRUD, GET BY MANUFACTURER***********************************************************

    public ConsoleViewModel createConsoleViewModel(ConsoleViewModel consoleViewModel) {
        Console console = new Console();
        console.setModel(consoleViewModel.getModel());
        console.setManufacturer(consoleViewModel.getManufacturer());
        console.setMemoryAmount(consoleViewModel.getMemoryAmount());
        console.setProcessor(consoleViewModel.getProcessor());
        console.setPrice(consoleViewModel.getPrice());
        console.setQuantity(consoleViewModel.getQuantity());

        return buildConsoleViewModel(consoleDao.addConsole(console));
    }

    public ConsoleViewModel getConsoleViewModelById(int id) {
        Console console = consoleDao.getConsoleById(id);
        if (console == null)
            return null;
        else
            return buildConsoleViewModel(console);
    }

    public void updateConsoleViewModel(ConsoleViewModel consoleViewModel) {
        Console console = new Console();
        console.setConsoleId(consoleViewModel.getConsoleId());
        console.setModel(consoleViewModel.getModel());
        console.setManufacturer(consoleViewModel.getManufacturer());
        console.setMemoryAmount(consoleViewModel.getMemoryAmount());
        console.setProcessor(consoleViewModel.getProcessor());
        console.setPrice(consoleViewModel.getPrice());
        console.setQuantity(consoleViewModel.getQuantity());

        consoleDao.updateConsole(console);
    }

    public void deleteConsoleViewModel(int id) {
        consoleDao.deleteConsoleById(id);
    }

    public List<ConsoleViewModel> getConsoleViewModelByManufacturer(String manufacturer) {
        List<Console> consoleList = consoleDao.getConsoleByManufacturer(manufacturer);
        List<ConsoleViewModel> cvmList = new ArrayList<>();

        if (consoleList == null)
            return null;
        else

            consoleList.stream()
                    .forEach(c -> cvmList.add(buildConsoleViewModel(c)));

        return cvmList;
    }

    //TSHIRT SERVICE LAYER METHODS CRUD, GET BY COLOR, GET BY SIZE******************************************************

    public TShirtViewModel createTShirt(TShirtViewModel tShirtViewModel) {
        TShirt tShirt = new TShirt();
        tShirt.setSize(tShirtViewModel.getSize());
        tShirt.setColor(tShirtViewModel.getColor());
        tShirt.setDescription(tShirtViewModel.getDescription());
        tShirt.setPrice(tShirtViewModel.getPrice());
        tShirt.setQuantity(tShirtViewModel.getQuantity());

        tShirt = tShirtDao.addTShirt(tShirt);

        return buildTShirtViewModel(tShirt);
    }

    public TShirtViewModel getTShirtViewModel(int id) {
        TShirt tShirt = tShirtDao.getTShirtById(id);
        if (tShirt == null)
            return null;
        else
            return buildTShirtViewModel(tShirt);
    }

    public void updateTShirtViewModel(TShirtViewModel tShirtViewModel) {
        TShirt tShirt = new TShirt();
        tShirt.settShirtId(tShirtViewModel.gettShirtId());
        tShirt.setSize(tShirtViewModel.getSize());
        tShirt.setColor(tShirtViewModel.getColor());
        tShirt.setDescription(tShirtViewModel.getDescription());
        tShirt.setPrice(tShirtViewModel.getPrice());
        tShirt.setQuantity(tShirtViewModel.getQuantity());

        tShirtDao.updateTShirt(tShirt);
    }

    public void deleteTShirtViewModel(int id) {
        tShirtDao.deleteTShirt(id);
    }

    public List<TShirtViewModel> getTShirtViewModelByColor(String color) {
        List<TShirt> tShirtList = tShirtDao.getTShirtByColor(color);
        List<TShirtViewModel> tvmList = new ArrayList<>();

        if (tShirtList == null)
            return null;
        else

            tShirtList.stream()
                    .forEach(t -> tvmList.add(buildTShirtViewModel(t)));

        return tvmList;
    }

    public List<TShirtViewModel> getTShirtViewModelBySize(String size) {
        List<TShirt> tShirtList = tShirtDao.getTShirtBySize(size);
        List<TShirtViewModel> tvmList = new ArrayList<>();

        if (tShirtList == null)
            return null;
        else

            tShirtList.stream()
                    .forEach(t -> tvmList.add(buildTShirtViewModel(t)));

        return tvmList;
    }

    //Helper Methods****************************************************************************************************

    public ConsoleViewModel buildConsoleViewModel(Console console) {
        ConsoleViewModel consoleViewModel = new ConsoleViewModel();
        consoleViewModel.setConsoleId(console.getConsoleId());
        consoleViewModel.setModel(console.getModel());
        consoleViewModel.setManufacturer(console.getManufacturer());
        consoleViewModel.setMemoryAmount(console.getMemoryAmount());
        consoleViewModel.setProcessor(console.getProcessor());
        consoleViewModel.setPrice(console.getPrice());
        consoleViewModel.setQuantity(console.getQuantity());

        return consoleViewModel;
    }

    public GameViewModel buildGameViewModel(Game game) {
        GameViewModel gameViewModel = new GameViewModel();
        gameViewModel.setGameId(game.getGameId());
        gameViewModel.setTitle(game.getTitle());
        gameViewModel.setEsrbRating(game.getEsrbRating());
        gameViewModel.setDescription(game.getDescription());
        gameViewModel.setPrice(game.getPrice());
        gameViewModel.setStudio(game.getStudio());
        gameViewModel.setQuantity(game.getQuantity());

        return gameViewModel;
    }

    public TShirtViewModel buildTShirtViewModel(TShirt tShirt) {
        TShirtViewModel tShirtViewModel = new TShirtViewModel();
        tShirtViewModel.settShirtId(tShirt.gettShirtId());
        tShirtViewModel.setSize(tShirt.getSize());
        tShirtViewModel.setColor(tShirt.getColor());
        tShirtViewModel.setDescription(tShirt.getDescription());
        tShirtViewModel.setPrice(tShirt.getPrice());
        tShirtViewModel.setQuantity(tShirt.getQuantity());

        return tShirtViewModel;
    }

    public InvoiceViewModel buildInvoiceViewModel(Invoice invoice) {
        InvoiceViewModel invoiceViewModel = new InvoiceViewModel();
        invoiceViewModel.setInvoiceId(invoice.getInvoiceId());
        invoiceViewModel.setName(invoice.getName());
        invoiceViewModel.setStreet(invoice.getStreet());
        invoiceViewModel.setCity(invoice.getCity());
        invoiceViewModel.setState(invoice.getState());
        invoiceViewModel.setZipcode(invoice.getZipcode());
        invoiceViewModel.setItemType(invoice.getItemType());
        invoiceViewModel.setItemId(invoice.getItemId());
        invoiceViewModel.setUnitPrice(invoice.getUnitPrice());
        invoiceViewModel.setQuantity(invoice.getQuantity());
        invoiceViewModel.setSubtotal(invoice.getSubtotal());
        invoiceViewModel.setProcessingFee(invoice.getProcessingFee());
        invoiceViewModel.setTax(invoice.getTax());
        invoiceViewModel.setProcessingFee(invoice.getProcessingFee());
        invoiceViewModel.setTotal(invoice.getTotal());

        return invoiceViewModel;
    }

}
