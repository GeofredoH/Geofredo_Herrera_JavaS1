package com.company.GeofredoHerreraU1M5Summative.DAO;

import com.company.GeofredoHerreraU1M5Summative.DTO.Publisher;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PublisherDaoJdbcImplTest {

    @Autowired
    protected PublisherDao publisherDao;

    @Before
    public void setUp() throws Exception {
        List<Publisher> publisherList = publisherDao.getAllPublishers();

        publisherList
                .stream().forEach(p -> publisherDao.deletePublisher(p.getPublisherId()));
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addGetDeletePublisher(){        //combined add get and delete methods into one test for efficiency

        Publisher publisher = new Publisher();
        publisher.setName("BigPrint");
        publisher.setStreet("333 West Willow St.");
        publisher.setCity("Atlanta");
        publisher.setState("GA");
        publisher.setPostalCode("4535-49385");
        publisher.setPhone("234-848-8484");
        publisher.setEmail("manager@bigprint.com");
        publisher = publisherDao.addPublisher(publisher);

        Publisher publisher2 = publisherDao.getPublisher(publisher.getPublisherId());

        assertEquals(publisher, publisher2);

        publisherDao.deletePublisher(publisher2.getPublisherId());

        publisher = null;

        publisher2 = publisherDao.getPublisher(publisher2.getPublisherId());

        assertEquals(publisher, publisher2);

    }

    @Test
    public void getAllPublishers() {
        List<Publisher> pubList = new ArrayList<>();    //holds list of newly createdf publishers

        Publisher publisher1 = new Publisher();
        publisher1.setName("BigPrint");
        publisher1.setStreet("333 West Willow St.");
        publisher1.setCity("Atlanta");
        publisher1.setState("GA");
        publisher1.setPostalCode("4535-49385");
        publisher1.setPhone("234-848-8484");
        publisher1.setEmail("manager@bigprint.com");
        publisher1 = publisherDao.addPublisher(publisher1);
        pubList.add(publisher1);

        Publisher publisher2 = new Publisher();
        publisher2.setName("Rainbow Read");
        publisher2.setStreet("555 John St.");
        publisher2.setCity("Santa Fe");
        publisher2.setState("CA");
        publisher2.setPostalCode("8577-38575");
        publisher2.setPhone("567-123-7665");
        publisher2.setEmail("manager@rainbowread.com");
        publisher2 = publisherDao.addPublisher(publisher2);
        pubList.add(publisher2);

        Publisher publisher3 = new Publisher();
        publisher3.setName("Letter Head");
        publisher3.setStreet("999 Willora St.");
        publisher3.setCity("Nashville");
        publisher3.setState("TN");
        publisher3.setPostalCode("2574-93578");
        publisher3.setPhone("798-444-6655");
        publisher3.setEmail("manager@letterhead.com");
        publisher3 = publisherDao.addPublisher(publisher3);
        pubList.add(publisher3);

        List<Publisher> pubListFromDb = publisherDao.getAllPublishers();    //holds list of all publishers from DB

        assertEquals(pubList, pubListFromDb);

    }

    @Test
    public void updatePublisher() {
        Publisher publisher1 = new Publisher();
        publisher1.setName("BigPrint");
        publisher1.setStreet("333 West Willow St.");
        publisher1.setCity("Atlanta");
        publisher1.setState("GA");
        publisher1.setPostalCode("4535-49385");
        publisher1.setPhone("234-848-8484");
        publisher1.setEmail("manager@bigprint.com");
        publisher1 = publisherDao.addPublisher(publisher1);

        publisher1.setName("BigPrint");
        publisher1.setStreet("553 Beatties Ford Rd.");
        publisher1.setCity("Charlotte");
        publisher1.setState("NC");
        publisher1.setPostalCode("2444-96755");
        publisher1.setPhone("234-848-8484");
        publisher1.setEmail("manager@bigprint.com");

        publisherDao.updatePublisher(publisher1);

        Publisher publisher2 = publisherDao.getPublisher(publisher1.getPublisherId());

        assertEquals(publisher1, publisher2);
    }

    @Test
    public void deleteAllPublisher() {     //additional deleteAll method was added for example purposes

        Publisher publisher1 = new Publisher();
        publisher1.setName("BigPrint");
        publisher1.setStreet("333 West Willow St.");
        publisher1.setCity("Atlanta");
        publisher1.setState("GA");
        publisher1.setPostalCode("4535-49385");
        publisher1.setPhone("234-848-8484");
        publisher1.setEmail("manager@bigprint.com");
        publisher1 = publisherDao.addPublisher(publisher1);

        Publisher publisher2 = new Publisher();
        publisher2.setName("Rainbow Read");
        publisher2.setStreet("555 John St.");
        publisher2.setCity("Santa Fe");
        publisher2.setState("CA");
        publisher2.setPostalCode("8577-38575");
        publisher2.setPhone("567-123-7665");
        publisher2.setEmail("manager@rainbowread.com");
        publisher2 = publisherDao.addPublisher(publisher2);

        Publisher publisher3 = new Publisher();
        publisher3.setName("Letter Head");
        publisher3.setStreet("999 Willora St.");
        publisher3.setCity("Nashville");
        publisher3.setState("TN");
        publisher3.setPostalCode("2574-93578");
        publisher3.setPhone("798-444-6655");
        publisher3.setEmail("manager@letterhead.com");
        publisher3 = publisherDao.addPublisher(publisher3);

        publisherDao.deleteAllPublisher();

        List<Publisher> pubList = publisherDao.getAllPublishers();  //list from DB should be empty

        assertEquals(0, pubList.size());

    }
}