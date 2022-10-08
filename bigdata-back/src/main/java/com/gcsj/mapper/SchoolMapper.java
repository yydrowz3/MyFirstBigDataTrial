package com.gcsj.mapper;


import com.gcsj.pojo.School;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SchoolMapper {

    School selectSchoolByName(String schoolName);

}
