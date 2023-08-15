package com.real.student.security;

/**
 * @author ERNEST EMMANUEL UTIBE
 * */

public interface ISecurityUserService {
    String validatePasswordResetToken(String token);
}
