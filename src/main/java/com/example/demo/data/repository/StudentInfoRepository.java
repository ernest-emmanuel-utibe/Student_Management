package com.example.demo.data.repository;

/**
 * @author Ernest Emmanuel Utibe
 **/

import com.example.demo.data.model.StudentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentInfoRepository extends JpaRepository<StudentInfo, Long> {
    StudentInfo findByEmail(String email);
}
