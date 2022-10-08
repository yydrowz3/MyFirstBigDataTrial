package com.gcsj.service;

import com.gcsj.pojo.SourceInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SourceInfoService {
    SourceInfo selectSourceInfoByArea(String area);

    List<SourceInfo> selectSourceInfo();
}
