package com.gcsj.pojo;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

@Data
public class EnrollmentInfo {

    int id;
    String schoolCode;
    String schoolName;
    String province;
    String majorCode;
    String profess;
    String subject;
    int batch;
    int plan;

}
