package com.example.demo.exceptions;

public class EmployeeAlreadyExistException extends Exception{
    public EmployeeAlreadyExistException(String message) {
        super(message);
    }
}
