package com.example.app.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.Services.TaskService;
import com.example.app.Entities.Task;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService service;
    
    @PostMapping
    public Task addTask(@RequestBody Task task) {
        return service.save(task);
    }

    @GetMapping
    public List<Task> viewTasks() {
        return service.getAll();
    }

}
