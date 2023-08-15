package com.real.student.services;

/**
 * @author ERNEST EMMANUEL UTIBE
 * **/


import com.real.student.data.dto.StudentDto;
import com.real.student.data.dto.request.StudentInfoRequest;
import com.real.student.data.dto.response.StudentInfoResponse;
import com.real.student.data.model.StudentInfo;

public interface StudentInfoService {
    StudentInfo registerStudent(StudentInfoRequest studentInfoRequest, StudentDto studentDto);

    StudentInfoResponse getAllRegisteredStudents(int pageNo, int pageSize);

    StudentInfoRequest getRegisteredStudentsByTheirID(Long registeredStudent);

    StudentInfo updateStudentsByTheirId(StudentInfoRequest studentInfoRequest, Long id);

    void deleteStudentById(Long studentId);
}
