package com.example.demo.strategy;
import org.springframework.stereotype.Component;

import com.example.demo.model.Game;

@Component
public class DiscountContext {
    public Double calculateFinalPrice(Game game){
        
        // check game is null or not
        if(game == null || game.getPrice() == null || game.getDiscountType() == null){
            throw new IllegalArgumentException("Game, price, and discount type must not be null");
        }

        String discountType = game.getDiscountType() != null ? game.getDiscountType().toUpperCase() : "NONE";
        DiscountStrategy discountStrategy;

        switch (discountType) {
            case "NONE" -> discountStrategy = new NoDiscountStrategy();
            case "STUDENT" -> discountStrategy = new StudentDiscountStrategy();
            case "SEASONAL" -> discountStrategy = new SeasonalSaleStrategy();
            default -> {
                discountStrategy = new NoDiscountStrategy();
            }
        }

        return discountStrategy.calculateDiscount(game.getPrice());
    }
}
