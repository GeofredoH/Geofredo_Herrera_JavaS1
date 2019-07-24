package com.company.GeofredoHerreraU1Capstone.dao.dao;

import com.company.GeofredoHerreraU1Capstone.dao.dto.Game;
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
public class GameDaoJdbcTemplateImplTest {

    @Autowired
    GameDao gameDao;

    @Before
    public void setUp() throws Exception {
        List<Game> gameList = gameDao.getAllGames();
        gameList.stream()
                .forEach(g -> gameDao.deleteGame(g.getGameId()));

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addGetGame() {
        Game game = new Game();
        game.setTitle("Halo");
        game.setEsrbRating("E10+");
        game.setDescription("Puzzles and Math");
        game.setPrice(new BigDecimal("23.99"));
        game.setStudio("Xbox Game Studios");
        game.setQuantity(5);
        game = gameDao.addGame(game);

        Game gameFromDb = gameDao.getGame(game.getGameId());

        assertEquals(game, gameFromDb);
    }

    @Test
    public void getAllGames() {

        List<Game> gameList = new ArrayList<>();

        Game game1 = new Game();
        game1.setTitle("Halo");
        game1.setEsrbRating("E10+");
        game1.setDescription("Puzzles and Math");
        game1.setPrice(new BigDecimal("23.99"));
        game1.setStudio("Xbox Game Studios");
        game1.setQuantity(5);
        game1 = gameDao.addGame(game1);
        gameList.add(game1);

        Game game2 = new Game();
        game2.setTitle("Tetris");
        game2.setEsrbRating("E");
        game2.setDescription("block puzzle game");
        game2.setPrice(new BigDecimal("10.99"));
        game2.setStudio("Dolby Studios");
        game2.setQuantity(9);
        game2 = gameDao.addGame(game2);
        gameList.add(game2);

        List<Game> gameList2 = gameDao.getAllGames();

        assertEquals(gameList, gameList2);
    }

    @Test
    public void updateGame() {

        Game game1 = new Game();
        game1.setTitle("Halo");
        game1.setEsrbRating("E10+");
        game1.setDescription("Puzzles and Math");
        game1.setPrice(new BigDecimal("23.99"));
        game1.setStudio("Xbox Game Studios");
        game1.setQuantity(5);
        game1 = gameDao.addGame(game1);

        game1.setDescription("Third Person Shooter Game");
        game1.setQuantity(3);
        game1.setPrice(new BigDecimal("20.99"));

        gameDao.updateGame(game1);

        Game game2 = gameDao.getGame(game1.getGameId());

        assertEquals(game1, game2);

    }

    @Test
    public void deleteGame() {

        Game game1 = new Game();
        game1.setTitle("Halo");
        game1.setEsrbRating("E10+");
        game1.setDescription("Puzzles and Math");
        game1.setPrice(new BigDecimal("23.99"));
        game1.setStudio("Xbox Game Studios");
        game1.setQuantity(5);
        game1 = gameDao.addGame(game1);

        gameDao.deleteGame(game1.getGameId());

        Game game2 = gameDao.getGame(game1.getGameId());

        assertNull(game2);

    }

    @Test
    public void getGameByStudio() {

        List<Game> gameList = new ArrayList<>();

        Game game1 = new Game();
        game1.setTitle("Halo");
        game1.setEsrbRating("E10+");
        game1.setDescription("Puzzles and Math");
        game1.setPrice(new BigDecimal("23.99"));
        game1.setStudio("Xbox Game Studios");
        game1.setQuantity(5);
        game1 = gameDao.addGame(game1);

        Game game2 = new Game();
        game2.setTitle("Tetris");
        game2.setEsrbRating("E");
        game2.setDescription("block puzzle game");
        game2.setPrice(new BigDecimal("10.99"));
        game2.setStudio("Dolby Studios");
        game2.setQuantity(9);
        game2 = gameDao.addGame(game2);
        gameList.add(game2);

        Game game3 = new Game();
        game3.setTitle("Plankton");
        game3.setEsrbRating("M");
        game3.setDescription("Zombie shooter game");
        game3.setPrice(new BigDecimal("17.99"));
        game3.setStudio("Dolby Studios");
        game3.setQuantity(3);
        game3 = gameDao.addGame(game3);
        gameList.add(game3);

        List<Game> gameList3 = gameDao.getGameByStudio("dolby studio");

        assertEquals(gameList, gameList3);
    }

    @Test
    public void getGameByEsrbRating() {
        List<Game> gameList = new ArrayList<>();

        Game game1 = new Game();
        game1.setTitle("Halo");
        game1.setEsrbRating("E");
        game1.setDescription("Puzzles and Math");
        game1.setPrice(new BigDecimal("23.99"));
        game1.setStudio("Xbox Game Studios");
        game1.setQuantity(5);
        game1 = gameDao.addGame(game1);
        gameList.add(game1);

        Game game2 = new Game();
        game2.setTitle("Tetris");
        game2.setEsrbRating("E");
        game2.setDescription("block puzzle game");
        game2.setPrice(new BigDecimal("10.99"));
        game2.setStudio("Dolby Studios");
        game2.setQuantity(9);
        game2 = gameDao.addGame(game2);
        gameList.add(game2);

        Game game3 = new Game();
        game3.setTitle("Plankton");
        game3.setEsrbRating("M");
        game3.setDescription("Zombie shooter game");
        game3.setPrice(new BigDecimal("17.99"));
        game3.setStudio("Kinetic Studios");
        game3.setQuantity(3);
        game3 = gameDao.addGame(game3);


        List<Game> gameList2 = gameDao.getGameByEsrbRating(game1.getEsrbRating());
        List<Game> gameList3 = gameDao.getGameByEsrbRating("e");

        assertEquals(gameList, gameList2);
        assertEquals(gameList, gameList3);
    }

    @Test
    public void getGameByTitle() {

        List<Game> gameList = new ArrayList<>();

        Game game1 = new Game();
        game1.setTitle("The Halo Masters");
        game1.setEsrbRating("M");
        game1.setDescription("Puzzles and Math");
        game1.setPrice(new BigDecimal("23.99"));
        game1.setStudio("Xbox Game Studios");
        game1.setQuantity(5);
        game1 = gameDao.addGame(game1);
        gameList.add(game1);

        Game game2 = new Game();
        game2.setTitle("Halo Origins");
        game2.setEsrbRating("T");
        game2.setDescription("block puzzle game");
        game2.setPrice(new BigDecimal("10.99"));
        game2.setStudio("Dolby Studios");
        game2.setQuantity(9);
        game2 = gameDao.addGame(game2);
        gameList.add(game2);

        Game game3 = new Game();
        game3.setTitle("Plankton");
        game3.setEsrbRating("M");
        game3.setDescription("Zombie shooter game");
        game3.setPrice(new BigDecimal("17.99"));
        game3.setStudio("Kinetic Studios");
        game3.setQuantity(3);
        game3 = gameDao.addGame(game3);


        List<Game> gameList3 = gameDao.getGameByTitle("Halo");

        assertEquals(gameList, gameList3);
    }
}