package com.example.demo.strategy;

public class StudentDiscountStrategy implements DiscountStrategy {

    @Override
    public Double calculateDiscount(Double price) {
        return price * 0.9; // Apply a 10% discount for students
    }
}
