package com.company.GeofredoHerreraU1Capstone.dao.dao;

import com.company.GeofredoHerreraU1Capstone.dao.dto.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class GameDaoJdbcTemplateImpl implements GameDao {

    private final String INSERT_GAME_SQL = "INSERT INTO GAME " +
            "(title, esrb_rating, description, price, studio, quantity) " +
            "VALUES(?, ?, ?, ?, ?, ?)";
    private final String SELECT_GAME_BY_ID_SQL = "SELECT * FROM GAME WHERE game_id = ?";
    private final String SELECT_ALL_GAMES_SQL = "SELECT * FROM GAME";
    private final String UPDATE_GAME_SQL = "UPDATE GAME " +
            "SET title = ?, esrb_rating = ?, description = ?, price = ?, studio = ?, quantity = ? WHERE game_id = ?";
    private final String DELETE_GAME_SQL = "DELETE FROM GAME WHERE game_id = ?";
    private final String SELECT_GAME_BY_STUDIO_SQL = "SELECT * FROM GAME WHERE studio LIKE ?";     //Might need to be changed to use LIKE instead of CONTAINS
    private final String SELECT_GAME_BY_ESRB_RATING_SQL = "SELECT * FROM GAME WHERE esrb_rating LIKE ?";     //other method of searching strings
    private final String SELECT_GAME_BY_TITLE_SQL = "SELECT * FROM GAME WHERE title LIKE ?";                 //SELECT DISTINCT COL_NAME FROM myTable WHERE UPPER(COL_NAME) LIKE UPPER('%PriceOrder%')

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public GameDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public Game addGame(Game game) {
        jdbcTemplate.update(INSERT_GAME_SQL,
                game.getTitle(),
                game.getEsrbRating(),
                game.getDescription(),
                game.getPrice(),
                game.getStudio(),
                game.getQuantity());

        int id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        game.setGameId(id);
        return game;
    }

    @Override
    public Game getGame(int id) {
        try {

            return jdbcTemplate.queryForObject(SELECT_GAME_BY_ID_SQL, this::mapRowToGame, id);

        } catch (EmptyResultDataAccessException e) {

            return null;

        }
    }

    @Override
    public List<Game> getAllGames() {
        try {
            List<Game> gameList = jdbcTemplate.query(SELECT_ALL_GAMES_SQL, this::mapRowToGame);

            return gameList;

        } catch (Exception e) {
            List<Game> gameListException = null;
            return gameListException;

        }
    }

    @Override
    @Transactional
    public void updateGame(Game game) {
        jdbcTemplate.update(UPDATE_GAME_SQL,
                game.getTitle(),
                game.getEsrbRating(),
                game.getDescription(),
                game.getPrice(),
                game.getStudio(),
                game.getQuantity(),
                game.getGameId());

    }

    @Override
    @Transactional
    public void deleteGame(int id) {

        jdbcTemplate.update(DELETE_GAME_SQL, id);

    }

    @Override
    public List<Game> getGameByStudio(String studio) {
        try {

            studio = "%" + studio + "%";

            List<Game> gameList = jdbcTemplate.query(SELECT_GAME_BY_STUDIO_SQL, this::mapRowToGame, studio);
            return gameList;

        } catch (Exception e) {

            return null;

        }
    }

    @Override
    public List<Game> getGameByEsrbRating(String esrb) {
        try {

            esrb = "%" + esrb + "%";

            List<Game> gameList = jdbcTemplate.query(SELECT_GAME_BY_ESRB_RATING_SQL, this::mapRowToGame, esrb);
            return gameList;

        } catch (Exception e) {

            return null;

        }
    }

    @Override
    public List<Game> getGameByTitle(String title) {
        try {

            title = "%" + title + "%";

            List<Game> gameList = jdbcTemplate.query(SELECT_GAME_BY_TITLE_SQL, this::mapRowToGame, title);
            return gameList;

        } catch (EmptyResultDataAccessException e) {
            List<Game> gameList = null;
            return gameList;

        }
    }

    //Helper Method
    private Game mapRowToGame(ResultSet rs, int rowNumber) throws SQLException {
        Game game = new Game();
        game.setGameId(rs.getInt("game_id"));
        game.setTitle(rs.getString("title"));
        game.setEsrbRating(rs.getString("esrb_rating"));
        game.setDescription(rs.getString("description"));
        game.setPrice(rs.getBigDecimal("price"));
        game.setStudio(rs.getString("studio"));
        game.setQuantity(rs.getInt("quantity"));

        return game;
    }
}
