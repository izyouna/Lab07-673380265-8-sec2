package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.Game;
import com.example.demo.repository.GameRepository;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GameServiceTest {

    @Autowired
    private GameService gameService;

    @Autowired
    private GameRepository gameRepository;

    @BeforeEach
    void setUp() {
        gameRepository.deleteAll();
    }

    @Test
    void testAddGameAndRetrieveWithDiscounts() {
        // Create 3 games with different discount strategies
        Game g1 = new Game(null, "Elden Ring", "RPG", "PC", 9.8, LocalDate.of(2022, 2, 25), 1990.0, "NONE");
        Game g2 = new Game(null, "Zelda: Tears of the Kingdom", "Adventure", "Switch", 9.6, LocalDate.of(2023, 5, 12), 2200.0, "STUDENT");
        Game g3 = new Game(null, "Cyberpunk 2077", "Action RPG", "PC", 8.5, LocalDate.of(2020, 12, 10), 1790.0, "SEASONAL");

        // Save via service
        gameService.addGame(g1);
        gameService.addGame(g2);
        gameService.addGame(g3);

        // Retrieve games list
        List<Game> games = gameService.getGamesList();
        assertEquals(3, games.size());

        // Verify Game 1 (NONE -> 0% discount)
        Game savedG1 = games.stream().filter(g -> g.getTitle().equals("Elden Ring")).findFirst().orElseThrow();
        assertEquals("ราคาปกติ", savedG1.getDiscountName());
        assertEquals(1990.0, savedG1.getFinalPrice(), 0.001);

        // Verify Game 2 (STUDENT -> 10% discount: 2200 * 0.9 = 1980)
        Game savedG2 = games.stream().filter(g -> g.getTitle().equals("Zelda: Tears of the Kingdom")).findFirst().orElseThrow();
        assertEquals("ส่วนลดนักศึกษา (10%)", savedG2.getDiscountName());
        assertEquals(1980.0, savedG2.getFinalPrice(), 0.001);

        // Verify Game 3 (SEASONAL -> 20% discount: 1790 * 0.8 = 1432)
        Game savedG3 = games.stream().filter(g -> g.getTitle().equals("Cyberpunk 2077")).findFirst().orElseThrow();
        assertEquals("ส่วนลดเทศกาล (20%)", savedG3.getDiscountName());
        assertEquals(1432.0, savedG3.getFinalPrice(), 0.001);
    }
}
