package com.gcsj.service.impl;

import com.gcsj.mapper.SourceInfoMapper;
import com.gcsj.pojo.SourceInfo;
import com.gcsj.service.SourceInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SourceInfoServiceImpl implements SourceInfoService {

    @Autowired
    SourceInfoMapper sourceInfoMapper;

    public SourceInfo selectSourceInfoByArea(String area){
    return sourceInfoMapper.selectSourceInfoByArea(area);
   };

    public List<SourceInfo> selectSourceInfo(){
        return sourceInfoMapper.selectSourceInfo();
    };
}
