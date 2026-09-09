package com.example.app.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/render")
public class RenderController {
    @GetMapping("/health")
    public String checkHealth() {
        return "Render is live";
    }
}