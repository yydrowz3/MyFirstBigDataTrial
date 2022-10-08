package com.gcsj.mapper;


import com.gcsj.pojo.SchoolMajor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository

public interface SchoolMajorMapper {
    SchoolMajor selectSchoolMajorBySchool (String schoolCode);
    List<SchoolMajor> selectSchoolMajorByMajor ( String majorCode);
}
