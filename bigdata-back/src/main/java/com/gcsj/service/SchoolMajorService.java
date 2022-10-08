package com.gcsj.service;

import com.gcsj.pojo.SchoolMajor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface SchoolMajorService {
    SchoolMajor selectSchoolMajorBySchool (String schoolCode);
    List<SchoolMajor>  selectSchoolMajorByMajor (String majorCode);
}
