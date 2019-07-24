package com.company.GeofredoHerreraU1Capstone.dao.dao;

import com.company.GeofredoHerreraU1Capstone.dao.dto.TShirt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TShirtDaoJdbcTemplateImpl implements TShirtDao {

    private final String INSERT_TSHIRT_SQL = "INSERT INTO t_shirt " +
            "(size, color, description, price, quantity) " +
            "VALUES(?, ?, ?, ?, ?)";
    private final String SELECT_TSHIRT_BY_ID_SQL = "SELECT * FROM t_shirt WHERE t_shirt_id = ?";
    private final String SELECT_ALL_TSHIRTS_SQL = "SELECT * FROM t_shirt";
    private final String UPDATE_TSHIRT_SQL = "UPDATE t_shirt " +
            "SET size = ?, color = ?, description = ?, price = ?, quantity = ? WHERE t_shirt_id = ?";
    private final String DELETE_TSHIRT_BY_ID_SQL = "DELETE FROM t_shirt WHERE t_shirt_id = ?";
    private final String SELECT_TSHIRT_BY_COLOR_SQL = "SELECT * FROM t_shirt WHERE color LIKE ?";
    private final String SELECT_TSHIRT_BY_SIZE_SQL = "SELECT * FROM t_shirt WHERE size LIKE ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public TShirtDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public TShirt addTShirt(TShirt tShirt) {
        jdbcTemplate.update(INSERT_TSHIRT_SQL,
                tShirt.getSize(),
                tShirt.getColor(),
                tShirt.getDescription(),
                tShirt.getPrice(),
                tShirt.getQuantity());

        int id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        tShirt.settShirtId(id);
        return tShirt;
    }

    @Override
    public TShirt getTShirtById(int id) {
        try {

            return jdbcTemplate.queryForObject(SELECT_TSHIRT_BY_ID_SQL, this::mapRowToTShirt, id);

        } catch (EmptyResultDataAccessException e) {

            return null;

        }
    }

    @Override
    public List<TShirt> getAllTShirts() {
        try {
            List<TShirt> tShirtList = jdbcTemplate.query(SELECT_ALL_TSHIRTS_SQL, this::mapRowToTShirt);

            return tShirtList;

        } catch (Exception e) {
            List<TShirt> tShirtListException = null;    //might need to change other lists to this
            return tShirtListException;

        }
    }

    @Override
    public void updateTShirt(TShirt tShirt) {

        jdbcTemplate.update(UPDATE_TSHIRT_SQL,
                tShirt.getSize(),
                tShirt.getColor(),
                tShirt.getDescription(),
                tShirt.getPrice(),
                tShirt.getQuantity(),
                tShirt.gettShirtId());
    }

    @Override
    public void deleteTShirt(int id) {

        jdbcTemplate.update(DELETE_TSHIRT_BY_ID_SQL, id);

    }

    @Override
    public List<TShirt> getTShirtByColor(String color) {
        try {

            color = "%" + color + "%";

            List<TShirt> tShirtList = jdbcTemplate.query(SELECT_TSHIRT_BY_COLOR_SQL, this::mapRowToTShirt, color);
            return tShirtList;

        } catch (Exception e) {

            return null;

        }
    }

    @Override
    public List<TShirt> getTShirtBySize(String size) {
        try {

            size = "%" + size + "%";

            List<TShirt> tShirtList = jdbcTemplate.query(SELECT_TSHIRT_BY_SIZE_SQL, this::mapRowToTShirt, size);
            return tShirtList;

        } catch (Exception e) {

            return null;

        }
    }

    private TShirt mapRowToTShirt(ResultSet rs, int rowNumber) throws SQLException {
        TShirt tShirt = new TShirt();
        tShirt.settShirtId(rs.getInt("t_shirt_id"));
        tShirt.setSize(rs.getString("size"));
        tShirt.setColor(rs.getString("color"));
        tShirt.setDescription(rs.getString("description"));
        tShirt.setPrice(rs.getBigDecimal("price"));
        tShirt.setQuantity(rs.getInt("quantity"));

        return tShirt;
    }
}
