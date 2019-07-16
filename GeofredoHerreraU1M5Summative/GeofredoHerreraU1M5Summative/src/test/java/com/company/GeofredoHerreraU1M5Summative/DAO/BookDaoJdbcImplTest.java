package com.company.GeofredoHerreraU1M5Summative.DAO;

import com.company.GeofredoHerreraU1M5Summative.DTO.Author;
import com.company.GeofredoHerreraU1M5Summative.DTO.Book;
import com.company.GeofredoHerreraU1M5Summative.DTO.Publisher;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class BookDaoJdbcImplTest {

    @Autowired
    BookDao bookDao;
    @Autowired
    AuthorDao authorDao;
    @Autowired
    PublisherDao publisherDao;

    @Before
    public void setUp() throws Exception {

        List<Book> bookList = bookDao.getAllBooks();
        bookList.stream()
                .forEach(b -> bookDao.deleteBook(b.getBookId()));

        List<Publisher> publisherList = publisherDao.getAllPublishers();
        publisherList.stream()
                .forEach(p -> publisherDao.deletePublisher(p.getPublisherId()));

        List<Author> authorList = authorDao.getAllAuthors();
        authorList.stream()
                .forEach(a -> authorDao.deleteAuthor(a.getAuthorId()));

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addGetDeleteBook(){     //combined add get and delete methods into one test for efficiency
        Publisher publisher = new Publisher();
        publisher.setName("BigPrint");
        publisher.setStreet("333 West Willow St.");
        publisher.setCity("Atlanta");
        publisher.setState("GA");
        publisher.setPostalCode("4535-49385");
        publisher.setPhone("234-848-8484");
        publisher.setEmail("manager@bigprint.com");
        publisher = publisherDao.addPublisher(publisher);

        Author author = new Author();
        author.setFirst_name("George");
        author.setLast_name("Franklin");
        author.setStreet("123 Walnut Grove");
        author.setCity("Saint Ana");
        author.setState("IA");
        author.setPostalCode("2354-94274");
        author.setPhone("938-485-2947");
        author.setEmail("gfranklin@gmail.com");
        author = authorDao.addAuthor(author);

        Book book = new Book();
        book.setIsbn("1234567890987");
        book.setPublishDate(LocalDate.of(2018, 5, 3));
        book.setAuthor_id(author.getAuthorId());
        book.setTitle("The Gauntlet");
        book.setPublisherId(publisher.getPublisherId());
        book.setPrice(23.99);
        book = bookDao.addBook(book);

        Book bookFromDb = bookDao.getBook(book.getBookId());

        assertEquals(book, bookFromDb);

        bookDao.deleteBook(book.getBookId());

        bookFromDb = bookDao.getBook(book.getBookId());

        assertNull(bookFromDb);

    }

    @Test
    public void getAllBooks() {
        List<Book> bookList = new ArrayList<>();    //holds newly created book objects

        Publisher publisher1 = new Publisher();
        publisher1.setName("BigPrint");
        publisher1.setStreet("333 West Willow St.");
        publisher1.setCity("Atlanta");
        publisher1.setState("GA");
        publisher1.setPostalCode("4535-49385");
        publisher1.setPhone("234-848-8484");
        publisher1.setEmail("manager@bigprint.com");
        publisher1 = publisherDao.addPublisher(publisher1);

        Author author1 = new Author();
        author1.setFirst_name("George");
        author1.setLast_name("Franklin");
        author1.setStreet("123 Walnut Grove");
        author1.setCity("Saint Ana");
        author1.setState("IA");
        author1.setPostalCode("2354-94274");
        author1.setPhone("938-485-2947");
        author1.setEmail("gfranklin@gmail.com");
        author1 = authorDao.addAuthor(author1);

        Book book1 = new Book();
        book1.setIsbn("1234567890987");
        book1.setPublishDate(LocalDate.of(2018, 5, 3));
        book1.setAuthor_id(author1.getAuthorId());
        book1.setTitle("The Gauntlet");
        book1.setPublisherId(publisher1.getPublisherId());
        book1.setPrice(23.99);
        book1 = bookDao.addBook(book1);
        bookList.add(book1);

        Publisher publisher2 = new Publisher();
        publisher2.setName("JPrint");
        publisher2.setStreet("222 South Will Rd.");
        publisher2.setCity("Houston");
        publisher2.setState("TX");
        publisher2.setPostalCode("4444-11111");
        publisher2.setPhone("111-111-2222");
        publisher2.setEmail("manager@jprint.com");
        publisher2 = publisherDao.addPublisher(publisher2);

        Author author2 = new Author();
        author2.setFirst_name("James");
        author2.setLast_name("Kirk");
        author2.setStreet("678 Street Lane");
        author2.setCity("Santa Maria");
        author2.setState("CA");
        author2.setPostalCode("7777-12345");
        author2.setPhone("333-333-3333");
        author2.setEmail("jkirk@gmail.com");
        author2 = authorDao.addAuthor(author2);

        Book book2 = new Book();
        book2.setIsbn("0987654321234");
        book2.setPublishDate(LocalDate.of(2015, 1, 1));
        book2.setAuthor_id(author2.getAuthorId());
        book2.setTitle("House Manners");
        book2.setPublisherId(publisher2.getPublisherId());
        book2.setPrice(15.99);
        book2 = bookDao.addBook(book2);
        bookList.add(book2);

        List<Book> booksFromDb = bookDao.getAllBooks();

        assertEquals(bookList, booksFromDb);
    }

    @Test
    public void updateBook() {
        Publisher publisher = new Publisher();
        publisher.setName("JPrint");
        publisher.setStreet("222 South Will Rd.");
        publisher.setCity("Houston");
        publisher.setState("TX");
        publisher.setPostalCode("4444-11111");
        publisher.setPhone("111-111-2222");
        publisher.setEmail("manager@jprint.com");
        publisher = publisherDao.addPublisher(publisher);

        Author author = new Author();
        author.setFirst_name("James");
        author.setLast_name("Kirk");
        author.setStreet("678 Street Lane");
        author.setCity("Santa Maria");
        author.setState("CA");
        author.setPostalCode("7777-12345");
        author.setPhone("333-333-3333");
        author.setEmail("jkirk@gmail.com");
        author = authorDao.addAuthor(author);

        Book book = new Book();
        book.setIsbn("0987654321234");
        book.setPublishDate(LocalDate.of(2015, 1, 1));
        book.setAuthor_id(author.getAuthorId());
        book.setTitle("House Manners");
        book.setPublisherId(publisher.getPublisherId());
        book.setPrice(15.99);
        book = bookDao.addBook(book);

        book.setPrice(20.99);

        bookDao.updateBook(book);

        Book bookFromDb = bookDao.getBook(book.getBookId());

        assertEquals(book, bookFromDb);
    }

    @Test
    public void getBooksByAuthor() {
        List<Book> bookList = new ArrayList<>();    //holds newly created book objects

        Publisher publisher1 = new Publisher();
        publisher1.setName("BigPrint");
        publisher1.setStreet("333 West Willow St.");
        publisher1.setCity("Atlanta");
        publisher1.setState("GA");
        publisher1.setPostalCode("4535-49385");
        publisher1.setPhone("234-848-8484");
        publisher1.setEmail("manager@bigprint.com");
        publisher1 = publisherDao.addPublisher(publisher1);

        Author author1 = new Author();
        author1.setFirst_name("George");
        author1.setLast_name("Franklin");
        author1.setStreet("123 Walnut Grove");
        author1.setCity("Saint Ana");
        author1.setState("IA");
        author1.setPostalCode("2354-94274");
        author1.setPhone("938-485-2947");
        author1.setEmail("gfranklin@gmail.com");
        author1 = authorDao.addAuthor(author1);

        Book book1 = new Book();
        book1.setIsbn("1234567890987");
        book1.setPublishDate(LocalDate.of(2018, 5, 3));
        book1.setAuthor_id(author1.getAuthorId());
        book1.setTitle("The Gauntlet");
        book1.setPublisherId(publisher1.getPublisherId());
        book1.setPrice(23.99);
        book1 = bookDao.addBook(book1);

        Publisher publisher2 = new Publisher();
        publisher2.setName("JPrint");
        publisher2.setStreet("222 South Will Rd.");
        publisher2.setCity("Houston");
        publisher2.setState("TX");
        publisher2.setPostalCode("4444-11111");
        publisher2.setPhone("111-111-2222");
        publisher2.setEmail("manager@jprint.com");
        publisher2 = publisherDao.addPublisher(publisher2);

        Author author2 = new Author();
        author2.setFirst_name("James");
        author2.setLast_name("Kirk");
        author2.setStreet("678 Street Lane");
        author2.setCity("Santa Maria");
        author2.setState("CA");
        author2.setPostalCode("7777-12345");
        author2.setPhone("333-333-3333");
        author2.setEmail("jkirk@gmail.com");
        author2 = authorDao.addAuthor(author2);

        Book book2 = new Book();
        book2.setIsbn("0987654321234");
        book2.setPublishDate(LocalDate.of(2015, 1, 1));
        book2.setAuthor_id(author2.getAuthorId());
        book2.setTitle("House Manners");
        book2.setPublisherId(publisher2.getPublisherId());
        book2.setPrice(15.99);
        book2 = bookDao.addBook(book2);
        bookList.add(book2);

        //author_id and publisher_id in book2 were re-used in book3
        Book book3 = new Book();
        book3.setIsbn("3847385746384");
        book3.setPublishDate(LocalDate.of(2012, 9, 13));
        book3.setAuthor_id(author2.getAuthorId());
        book3.setTitle("Wild Livin");
        book3.setPublisherId(publisher2.getPublisherId());
        book3.setPrice(29.99);
        book3 = bookDao.addBook(book3);
        bookList.add(book3);

        List<Book> bookByAuthorFromDb = bookDao.getBooksByAuthor(author2.getAuthorId());    //holds list of all books by author from the DB

        assertEquals(bookList, bookByAuthorFromDb);


    }
}