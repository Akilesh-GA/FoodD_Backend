package com.example.app.Services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.app.Repository.UserRepositiry;
import com.example.app.dto.LoginRequest;
import com.example.app.dto.RegisterRequest;

import com.example.app.Entities.User;

@Service 
public class AuthService {
    private final UserRepositiry userRepositiry;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepositiry userRepositiry, PasswordEncoder passwordEncoder) {
        this.userRepositiry = userRepositiry;
        this.passwordEncoder = passwordEncoder;
    }

    public String register(RegisterRequest request) {
        if(userRepositiry.existsByEmail(request.getEmail())) {
            return "User already exist!";
        }

        String encodedPassword = passwordEncoder.encode(request.getPassword());
        
        User user = new User(request.getName(), request.getEmail(), encodedPassword, "USER");

        userRepositiry.save(user);

        return "User Registered successfully!";
    }

    public String login(LoginRequest request) {
        User user = userRepositiry.findByEmail(request.getEmail()).orElseThrow(() -> new RuntimeException("User not found!"));
        
        boolean isPasswordCorrect = passwordEncoder.matches(request.getPassword(), user.getPassword());

        if(!isPasswordCorrect) {
            throw new RuntimeException("Invalid Password!");
        }

        return "Login successful!";
    }
}
