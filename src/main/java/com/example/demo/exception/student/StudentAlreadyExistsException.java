package com.example.demo.exception.student;

public class StudentAlreadyExistsException extends StudentNotFoundException{
    public StudentAlreadyExistsException(String message) {
        super(message);
    }
}
