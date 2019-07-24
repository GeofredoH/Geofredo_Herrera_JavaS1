package com.company.GeofredoHerreraU1Capstone.dao.controller;

import com.company.GeofredoHerreraU1Capstone.dao.Exception.NotFoundException;
import com.company.GeofredoHerreraU1Capstone.dao.service.ServiceLayer;
import com.company.GeofredoHerreraU1Capstone.dao.viewModel.GameViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    ServiceLayer service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GameViewModel createGame(@RequestBody @Valid GameViewModel gameViewModel) {
        gameViewModel = service.createGame(gameViewModel);
        return gameViewModel;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GameViewModel getGameInfo(@PathVariable("id") int gameId) {
        GameViewModel gameViewModel = service.getGameViewModelById(gameId);
        if (gameViewModel == null) {
            throw new NotFoundException("Game could not be retrieved for id " + gameId);
        } else {
            return gameViewModel;
        }
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateGame(@PathVariable("id") int gameId, @RequestBody @Valid GameViewModel gameViewModel) {
        if (gameViewModel.getGameId() == 0) {
            gameViewModel.setGameId(gameId);
        } else if (gameId != gameViewModel.getGameId()) {
            throw new IllegalArgumentException("The id in the path variable must match the id in the view model");
        }

        service.updateGameViewModel(gameViewModel);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGame(@PathVariable("id") int gameId) {
        service.deleteGameViewModel(gameId);
    }

    @GetMapping("/title/{title}")
    @ResponseStatus(HttpStatus.OK)
    public List<GameViewModel> getGamesByTitle(@PathVariable("title") String title) {
        List<GameViewModel> gamesByTitle = service.getGameViewModelByTitle(title);

        if (gamesByTitle == null || gamesByTitle.isEmpty()) {
            throw new NotFoundException("No games were found with " + title + " in the title");
        } else {
            return gamesByTitle;
        }
    }

    @GetMapping("/esrbrating/{esrb}")
    @ResponseStatus(HttpStatus.OK)
    public List<GameViewModel> getGamesByEsrbRating(@PathVariable("esrb") String esrb) {
        List<GameViewModel> gamesByEsrbRating = service.getGameViewModelByEsrb(esrb);

        if (gamesByEsrbRating == null || gamesByEsrbRating.isEmpty()) {
            throw new NotFoundException("No games were found with ESRB rating " + esrb);
        } else {
            return gamesByEsrbRating;
        }
    }

    @GetMapping("/studio/{studio}")
    @ResponseStatus(HttpStatus.OK)
    public List<GameViewModel> getGamesByStudio(@PathVariable("studio") String studio) {
        List<GameViewModel> gamesByStudio = service.getGameViewModelByStudio(studio);

        if (gamesByStudio == null || gamesByStudio.isEmpty()) {
            throw new NotFoundException("No games were found from " + studio);
        } else {
            return gamesByStudio;
        }
    }
}
