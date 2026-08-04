package com.example.app.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.app.Entities.Food;
import com.example.app.Services.FoodService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/food")
public class FoodController {
    @Autowired
    public FoodService service;

    @PostMapping
    public Food addFoods(@RequestBody Food food) {
        return service.save(food);
    }

    @GetMapping
    public List<Food> viewFoods() {
        return service.getAll();
    }
}
