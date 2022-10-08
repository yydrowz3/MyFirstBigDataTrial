package com.gcsj.service.impl;

import com.gcsj.mapper.ProvinceMapper;
import com.gcsj.pojo.Province;
import com.gcsj.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProvinceServiceImpl implements ProvinceService {

    @Autowired
    ProvinceMapper provinceMapper;

    @Override
    public Province selectByProvinceName(String provincename) {
        return provinceMapper.selectByProvinceName(provincename);
    }
}
