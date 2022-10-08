package com.gcsj.service.impl;

import com.gcsj.mapper.SchoolMapper;
import com.gcsj.pojo.School;
import com.gcsj.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchoolServiceImpl implements SchoolService {
    @Autowired
    SchoolMapper schoolMapper;

    public School selectSchoolByName(String schoolName){
        return schoolMapper.selectSchoolByName(schoolName);
    }
}
