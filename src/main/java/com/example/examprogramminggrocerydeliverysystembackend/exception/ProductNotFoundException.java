package com.example.examprogramminggrocerydeliverysystembackend.exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(int id) {
        super("Could not find Product with id: '" + id + "'");
    }
}
