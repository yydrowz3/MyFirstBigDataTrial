package com.gcsj.service.impl;

import com.gcsj.mapper.EnrInfoMapper;
import com.gcsj.pojo.EnrollmentInfo;
import com.gcsj.pojo.User;
import com.gcsj.service.EnrInfoService;
import com.gcsj.vo.PageRequest;
import com.gcsj.vo.PageResult;
import com.gcsj.vo.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EnrInfoServiceImpl implements EnrInfoService{

    @Autowired
    EnrInfoMapper enrInfoMapper;

    @Override
    public PageResult selectEnrInfoListBy(PageRequest pageRequest, EnrollmentInfo enrollmentInfo){

        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest,enrollmentInfo));
    }

    @Override
    public PageResult selectMajorListBy(PageRequest pageRequest,String schoolName,String province,boolean isDesc){
        return PageUtils.getPageResult(pageRequest, getPageInfo2(pageRequest,schoolName,province,isDesc));
    }


    public PageInfo<EnrollmentInfo> getPageInfo(PageRequest pageRequest, EnrollmentInfo enrollmentInfo) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
//        System.out.println(pageNum);
//        System.out.println(pageSize);
        PageHelper.startPage(pageNum,pageSize);

        List<EnrollmentInfo> enrollmentInfos = enrInfoMapper.selectEnrInfoListByPage(enrollmentInfo);
//        System.out.println(enrollmentInfo);
//        System.out.println(enrollmentInfos);
        PageInfo<EnrollmentInfo> pageInfo = new PageInfo<>(enrollmentInfos);

        return pageInfo;
    }

    public PageInfo<EnrollmentInfo> getPageInfo2(PageRequest pageRequest,String schoolName,String province,boolean isDesc) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum,pageSize);
        List<EnrollmentInfo> enrollmentInfos = null;
        if (isDesc){
            enrollmentInfos = enrInfoMapper.selectByMajorListByPage(schoolName,province,"desc");
        }else {
            enrollmentInfos = enrInfoMapper.selectByMajorListByPage(schoolName,province,null);
        }
        PageInfo<EnrollmentInfo> pageInfo2 = new PageInfo<>(enrollmentInfos);
        return pageInfo2;
    }

}
