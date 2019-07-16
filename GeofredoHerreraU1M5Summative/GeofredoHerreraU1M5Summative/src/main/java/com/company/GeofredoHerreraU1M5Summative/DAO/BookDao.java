package com.company.GeofredoHerreraU1M5Summative.DAO;

import com.company.GeofredoHerreraU1M5Summative.DTO.Book;

import java.util.List;

public interface BookDao {
    Book addBook(Book book);

    Book getBook(int id);

    List<Book> getAllBooks();

    void updateBook(Book book);

    void deleteBook(int id);

    List<Book> getBooksByAuthor(int id);
}
