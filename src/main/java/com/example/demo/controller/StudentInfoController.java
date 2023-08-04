package com.example.demo.controller;

/**
 * @author ERNEST EMMANUEL UTIBE
 **/


import com.example.demo.data.dto.request.StudentInfoRequest;
import com.example.demo.data.dto.response.StudentInfoResponse;
import com.example.demo.data.model.StudentInfo;
import com.example.demo.services.StudentInfoService;
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
    public ResponseEntity<StudentInfo> registerStudents(@RequestBody StudentInfoRequest request) {
        return new ResponseEntity<>(studentInfoService.registerStudent(request), HttpStatus.CREATED);
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

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudents(@PathVariable("id") Long studentId) {
        studentInfoService.deleteStudentById(studentId);
        return new ResponseEntity<>("Student deleted successfully", HttpStatus.OK);
    }
}
