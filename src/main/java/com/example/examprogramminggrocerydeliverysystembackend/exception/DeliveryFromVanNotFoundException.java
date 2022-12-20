package com.example.examprogramminggrocerydeliverysystembackend.exception;

import com.example.examprogramminggrocerydeliverysystembackend.model.Van;

public class DeliveryFromVanNotFoundException extends RuntimeException{
    public DeliveryFromVanNotFoundException(int id){
        super("Could not find any Delivery with van: '" + id + "'");
    }
}
