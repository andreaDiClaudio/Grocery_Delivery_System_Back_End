package com.example.examprogramminggrocerydeliverysystembackend.exception;

public class DeliveriesFromWarehouseNotFoundException extends RuntimeException{
    public DeliveriesFromWarehouseNotFoundException(String warehouse){
        super("Could not find any delivery from warehouse: '" + warehouse +"'");
    }
}
