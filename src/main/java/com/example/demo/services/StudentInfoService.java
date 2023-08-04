package com.example.demo.services;

/**
 * @author ERNEST EMMANUEL UTIBE
 * **/


import com.example.demo.data.dto.request.StudentInfoRequest;
import com.example.demo.data.dto.response.StudentInfoResponse;
import com.example.demo.data.model.StudentInfo;


public interface StudentInfoService {
    StudentInfo registerStudent(StudentInfoRequest studentInfoRequest);

    StudentInfoResponse getAllRegisteredStudents(int pageNo, int pageSize);

    StudentInfoRequest getRegisteredStudentsByTheirID(Long registeredStudent);

    void deleteStudentById(Long studentId);
}
