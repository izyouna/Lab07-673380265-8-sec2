package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Game;
import com.example.demo.repository.GameRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class GameService {
    private final GameRepository repository;

    public GameService(GameRepository repository) {
        this.repository = repository;
    }

    public List<Game> getGamesList() {
        return repository.findAll();
    }

    public Game getGameById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Game addGame(Game games) {
        return repository.save(games);
    }

    public Game updateGame(Long id, Game gameData) {
        Game existing = repository.findById(id).orElseThrow(() -> new RuntimeException("Game not found"));
        existing.setTitle(gameData.getTitle());
        existing.setGenre(gameData.getGenre());
        existing.setPlatform(gameData.getPlatform());
        existing.setRating(gameData.getRating());
        existing.setPrice(gameData.getPrice());
        existing.setDiscountType(gameData.getDiscountType());
        existing.setReleaseDate(gameData.getReleaseDate());
        return repository.save(existing);
    }

    public boolean deleteGame(Long id) {
        Game game = repository.findById(id).orElse(null);
        if (game != null) {
            repository.delete(game);
            return true;
        }
        return false;
    }
}
