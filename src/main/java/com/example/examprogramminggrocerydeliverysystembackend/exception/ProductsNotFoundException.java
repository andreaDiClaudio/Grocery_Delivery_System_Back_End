package com.example.examprogramminggrocerydeliverysystembackend.exception;

public class ProductsNotFoundException extends RuntimeException {
    public ProductsNotFoundException() {
        super("Could Not find any product");
    }
}
