package com.example.app.exception;

public class FoodNotFoundException extends RuntimeException {
    public FoodNotFoundException(String exception) {
        super(exception);
    }
}
