package com.real.student.controller;

/**
 * @author ERNEST EMMANUEL UTIBE
 **/


import com.real.student.data.dto.StudentDto;
import com.real.student.data.dto.request.StudentInfoRequest;
import com.real.student.data.dto.response.StudentInfoResponse;
import com.real.student.data.model.StudentInfo;
import com.real.student.services.StudentInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/v1/students")
@RestController
@RequiredArgsConstructor
public class StudentInfoController {
    private final StudentInfoService studentInfoService;

    @PostMapping("/register-students")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<StudentInfo> registerStudents(@RequestBody StudentInfoRequest request, StudentDto studentDto) {
        return new ResponseEntity<>(studentInfoService.registerStudent(request, studentDto), HttpStatus.CREATED);
    }

    @GetMapping("/get-all-students")
    public ResponseEntity<StudentInfoResponse> getAllTheRegisteredInformation(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize)
    {
        return new ResponseEntity<>(studentInfoService.getAllRegisteredStudents(pageNo, pageSize), HttpStatus.OK);
    }

    @GetMapping("/get-the-registered-students/{id}")
    public ResponseEntity<StudentInfoRequest> getRegisteredStudentsByTheirId(@PathVariable Long id) {
        return ResponseEntity.ok(studentInfoService.getRegisteredStudentsByTheirID(id));
    }

    @PutMapping("/update-students/{id}")
    public ResponseEntity<StudentInfo> updateStudentsByTheirId(@RequestBody StudentInfoRequest studentInfoRequest,
            @PathVariable("id") Long updatedStudentId) {
        StudentInfo studentInfoResponse = studentInfoService.updateStudentsByTheirId(studentInfoRequest, updatedStudentId);
        return new ResponseEntity<>(studentInfoResponse, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudents(@PathVariable("id") Long studentId) {
        studentInfoService.deleteStudentById(studentId);
        return new ResponseEntity<>("Student deleted successfully", HttpStatus.OK);
    }
}
