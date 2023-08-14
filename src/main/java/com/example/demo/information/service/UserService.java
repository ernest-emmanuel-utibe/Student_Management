package com.example.demo.information.service;

import com.example.demo.information.model.User;

public interface UserService {
    User findUserByEmail(String email);

    void createPasswordResetTokenForUser(User user, String token);


}
