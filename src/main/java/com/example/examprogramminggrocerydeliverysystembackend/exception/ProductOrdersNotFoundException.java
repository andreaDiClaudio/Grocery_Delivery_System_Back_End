package com.example.examprogramminggrocerydeliverysystembackend.exception;

public class ProductOrdersNotFoundException extends RuntimeException{
    public ProductOrdersNotFoundException(){
        super("Could not find any ProductOrders");
    }
}
