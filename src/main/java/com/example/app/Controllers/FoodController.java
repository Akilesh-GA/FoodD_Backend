package com.example.app.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.app.Entities.Food;
import com.example.app.Services.FoodService;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/foodd")
public class FoodController {
    @Autowired
    public FoodService service;

    @GetMapping("/list-foods")
    public List<Food> viewFoods() {
        return service.getAll();
    }

    @PostMapping("/add-food")
    public Food addFoods(@Valid @RequestBody Food food) {
        return service.save(food);
    }

    @PostMapping("/get-food")
    public Food getFoodById(@Valid @RequestBody Long id) {
        return service.getFoodById(id);
    }

    @PatchMapping("/update-food")
    public Food updateFood(@Valid @RequestBody Food food) {
        return service.updateFood(food);
    }

    @DeleteMapping("/delete-food/{id}")
    public String deleteFood(@PathVariable Long id) {
        return service.deleteFood(id);
    }
}