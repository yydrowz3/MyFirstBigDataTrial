package com.gcsj.mapper;

import com.gcsj.pojo.ProEnrInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProEnrInfoMapper {
    ProEnrInfo selectByProvince(String name);

    List<ProEnrInfo> selectAllProvince();
}
