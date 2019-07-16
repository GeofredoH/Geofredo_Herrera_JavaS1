package com.company.GeofredoHerreraU1M5Summative.DAO;

import com.company.GeofredoHerreraU1M5Summative.DTO.Author;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AuthorDaoJdbcImpl implements AuthorDao{

    //prepared statements for safe DB interaction
    private final String CREATE_AUTHOR_SQL = "insert into author(first_name, last_name, street, city, state, postal_code, phone, email)" +
            "values(?,?,?,?,?,?,?,?)";
    private final String SELECT_AUTHOR_BY_ID_SQL = "select * from author where author_id = ?";
    private final String SELECT_ALL_AUTHORS_SQL = "select * from author";
    private final String UPDATE_AUTHOR_SQL = "update author" +
            " set first_name = ?, last_name = ?, street = ?, city = ?, state = ?, postal_code = ?, phone = ?, email = ? where author_id = ?";
    private final String DELETE_AUTHOR_BY_ID = "delete from author where author_id = ?";

    JdbcTemplate jdbcTemplate;

    public AuthorDaoJdbcImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Author addAuthor(Author author) {

        jdbcTemplate.update(CREATE_AUTHOR_SQL,
                author.getFirst_name(),
                author.getLast_name(),
                author.getStreet(),
                author.getCity(),
                author.getState(),
                author.getPostalCode(),
                author.getPhone(),
                author.getEmail());

        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);     //using non-prepared helper sql statement

        author.setAuthorId(id);
        return author;
    }

    @Override
    public Author getAuthor(int id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_AUTHOR_BY_ID_SQL, this::mapRowToAuthor, id);
        }catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Author> getAllAuthors() {
        List<Author> authorList = jdbcTemplate.query(SELECT_ALL_AUTHORS_SQL, this::mapRowToAuthor);
        return authorList;
    }

    @Override
    public void updateAuthor(Author author) {
        jdbcTemplate.update(UPDATE_AUTHOR_SQL,
                author.getFirst_name(),
                author.getLast_name(),
                author.getStreet(),
                author.getCity(),
                author.getState(),
                author.getPostalCode(),
                author.getPhone(),
                author.getEmail(),
                author.getAuthorId());
    }

    @Override
    public void deleteAuthor(int id) {
        jdbcTemplate.update(DELETE_AUTHOR_BY_ID, id);

    }

    public Author mapRowToAuthor(ResultSet rs, int rowNumber)throws SQLException {
        Author author = new Author();
        author.setAuthorId(rs.getInt("author_id"));
        author.setFirst_name(rs.getString("first_name"));
        author.setLast_name(rs.getString("last_name"));
        author.setStreet(rs.getString("street"));
        author.setCity(rs.getString("city"));
        author.setState(rs.getString("state"));
        author.setPostalCode(rs.getString("postal_code"));
        author.setPhone(rs.getString("phone"));
        author.setEmail(rs.getString("email"));

        return author;
    }

}
