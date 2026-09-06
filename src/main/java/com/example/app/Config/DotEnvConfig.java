package com.example.app.Config;

import org.springframework.context.annotation.Configuration;

import io.github.cdimascio.dotenv.Dotenv;

@Configuration
public class DotEnvConfig {
    static { 
        Dotenv dotenv = Dotenv.load();
        
        dotenv.entries().forEach(entry -> {
            System.setProperty(
                entry.getKey(),
                entry.getValue()
            );
        });
    } 
}
