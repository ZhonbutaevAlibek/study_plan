package com.example.demo.exceptions;

public class AuthorAlreadyExistException extends Exception{
    public AuthorAlreadyExistException(String message) {
        super(message);
    }
}
