package com.example.app.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.Entities.Food;
import com.example.app.Repository.FoodRepository;

import java.util.List;

@Service
public class FoodService {
    @Autowired
    public FoodRepository repo;

    public Food save(Food food) {
        return repo.save(food);
    }

    public List<Food> getAll() {
        return repo.findAll();
    }
}
