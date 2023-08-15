package com.real.student.data.repository;

/**
 * @author Ernest Emmanuel Utibe
 **/

import com.real.student.data.model.StudentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentInfoRepository extends JpaRepository<StudentInfo, Long> {
    StudentInfo findByEmail(String email);
}
