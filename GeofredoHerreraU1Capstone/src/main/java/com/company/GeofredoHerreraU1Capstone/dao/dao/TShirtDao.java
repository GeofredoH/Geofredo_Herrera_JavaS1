package com.company.GeofredoHerreraU1Capstone.dao.dao;

import com.company.GeofredoHerreraU1Capstone.dao.dto.TShirt;

import java.util.List;

public interface TShirtDao {

    TShirt addTShirt(TShirt tShirt);

    TShirt getTShirtById(int id);

    List<TShirt> getAllTShirts();

    void updateTShirt(TShirt tShirt);

    void deleteTShirt(int id);

    List<TShirt> getTShirtByColor(String color);

    List<TShirt> getTShirtBySize(String size);

}
