package com.gcsj.service;

import com.gcsj.pojo.PopularMajor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PopularMajorService {

    List<PopularMajor> selectPMByRanking(int ranking);//根据ranking查询热门专业

    int updataPM(PopularMajor popularMajor);
}
