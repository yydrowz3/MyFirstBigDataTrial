package com.gcsj.mapper;

import com.gcsj.pojo.Major;
import com.gcsj.pojo.EnrollmentInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface EnrollmentInfoMapper {


    int upDataById(EnrollmentInfo enrollmentInfo);

    EnrollmentInfo findById(EnrollmentInfo enrollmentInfo);
}
