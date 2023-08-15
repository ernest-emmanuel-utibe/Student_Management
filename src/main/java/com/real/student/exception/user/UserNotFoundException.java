package com.real.student.exception.user;

/**
 * @author ERNEST EMMANUEL UTIBE
 * */

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }

}
