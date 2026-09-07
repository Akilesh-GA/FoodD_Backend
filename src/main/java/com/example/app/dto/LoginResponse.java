package com.example.app.dto;

public class LoginResponse {
    public String token;
    
    public LoginResponse() {
        
    }

    public LoginResponse(String token) {
        this.token = token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return this.token;
    }
}
