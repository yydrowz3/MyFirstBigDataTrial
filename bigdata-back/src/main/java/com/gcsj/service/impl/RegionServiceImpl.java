package com.gcsj.service.impl;


import com.gcsj.mapper.RegionMapper;
import com.gcsj.pojo.Region;
import com.gcsj.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegionServiceImpl implements RegionService {
    @Autowired
    RegionMapper regionMapper;

    @Override
    public Region selectByRegionName(String regionName) {
        return regionMapper.selectByRegionName(regionName);
    }
}
