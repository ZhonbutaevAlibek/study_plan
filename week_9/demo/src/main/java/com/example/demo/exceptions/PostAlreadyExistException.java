package com.example.demo.exceptions;

public class PostAlreadyExistException extends Exception{
    public PostAlreadyExistException(String message) {
        super(message);
    }
}
