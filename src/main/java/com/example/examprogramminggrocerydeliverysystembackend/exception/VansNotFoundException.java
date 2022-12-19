package com.example.examprogramminggrocerydeliverysystembackend.exception;

public class VansNotFoundException extends RuntimeException{
    public VansNotFoundException(){
        super("Could Not find any van");
    }
}
