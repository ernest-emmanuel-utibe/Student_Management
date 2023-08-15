package com.real.student.exception.student;

/**
 * @author ERNEST EMMANUEL UTIBE
 * */

public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException(String message) {
        super(message);
    }
}
