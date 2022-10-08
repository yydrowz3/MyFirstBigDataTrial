package com.gcsj.service.impl;

import com.gcsj.mapper.SchoolMajorMapper;
import com.gcsj.pojo.SchoolMajor;
import com.gcsj.service.SchoolMajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SchoolMajorServiceImpl implements SchoolMajorService {

    @Autowired
    SchoolMajorMapper schoolMajorMapper;


    @Override
    public SchoolMajor selectSchoolMajorBySchool(String schoolCode){
        return schoolMajorMapper.selectSchoolMajorBySchool(schoolCode);
    }
    @Override
    public List<SchoolMajor> selectSchoolMajorByMajor(String majorCode){
        return schoolMajorMapper.selectSchoolMajorByMajor (majorCode);
    }


}
