package com.example.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app.Entities.Food;

public interface FoodRepository extends JpaRepository<Food, Long>{
    
}
