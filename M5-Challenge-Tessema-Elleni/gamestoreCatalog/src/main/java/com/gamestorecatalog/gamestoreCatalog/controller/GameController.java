package com.gamestorecatalog.gamestoreCatalog.controller;

import com.gamestorecatalog.gamestoreCatalog.model.Game;
import com.gamestorecatalog.gamestoreCatalog.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/game")
@CrossOrigin(origins = {"http://localhost:3000"})
@RefreshScope
public class GameController {
    @Autowired
    GameRepository gameRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Game createGame(@RequestBody @Valid Game game) {
        game = gameRepository.save(game);

        return game;

    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Game getGameInfo(@PathVariable("id") long gameId) {
      Optional<Game> game = gameRepository.findById(gameId);
        if (!game.isPresent()) {
            throw new IllegalArgumentException("Game not found for id " + gameId);
        } else {
            return game.get();
        }
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateGame(@RequestBody @Valid Game game) {
        gameRepository.save(game);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGame(@PathVariable("id") long gameId) {
        gameRepository.deleteById(gameId);
    }

    @GetMapping("/title/{title}")
    @ResponseStatus(HttpStatus.OK)
    public List<Game> getGamesByTitle(@PathVariable("title") String title) {
        List<Game> gamesByTitle =gameRepository.findAllByTitle(title);

        if (gamesByTitle == null || gamesByTitle.isEmpty()) {
            throw new IllegalArgumentException("No games were found with " + title);
        } else {
            return gamesByTitle;
        }
    }

    @GetMapping("/esrbrating/{esrb}")
    @ResponseStatus(HttpStatus.OK)
    public List<Game> getGamesByEsrbRating(@PathVariable("esrb") String esrb) {
        List<Game> gamesByEsrbRating = gameRepository.findAllByEsrbRating(esrb);

        if (gamesByEsrbRating == null || gamesByEsrbRating.isEmpty()) {
            throw new IllegalArgumentException("No games were found with ESRB Rating " + esrb);
        } else {
            return gamesByEsrbRating;
        }
    }

    @GetMapping("/studio/{studio}")
    @ResponseStatus(HttpStatus.OK)
    public List<Game> getGamesByStudio(@PathVariable("studio") String studio) {
        List<Game> gamesByStudio = gameRepository.findAllByStudio(studio);

        if (gamesByStudio == null || gamesByStudio.isEmpty()) {
            throw new IllegalArgumentException("No games were found from " + studio);
        } else {
            return gamesByStudio;
        }
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Game> getAllGames() {
        List<Game> games = gameRepository.findAll();

        if (games == null || games.isEmpty()) {
            throw new IllegalArgumentException("No games were found.");
        } else {
            return games;
        }
    }

}
