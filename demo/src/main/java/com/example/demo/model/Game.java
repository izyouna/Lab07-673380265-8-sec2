package com.example.demo.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // เพิ่ม Auto Increment ID
    @Column(name = "id")
    protected  Long id;

    @Column(name = "title")
    protected String title;
    
    @Column(name = "genre")
    protected String genre;
    
    @Column(name = "platform")
    protected String platform;
    
    @Column(name = "rating")
    protected Double rating;
    
    @Column(name = "release_date")
    protected LocalDate releaseDate;
    
    @Column(name = "price")
    protected Double price;
    
    @Column(name = "discount_type")
    protected String discountType;

    public Game() {}

    public Game(Long id, String title, String genre, String platform, Double rating, LocalDate releaseDate, Double price, String discountType) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.platform = platform;
        this.rating = rating;
        this.releaseDate = releaseDate;
        this.price = price;
        this.discountType = discountType;
    }

    // --- Getter and Setter --- //
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getPlatform() {
        return platform;
    }

    public Double getRating() {
        return rating;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public Double getPrice() {
        return price;
    }

    public String getDiscountType() {
        return discountType;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }
}
