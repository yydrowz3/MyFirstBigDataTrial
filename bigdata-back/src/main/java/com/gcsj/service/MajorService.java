package com.gcsj.service;

import com.gcsj.pojo.Major;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MajorService {

    List<Major> selectMajorByName(String profess);
    List<Major> selectMajorByCode(String majorCode);





}
