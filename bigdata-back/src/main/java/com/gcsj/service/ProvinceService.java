package com.gcsj.service;

import com.gcsj.pojo.Province;
import org.springframework.stereotype.Service;

@Service
public interface ProvinceService {

    Province selectByProvinceName(String provincename);
}
