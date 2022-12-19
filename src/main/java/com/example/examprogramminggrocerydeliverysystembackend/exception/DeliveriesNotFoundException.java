package com.example.examprogramminggrocerydeliverysystembackend.exception;

public class DeliveriesNotFoundException extends RuntimeException {

    public DeliveriesNotFoundException() {
        super("Could not find any Delivery");
    }
}
