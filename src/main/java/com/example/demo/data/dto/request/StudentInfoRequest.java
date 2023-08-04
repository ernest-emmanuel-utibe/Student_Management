package com.example.demo.data.dto.request;

import lombok.*;
import org.springframework.http.HttpStatusCode;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentInfoRequest {
    private Long id;
    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private String address;
    private String password;
}
