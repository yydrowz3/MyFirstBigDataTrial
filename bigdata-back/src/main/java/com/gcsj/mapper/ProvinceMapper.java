package com.gcsj.mapper;

import com.gcsj.pojo.Province;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProvinceMapper {

    Province selectByProvinceName(String provincename);

}
