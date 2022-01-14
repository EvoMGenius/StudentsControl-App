package com.apatios.springbootapp.exceptions;

public class InvalidAttributeValueException extends RuntimeException{
    public InvalidAttributeValueException(String message){
        super(message);
    }
}