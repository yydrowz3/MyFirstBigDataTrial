package com.gcsj.service.impl;

import com.gcsj.mapper.PopularMajorMapper;
import com.gcsj.pojo.PopularMajor;
import com.gcsj.service.PopularMajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PopularMajorServiceImpl implements PopularMajorService {

    @Autowired
    PopularMajorMapper popularMajorMapper;

    public List<PopularMajor> selectPMByRanking(int ranking){
        return popularMajorMapper.selectPMByRanking(ranking);
    };

    public int updataPM(PopularMajor popularMajor){
        return popularMajorMapper.updataPM(popularMajor);
    };
}
