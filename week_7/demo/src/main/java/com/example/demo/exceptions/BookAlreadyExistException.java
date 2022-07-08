package com.example.demo.exceptions;

public class BookAlreadyExistException extends Exception{
    public BookAlreadyExistException(String message) {
        super(message);
    }
}
