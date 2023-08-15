package com.real.student.data.repository;

/**
 * @author ERNEST EMMANUEL UTIBE
 * */

import com.real.student.data.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);

    @Override
    void delete(Role role);
}
