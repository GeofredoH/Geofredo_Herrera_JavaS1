package com.company.GeofredoHerreraU1Capstone.dao.dao;

import com.company.GeofredoHerreraU1Capstone.dao.dto.Console;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ConsoleDaoJdbcTemplateImpl implements ConsoleDao {
    private JdbcTemplate jdbcTemplate;

    private final String INSERT_CONSOLE_SQL = "INSERT INTO console " +
            "(model, manufacturer, memory_amount, processor, price, quantity) " +
            "VALUES(?, ?, ?, ?, ?, ?)";
    private final String SELECT_CONSOLE_BY_ID_SQL = "SELECT * FROM console WHERE console_id = ?";
    private final String SELECT_ALL_CONSOLES_SQL = "SELECT * FROM console";
    private final String UPDATE_CONSOLE_SQL = "UPDATE console " +
            "SET model = ?, manufacturer = ?, memory_amount = ?, processor = ?, price = ?, quantity = ? WHERE console_id = ?";
    private final String DELETE_CONSOLE_SQL = "DELETE FROM console WHERE console_id = ?";
    private final String SELECT_CONSOLE_BY_MANUFACTURER_SQL = "SELECT * FROM console WHERE manufacturer LIKE ?";     //Might need to be changed to use LIKE instead of CONTAINS

    @Autowired
    public ConsoleDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Console addConsole(Console console) {
        jdbcTemplate.update(INSERT_CONSOLE_SQL,
                console.getModel(),
                console.getManufacturer(),
                console.getMemoryAmount(),
                console.getProcessor(),
                console.getPrice(),
                console.getQuantity());

        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);
        console.setConsoleId(id);
        return console;

    }

    @Override
    public Console getConsoleById(int id) {

        try {

            return jdbcTemplate.queryForObject(SELECT_CONSOLE_BY_ID_SQL, this::mapRowToConsole, id);

        } catch (EmptyResultDataAccessException e) {

            return null;
        }
    }

    @Override
    public List<Console> getAllConsoles() {
        try {
            List<Console> consoleList = jdbcTemplate.query(SELECT_ALL_CONSOLES_SQL, this::mapRowToConsole);

            return consoleList;

        } catch (Exception e) {
            List<Console> consoleListException = null;    //might need to change other lists to this
            return consoleListException;

        }
    }

    @Override
    public void updateConsole(Console console) {

        jdbcTemplate.update(UPDATE_CONSOLE_SQL,
                console.getModel(),
                console.getManufacturer(),
                console.getMemoryAmount(),
                console.getProcessor(),
                console.getPrice(),
                console.getQuantity(),
                console.getConsoleId());

    }


    @Override
    public void deleteConsoleById(int id) {
        jdbcTemplate.update(DELETE_CONSOLE_SQL, id);

    }

    @Override
    public List<Console> getConsoleByManufacturer(String manufacturer) {
        try {

            manufacturer = "%" + manufacturer + "%";

            List<Console> consoleList = jdbcTemplate.query(SELECT_CONSOLE_BY_MANUFACTURER_SQL, this::mapRowToConsole, manufacturer);
            return consoleList;

        } catch (Exception e) {

            return null;

        }
    }

    private Console mapRowToConsole(ResultSet rs, int rowNumber) throws SQLException {
        Console console = new Console();
        console.setConsoleId(rs.getInt("console_id"));
        console.setModel(rs.getString("model"));
        console.setManufacturer(rs.getString("manufacturer"));
        console.setMemoryAmount(rs.getString("memory_amount"));
        console.setProcessor(rs.getString("processor"));
        console.setPrice(rs.getBigDecimal("price"));
        console.setQuantity(rs.getInt("quantity"));

        return console;
    }
}
