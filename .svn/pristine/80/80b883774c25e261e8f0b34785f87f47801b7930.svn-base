package com.gcsj;

import com.gcsj.mapper.SchoolMajorMapper;
import com.gcsj.pojo.SchoolMajor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BigdataBackApplicationTests {

    @Autowired
    SchoolMajorMapper schoolMajorMapper;

    @Test
    void contextLoads() {

        List<SchoolMajor> schoolMajors = schoolMajorMapper.selectSchoolMajorByMajor("6202");
        for (SchoolMajor schoolMajor : schoolMajors) {
            System.out.println(schoolMajor);
        }
    }

}
