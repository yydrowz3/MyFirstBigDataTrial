package com.gcsj.service.impl;

import com.gcsj.mapper.ProEnrInfoMapper;
import com.gcsj.pojo.ProEnrInfo;
import com.gcsj.service.ProEnrInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProEnrInfoServiceImpl implements ProEnrInfoService {

    @Autowired
    ProEnrInfoMapper proEnrInfoMapper;

    public ProEnrInfo selectByProvince(String name){
        return proEnrInfoMapper.selectByProvince(name);
    }

    public List<ProEnrInfo> selectAllProvince(){return proEnrInfoMapper.selectAllProvince();}
}
