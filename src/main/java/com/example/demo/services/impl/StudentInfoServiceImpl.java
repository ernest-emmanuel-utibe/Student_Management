package com.example.demo.services.impl;

/**
 * @author ERNEST EMMANUEL UTIBE
**/

import com.example.demo.data.dto.request.StudentInfoRequest;
import com.example.demo.data.dto.response.StudentInfoResponse;
import com.example.demo.data.model.StudentInfo;
import com.example.demo.data.repository.StudentInfoRepository;
import com.example.demo.exception.StudentNotFoundException;
import com.example.demo.services.StudentInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentInfoServiceImpl implements StudentInfoService {

    private final StudentInfoRepository studentInfoRepository;


    @Override
    public StudentInfo registerStudent(StudentInfoRequest studentInfoRequest) {
        StudentInfo studentInfo = new StudentInfo();
        studentInfo.setFirstName(studentInfoRequest.getFirstName());
        studentInfo.setLastName(studentInfoRequest.getLastName());
        studentInfo.setGender(studentInfoRequest.getGender());
        studentInfo.setEmail(studentInfoRequest.getEmail());
        studentInfo.setAddress(studentInfoRequest.getAddress());
        studentInfo.setPassword(studentInfoRequest.getPassword());
        studentInfoRepository.save(studentInfo);
        return studentInfo;
    }

    @Override
    public StudentInfoResponse getAllRegisteredStudents(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<StudentInfo> studentInfos = studentInfoRepository.findAll(pageable);
        List<StudentInfo> listOfStudents = studentInfos.getContent();
        List<StudentInfoRequest> content = listOfStudents.stream().map(this::mapToDto).toList();

        StudentInfoResponse studentInfoResponse = new StudentInfoResponse();
        studentInfoResponse.setContent(studentInfos.getContent());
        studentInfoResponse.setPageNo(studentInfos.getNumber());
        studentInfoResponse.setPageSize(studentInfos.getSize());
        studentInfoResponse.setTotalElements(studentInfos.getTotalElements());
        studentInfoResponse.setTotalPages(studentInfos.getTotalPages());
        studentInfoResponse.setLast(studentInfos.isLast());

        return studentInfoResponse;
    }

    @Override
    public StudentInfoRequest getRegisteredStudentsByTheirID(Long registeredStudent) {
        StudentInfo studentInfo = studentInfoRepository.findById(registeredStudent).orElseThrow(() -> new StudentNotFoundException("Student with id not found"));
        return mapToDto(studentInfo);
    }

    @Override
    public void deleteStudentById(Long studentId) {
        StudentInfo studentInfo = studentInfoRepository.findById(studentId).orElseThrow(() -> new StudentNotFoundException("Student id not found"));
        studentInfoRepository.delete(studentInfo);
    }

    private StudentInfoRequest mapToDto(StudentInfo studentInfo) {
        StudentInfoRequest studentInfoRequest = new StudentInfoRequest();
        studentInfoRequest.setId(studentInfo.getId());
        studentInfoRequest.setFirstName(studentInfo.getFirstName());
        studentInfoRequest.setLastName(studentInfo.getLastName());
        studentInfoRequest.setGender(studentInfo.getGender());
        studentInfoRequest.setEmail(studentInfo.getEmail());
        studentInfoRequest.setAddress(studentInfo.getAddress());
        return studentInfoRequest;
    }


}
