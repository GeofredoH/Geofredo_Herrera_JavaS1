package com.company.GeofredoHerreraU1M5Summative.DAO;

import com.company.GeofredoHerreraU1M5Summative.DTO.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PublisherDaoJdbcImpl implements PublisherDao{
    private JdbcTemplate jdbcTemplate;

    //prepared statements for safe DB interaction
    private final String SELECT_PUB_SQL = "select * from publisher where publisher_id = ?";
    private final String CREATE_PUB_SQL = "insert into publisher(name, street, city, state, postal_code, phone, email)" +
                                          "values(?,?,?,?,?,?,?)";
    private final String SELECT_ALL_PUBS_SQL = "select * from publisher";
    private final String UPDATE_PUB_SQL = "update publisher " +
            "set name = ?, street = ?, city = ?, state = ?, postal_code = ?,phone = ?, email = ? where publisher_id = ?";
    private final String DELETE_PUB_SQL = "delete from publisher where publisher_id = ?";
    private final String DELETE_ALL_PUBS_SQL = "delete from publisher";




    @Autowired
    public PublisherDaoJdbcImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public Publisher addPublisher(Publisher publisher) {
        jdbcTemplate.update(CREATE_PUB_SQL, publisher.getName(),
                                            publisher.getStreet(),
                                            publisher.getCity(),
                                            publisher.getState(),
                                            publisher.getPostalCode(),
                                            publisher.getPhone(),
                                            publisher.getEmail());
        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);     //using non-prepared helper sql statement

        publisher.setPublisherId(id);
        return publisher;
    }

    @Override
    public Publisher getPublisher(int id) {
        try {

            return jdbcTemplate.queryForObject(SELECT_PUB_SQL, this::mapRowToPublisher, id);

        } catch (EmptyResultDataAccessException e) {
            // if nothing is returned just catch the exception and return null
            return null;
        }
    }

    @Override
    public List<Publisher> getAllPublishers() {
        return jdbcTemplate.query(SELECT_ALL_PUBS_SQL, this::mapRowToPublisher);
    }

    @Override
    @Transactional
    public void updatePublisher(Publisher publisher) {
        jdbcTemplate.update(UPDATE_PUB_SQL, publisher.getName(),
                publisher.getStreet(),
                publisher.getCity(),
                publisher.getState(),
                publisher.getPostalCode(),
                publisher.getPhone(),
                publisher.getEmail(),
                publisher.getPublisherId());

    }

    @Override
    @Transactional
    public void deletePublisher(int id) {
        jdbcTemplate.update(DELETE_PUB_SQL, id);

    }

    @Override
    @Transactional
    public void deleteAllPublisher() {
        jdbcTemplate.update(DELETE_ALL_PUBS_SQL);

    }

    private Publisher mapRowToPublisher(ResultSet rs, int rowNum) throws SQLException {
        Publisher pub = new Publisher();
        pub.setPublisherId(rs.getInt("publisher_id"));
        pub.setName(rs.getString("name"));
        pub.setStreet(rs.getString("street"));
        pub.setCity(rs.getString("city"));
        pub.setState(rs.getString("state"));
        pub.setPostalCode(rs.getString("postal_code"));
        pub.setPhone(rs.getString("phone"));
        pub.setEmail(rs.getString("email"));

        return pub;
    }

}
