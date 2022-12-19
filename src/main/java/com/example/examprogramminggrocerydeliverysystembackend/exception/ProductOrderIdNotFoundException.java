package com.example.examprogramminggrocerydeliverysystembackend.exception;

public class ProductOrderIdNotFoundException extends RuntimeException{
    public ProductOrderIdNotFoundException(int id){
        super("Could Not fin ProductOrder with id: '" + id + "'");
    }
}
