package com.gcsj.service.impl;


import com.gcsj.mapper.RegionProvinceMapper;
import com.gcsj.pojo.RegionProvince;
import com.gcsj.service.RegionProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionProvinceServiceImpl implements RegionProvinceService {

    @Autowired
    RegionProvinceMapper regionProvinceMapper;

    public List<RegionProvince> selectProByRegionName(String regionName){
        return regionProvinceMapper.selectProByRegionName(regionName);
    }
    public RegionProvince selectRegByProvince(String province){
        return regionProvinceMapper.selectRegByProvince(province);
    }
}
