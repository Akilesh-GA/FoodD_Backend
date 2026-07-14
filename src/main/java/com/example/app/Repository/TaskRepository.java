package com.example.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app.Entities.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{
    
}
