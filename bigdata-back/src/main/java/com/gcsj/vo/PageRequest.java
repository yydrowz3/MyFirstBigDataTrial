package com.gcsj.vo;

import com.gcsj.pojo.EnrollmentInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageRequest {

    /**
     * 当前页码
     */
    private int pageNum ;
    /**
     * 每页数量
     */
    private int pageSize;

    private EnrollmentInfo enrollmentInfo;
}
