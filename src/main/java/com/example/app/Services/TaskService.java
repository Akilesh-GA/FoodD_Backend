package com.example.app.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.example.app.Repository.TaskRepository;
import com.example.app.Entities.Task;

@Service
public class TaskService {
    @Autowired
    public TaskRepository repo;
    
    public Task save(Task task) {
        return repo.save(task);
    }

    public List<Task> getAll() {
        return repo.findAll();
    }
}
