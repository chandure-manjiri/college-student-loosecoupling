package com.example.loosecoupling.exception;

public class InvalidPersonTypeException extends RuntimeException{
    public InvalidPersonTypeException(String message){
        super(message);
    }
}
