package com.example.app.exception;

public class RestaurantNotFoundException extends RuntimeException {
    public RestaurantNotFoundException(String exception) {
        super(exception);
    }
}
