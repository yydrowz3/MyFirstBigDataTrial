package com.gcsj.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class SchoolMajor {
    int id;
    String schoolCode;
    String majorCode;
}
