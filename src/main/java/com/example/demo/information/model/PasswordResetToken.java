package com.example.demo.information.model;

public class PasswordResetToken {
    private String user;
    private final String token;

    public PasswordResetToken(String token, User user) {
        super();
        this.token = token;
    }
}
