package com.example.examprogramminggrocerydeliverysystembackend.exception;

public class VanByIdNotFoundException extends RuntimeException{
    public VanByIdNotFoundException(int id){
        super("Could not find Van with id: '" + id + "'");
    }
}
