package com.company.GeofredoHerreraU1M5Summative.DAO;

import com.company.GeofredoHerreraU1M5Summative.DTO.Publisher;

import java.util.List;

public interface PublisherDao {
    Publisher addPublisher(Publisher publisher);

    Publisher getPublisher(int id);

    List<Publisher> getAllPublishers();

    void updatePublisher(Publisher publisher);

    void deletePublisher(int id);

    void deleteAllPublisher();

}
