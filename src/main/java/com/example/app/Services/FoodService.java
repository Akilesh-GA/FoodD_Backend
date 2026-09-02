package com.example.app.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.Entities.Food;
import com.example.app.Repository.FoodRepository;
import com.example.app.exception.FoodNotFoundException;

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

    public Food getFoodById(Long id) {
        return findFoodById(id);
    }

    public Food updateFood(Food food) {

        Food existingFood = findFoodById(food.getId());

        existingFood.setName(food.getName());
        existingFood.setPrice(food.getPrice());

        Food updatedFood = repo.save(existingFood);

        return updatedFood;
    }

    public void deleteFood(Long id) {
        Food existingFood = findFoodById(id);
        repo.delete(existingFood);
    }

    public Food findFoodById(Long id) {
        Food food = repo.findById(id)
                        .orElseThrow(() -> new FoodNotFoundException("Food with " + id + " is not available !"));
        return food;
    }
}
