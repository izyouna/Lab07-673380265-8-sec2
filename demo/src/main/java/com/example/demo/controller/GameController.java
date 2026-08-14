package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Game;
import com.example.demo.service.GameService;

@Controller
@RequestMapping("/games")
public class GameController {
    private final GameService gameService;
    
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    // Get /games -> Returns a list of all games
    @GetMapping
    public String getAllGames(Model model) {
        model.addAttribute("games", gameService.getGamesList());
        return "games/list";
    }

    // Get /games/add -> Adds a new game (for demonstration purposes, this is a simple endpoint)
    @GetMapping("/add")
    public String addGamePage(Model model){
        model.addAttribute("game",new Game());
        return "games/add";
    }

    // Post /games/save -> Saves a new game (for demonstration purposes, this is a simple endpoint)
    @PostMapping("/save")
    public String saveGame(@ModelAttribute Game game) {
        gameService.addGame(game);
        return "redirect:/games";
    }

    // Get /games/edit/{id} -> Returns the edit page for a specific game
    @GetMapping("/edit/{id}")
    public String editGamePage(@PathVariable Long id, Model model){
        model.addAttribute("game", gameService.getGameById(id));
        return "games/edit";
    }
    
    // Post /games/update/{id} -> Updates a specific game
    @PostMapping("/update/{id}")
    public String updateGame(@PathVariable Long id, @ModelAttribute Game games) {
        games.setId(id);
        gameService.updateGame(games);
        return "redirect:/games";
    }

    // Get /games/delete/{id} -> Returns the delete confirmation page for a specific game
    @GetMapping("/delete/{id}")
    public String showDeletePage(@PathVariable Long id, Model model) {
        model.addAttribute("game", gameService.getGameById(id));
        return "games/delete";
    }

    // Post /games/delete/{id} -> Deletes a specific game
    @PostMapping("/delete/{id}")
    public String deleteGame(@PathVariable Long id) {
        gameService.deleteGame(id);
        return "redirect:/games";
    }
}