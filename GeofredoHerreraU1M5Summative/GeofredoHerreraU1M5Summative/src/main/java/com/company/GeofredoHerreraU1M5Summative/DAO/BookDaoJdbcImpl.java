package com.company.GeofredoHerreraU1M5Summative.DAO;

import com.company.GeofredoHerreraU1M5Summative.DTO.Book;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BookDaoJdbcImpl implements BookDao{

    //prepared statements for safe DB interaction
    private final String CREATE_BOOK_SQL = "insert into book " +
            "(isbn, publish_date, author_id, title, publisher_id, price) " +
            "values(?,?,?,?,?,?)";
    private final String SELECT_BOOK_BY_ID_SQL = "select * from book where book_id = ?";
    private final String SELECT_ALL_BOOKS_SQL = "select * from book";
    private final String UPDATE_BOOK_SQL = "update book " +
            "set isbn = ?, publish_date = ?, author_id = ?, title = ?, publisher_id = ?, price = ? where book_id = ?";
    private final String DELETE_BOOK_BY_ID_SQL = "delete from book where book_id = ?";
    private final String SELECT_BOOK_BY_AUTHOR_ID_SQL = "select * from book where author_id = ?";

    JdbcTemplate jdbcTemplate;

    public BookDaoJdbcImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Book addBook(Book book) {
        jdbcTemplate.update(CREATE_BOOK_SQL,
                book.getIsbn(),
                book.getPublishDate(),
                book.getAuthor_id(),
                book.getTitle(),
                book.getPublisherId(),
                book.getPrice());

        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);     //using non-prepared helper sql statement
        book.setBookId(id);
        return book;
    }

    @Override
    public Book getBook(int id) {
        try {

            return jdbcTemplate.queryForObject(SELECT_BOOK_BY_ID_SQL, this::mapRowToBook, id);

        }catch (EmptyResultDataAccessException e){

            return null;
        }
    }

    @Override
    public List<Book> getAllBooks() {
        List<Book> bookList = jdbcTemplate.query(SELECT_ALL_BOOKS_SQL, this::mapRowToBook);
        return bookList;
    }

    @Override
    public void updateBook(Book book) {
        jdbcTemplate.update(UPDATE_BOOK_SQL,
                book.getIsbn(),
                book.getPublishDate(),
                book.getAuthor_id(),
                book.getTitle(),
                book.getPublisherId(),
                book.getPrice(),
                book.getBookId());
    }

    @Override
    public void deleteBook(int id) {
        jdbcTemplate.update(DELETE_BOOK_BY_ID_SQL, id);
    }

    @Override
    public List<Book> getBooksByAuthor(int id) {

        List<Book> bookList = jdbcTemplate.query(SELECT_BOOK_BY_AUTHOR_ID_SQL, this::mapRowToBook, id);

        return bookList;

    }

    public Book mapRowToBook(ResultSet rs, int rowNumber) throws SQLException {
        Book book = new Book();
        book.setBookId(rs.getInt("book_id"));
        book.setIsbn(rs.getString("isbn"));
        book.setPublishDate(rs.getDate("publish_date").toLocalDate());
        book.setAuthor_id(rs.getInt("author_id"));
        book.setTitle(rs.getString("title"));
        book.setPublisherId(rs.getInt("publisher_id"));
        book.setPrice(rs.getDouble("price"));

        return book;
    }
}
