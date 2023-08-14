package com.example.demo.information.repository;

import com.example.demo.information.model.PasswordResetToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasswordTokenRepository extends JpaRepository<PasswordResetToken, String> {
}
