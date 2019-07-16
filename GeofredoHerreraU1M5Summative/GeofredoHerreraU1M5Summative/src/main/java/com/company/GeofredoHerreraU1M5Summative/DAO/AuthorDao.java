package com.company.GeofredoHerreraU1M5Summative.DAO;

import com.company.GeofredoHerreraU1M5Summative.DTO.Author;

import java.util.List;

public interface AuthorDao {
    Author addAuthor(Author author);

    Author getAuthor(int id);

    List<Author> getAllAuthors();

    void updateAuthor(Author author);

    void deleteAuthor(int id);

}
