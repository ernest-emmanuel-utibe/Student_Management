package com.real.student.data.dto.request;

/**
 * @author ERNEST EMMANUEL UTIBE
 * */

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
