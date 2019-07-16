package com.company.GeofredoHerreraU1M5Summative.DAO;

import com.company.GeofredoHerreraU1M5Summative.DTO.Author;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class AuthorDaoJdbcImplTest {
    @Autowired
    protected AuthorDao authorDao;

    //Delete all records before starting tests
    @Before
    public void setUp() throws Exception {
        List<Author> authorList = authorDao.getAllAuthors();
        authorList.stream()
                .forEach(a -> authorDao.deleteAuthor(a.getAuthorId()));
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getAddGetDeleteAuthor() { //combined add get and delete methods into one test for efficiency
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

        Author authorFromDb = authorDao.getAuthor(author.getAuthorId());

        assertEquals(author, authorFromDb);

        authorDao.deleteAuthor(author.getAuthorId());

        authorFromDb = authorDao.getAuthor(author.getAuthorId());

        assertNull(authorFromDb);

    }

    @Test
    public void getAllAuthors() {
        List<Author> authorList = new ArrayList<>();    //holds list of newly created authors

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
        authorList.add(author1);

        Author author2 = new Author();
        author2.setFirst_name("Paul");
        author2.setLast_name("Charles");
        author2.setStreet("556 Chicken Fried Ave.");
        author2.setCity("Monticello");
        author2.setState("KS");
        author2.setPostalCode("2222-54345");
        author2.setPhone("777-777-6767");
        author2.setEmail("charlypaul@yahoo.com");
        author2 = authorDao.addAuthor(author2);
        authorList.add(author2);

        List<Author> authorsFromDb = authorDao.getAllAuthors();     //holds list of all authors from DB

        assertEquals(authorList.size(), authorsFromDb.size());
    }

    @Test
    public void updateAuthor() {
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

        author.setStreet("5529 Wilora Lake Ave.");
        author.setCity("Charlotte");
        author.setState("NC");
        author.setPostalCode("3434-28212");

        authorDao.updateAuthor(author);

        Author authorFromDb = authorDao.getAuthor(author.getAuthorId());

        assertEquals(author, authorFromDb);

    }
}