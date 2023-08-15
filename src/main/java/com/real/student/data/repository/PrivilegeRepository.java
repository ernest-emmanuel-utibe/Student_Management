package com.real.student.data.repository;

/**
 * @author ERNEST EMMANUEL UTIBE
 * */

import com.real.student.data.model.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {
    Privilege findByName(String name);

    @Override
    void delete(Privilege privilege);
}
