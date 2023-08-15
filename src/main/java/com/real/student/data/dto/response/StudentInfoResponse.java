package com.real.student.data.dto.response;

/**
 * @author ERNEST EMMANUEL UTIBE
 * */

import com.real.student.data.model.StudentInfo;
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
