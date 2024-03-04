package com.example.loosecoupling.exception;
public class ResourceNotFoundException extends Exception{

    public ResourceNotFoundException(String message){
        super(message);
    }
}