package com.real.student.data.repository;

/**
 * @author ERNEST EMMANUEL UTIBE
 * */

import com.real.student.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    @Override
    void delete(User user);
}
