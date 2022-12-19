package com.example.examprogramminggrocerydeliverysystembackend.exception;

public class ProductOrdersFromWarehouseNotFoundException extends RuntimeException{
    public ProductOrdersFromWarehouseNotFoundException(String warehouse){
        super("Could not find any order from WareHouse: '" + warehouse +"'");
    }
}
