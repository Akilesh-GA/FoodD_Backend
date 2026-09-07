package com.example.app.Services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.app.Repository.UserRepository;
import com.example.app.dto.LoginRequest;
import com.example.app.dto.RegisterRequest;

import com.example.app.Entities.User;

@Service 
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(UserRepository userRepositiry, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userRepository = userRepositiry;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public String register(RegisterRequest request) {
        if(userRepository.existsByEmail(request.getEmail())) {
            return "User already exist!";
        }

        String encodedPassword = passwordEncoder.encode(request.getPassword());
        
        User user = new User(request.getName(), request.getEmail(), encodedPassword, "USER");

        userRepository.save(user);

        return "User Registered successfully!";
    }

    public String login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found!"));

        boolean isPasswordCorrect =
                passwordEncoder.matches(
                        request.getPassword(),
                        user.getPassword()
                );

        if (!isPasswordCorrect) {
            throw new RuntimeException("Invalid Password!");
        }

        String token = jwtService.generateToken(user.getEmail());

        System.out.println("JWT Token: " + token);

        return "Login Successful!";
    }
}
