package com.example.demo.information.passwords;

import com.example.demo.data.model.StudentInfo;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class StudentPasswordResetToken {
    private static final int EXPIRATION = 60 * 24;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String token;

    @OneToOne(targetEntity = StudentInfo.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "studentInfo_id")
    private StudentInfo studentInfo;

    private Date expiryDate;
}
