package com.real.student.exception.student;

/**
 * @author ERNEST EMMANUEL UTIBE
 * */

public class StudentAlreadyExistsException extends StudentNotFoundException{
    public StudentAlreadyExistsException(String message) {
        super(message);
    }
}
