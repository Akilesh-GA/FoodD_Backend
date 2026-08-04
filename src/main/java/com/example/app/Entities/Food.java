package com.example.app.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    
    private double price;
    
    Food() {}

    Food(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFoodName() {
        return this.name;
    }

    public void setFoodName(String name) {
        this.name = name;
    }

    public double getFoodPrice() {
        return this.price;
    }

    public void setFoodPrice(double price) {
        this.price = price;
    }
}
