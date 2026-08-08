package com.example.demo.model;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void testGetFinalPriceWithNoDiscount() {
        Game game = new Game(1L, "Zelda", "Action", "Switch", 9.5, LocalDate.now(), 1000.0, "NONE");
        assertEquals(1000.0, game.getFinalPrice(), 0.001);
    }

    @Test
    void testGetFinalPriceWithStudentDiscount() {
        Game game = new Game(1L, "Zelda", "Action", "Switch", 9.5, LocalDate.now(), 1000.0, "STUDENT");
        assertEquals(900.0, game.getFinalPrice(), 0.001);
    }

    @Test
    void testGetFinalPriceWithSeasonalDiscount() {
        Game game = new Game(1L, "Zelda", "Action", "Switch", 9.5, LocalDate.now(), 1000.0, "SEASONAL");
        assertEquals(800.0, game.getFinalPrice(), 0.001);
    }

    @Test
    void testGetDiscountName() {
        Game gameNone = new Game(1L, "Zelda", "Action", "Switch", 9.5, LocalDate.now(), 1000.0, "NONE");
        assertEquals("ราคาปกติ", gameNone.getDiscountName());

        Game gameStudent = new Game(2L, "Mario", "Platformer", "Switch", 9.0, LocalDate.now(), 1000.0, "STUDENT");
        assertEquals("ส่วนลดนักศึกษา (10%)", gameStudent.getDiscountName());

        Game gameSeasonal = new Game(3L, "Pokemon", "RPG", "Switch", 8.5, LocalDate.now(), 1000.0, "SEASONAL");
        assertEquals("ส่วนลดเทศกาล (20%)", gameSeasonal.getDiscountName());
    }
}
