package com.example.app.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.app.Entities.Food;
import com.example.app.Services.FoodService;

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
@RequestMapping("/food")
public class FoodController {
    @Autowired
    public FoodService service;

    @GetMapping("/listFoods")
    public List<Food> viewFoods() {
        return service.getAll();
    }

    @PostMapping("addFood")
    public Food addFoods(@RequestBody Food food) {
        return service.save(food);
    }

    @PostMapping("/getFood")
    public Food getFoodById(@RequestBody Long id) {
        return service.getFoodById(id);
    }

    @PatchMapping("/updateFood")
    public Food updateFood(@RequestBody Food food) {
        return service.updateFood(food);
    }

    @DeleteMapping("/deleteFood/{id}")
    public void deleteFood(@PathVariable Long id) {
        service.deleteFood(id);
    }
}
