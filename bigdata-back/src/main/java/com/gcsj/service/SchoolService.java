package com.gcsj.service;

import com.gcsj.pojo.School;
import org.springframework.stereotype.Service;

@Service
public interface SchoolService {
    School selectSchoolByName(String schoolName);
}
