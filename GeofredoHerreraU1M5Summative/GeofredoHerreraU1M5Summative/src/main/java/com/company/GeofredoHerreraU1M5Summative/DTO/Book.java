package com.company.GeofredoHerreraU1M5Summative.DTO;

import java.time.LocalDate;
import java.util.Objects;

public class Book {
    private int bookId;
    private String isbn;
    private LocalDate publishDate;
    private int author_id;
    private String title;
    private int publisherId;
    private double price;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return getBookId() == book.getBookId() &&
                getAuthor_id() == book.getAuthor_id() &&
                getPublisherId() == book.getPublisherId() &&
                Double.compare(book.getPrice(), getPrice()) == 0 &&
                getIsbn().equals(book.getIsbn()) &&
                getPublishDate().equals(book.getPublishDate()) &&
                getTitle().equals(book.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBookId(), getIsbn(), getPublishDate(), getAuthor_id(), getTitle(), getPublisherId(), getPrice());
    }
}
