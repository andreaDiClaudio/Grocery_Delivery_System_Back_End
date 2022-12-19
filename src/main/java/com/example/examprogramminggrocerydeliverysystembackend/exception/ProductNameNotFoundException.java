package com.example.examprogramminggrocerydeliverysystembackend.exception;

public class ProductNameNotFoundException extends RuntimeException{

    public ProductNameNotFoundException(String name){
        super("Could not find product with name: '" + name + "'" );
    }
}
