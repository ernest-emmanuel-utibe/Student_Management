package com.example.demo.data.dto.response;

import com.example.demo.data.model.StudentInfo;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class StudentInfoResponse {
    private List<StudentInfo> content;
    private int pageNo;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean last;
}
