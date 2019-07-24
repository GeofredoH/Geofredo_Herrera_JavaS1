package com.company.GeofredoHerreraU1Capstone.dao.dao;

import com.company.GeofredoHerreraU1Capstone.dao.dto.Game;

import java.util.List;

public interface GameDao {

    Game addGame(Game game);

    Game getGame(int id);

    List<Game> getAllGames();

    void updateGame(Game game);

    void deleteGame(int id);

    List<Game> getGameByStudio(String studio);

    List<Game> getGameByEsrbRating(String esrb);

    List<Game> getGameByTitle(String title);

}
