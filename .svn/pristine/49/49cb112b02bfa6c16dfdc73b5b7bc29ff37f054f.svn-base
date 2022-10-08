package com.gcsj.controller;

import com.alibaba.fastjson.JSONObject;
import com.gcsj.mapper.RegionProvinceMapper;
import com.gcsj.pojo.*;

import com.gcsj.service.*;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
public class ShowController {
    @Autowired
    PopularMajorService popularMajorService;

    @Autowired
    UnPopularMajorService unPopularMajorService;

    @Autowired
    ProEnrInfoService proEnrInfoService;

    @Autowired
    MajorService majorService;

    @Autowired
    RegionProvinceService regionProvinceService;

    @Autowired
    SourceInfoService sourceInfoService;



    @ApiOperation(value="查询热门专业")
    @GetMapping("/selectPMByRanking")
    public Object selectPMByRanking(){//根据ranking查询热门专业，默认为前10，可修改
        JSONObject jsonObject = new JSONObject();
        List<PopularMajor> list = popularMajorService.selectPMByRanking(10);
        List<Major> mjlist;
        PopularMajor pm = new PopularMajor();
        Major mj = new Major();
        //System.out.println("进入循环");
        for(int i = 0; i < 10; i++)
        {
            pm = list.get(i);
           // System.out.println("第"+i+"次");
           // System.out.println("拿到pm");
           // System.out.println(pm);
            mjlist = majorService.selectMajorByCode(pm.getMajorCode());
           // System.out.println("拿到mjlist");
           // System.out.println(mjlist);
            pm.setMajorName(mjlist.get(0).getProfess());
            list.set(i,pm);
        }
        //System.out.println(list.get(0));
        jsonObject.put("code", 200);
        jsonObject.put("data",list);
        return jsonObject;
    }

    @ApiOperation(value="查询冷门专业")
    @GetMapping("/selectUPMByRanking")
    public Object selectUPMByRanking(){//根据ranking查询冷门专业，默认为前10，可修改
        JSONObject jsonObject = new JSONObject();
        List<UnPopularMajor> list = unPopularMajorService.selectUPMByRanking(10);
        List<Major> mjlist;
        UnPopularMajor upm = new UnPopularMajor();
        Major mj = new Major();
        for(int i = 0; i < 10; i++)
        {
            upm = list.get(i);
             //System.out.println("第"+i+"次");
             //System.out.println("拿到upm");
            // System.out.println(upm);
            mjlist = majorService.selectMajorByCode(upm.getMajorCode());
            // System.out.println("拿到mjlist");
             //System.out.println(mjlist);
            upm.setMajorName(mjlist.get(0).getProfess());
            list.set(i,upm);
        }
        //System.out.println(list.get(0));
        jsonObject.put("code", 200);
        jsonObject.put("msg", "冷门专业");
        jsonObject.put("data",list);
        return jsonObject;
    }

    @ApiOperation(value="根据省份名称查询省份计划招生人数")
    @GetMapping("/selectByProvince")
    public Object selectByProvince(String name){
        JSONObject jsonObject = new JSONObject();
//        System.out.println(name);
        ProEnrInfo info = proEnrInfoService.selectByProvince(name);
//        System.out.println(info);
        jsonObject.put("code", 200);
        jsonObject.put("data",info);
        return jsonObject;
    }

    @ApiOperation(value="查询所有省份计划招生人数")
    @GetMapping("/selectAllProvince")
    public Object selectByProvince(){
        JSONObject jsonObject = new JSONObject();
        List<ProEnrInfo> info = proEnrInfoService.selectAllProvince();

        jsonObject.put("code", 200);
   
        jsonObject.put("data", info);
        return jsonObject;
    }

   
    @ApiOperation(value="根据区域名称查询计划招生人数")
	@GetMapping("/selectSourceInfoByArea")//根据区域名称查询计划招生人数
    public Object selectSourceInfoByArea(String area){
        JSONObject jsonObject = new JSONObject();
//        System.out.println(area);
        SourceInfo info = sourceInfoService.selectSourceInfoByArea(area);
//        System.out.println(info);
        jsonObject.put("code", 200);
        jsonObject.put("data",info);
        return jsonObject;
    }

    @ApiOperation(value="根据省份查区域")
    @GetMapping("/selectRegByProvince")
    public Object selectRegByProvince(String province)
    {
        JSONObject jsonObject = new JSONObject();
//        System.out.println(province);
        RegionProvince rp = regionProvinceService.selectRegByProvince(province);
        jsonObject.put("area",rp.getRegionName());
        return jsonObject;
    }
    @ApiOperation(value="查询所有区域的招生人数")
    @GetMapping("/selectSourceInfo")
    public Object selectSourceInfo(){
        JSONObject jsonObject = new JSONObject();
//        System.out.println("下一步是Service");
        List<SourceInfo> info = sourceInfoService.selectSourceInfo();
//        System.out.println(info);
        jsonObject.put("code", 200);
        jsonObject.put("data",info);
        return jsonObject;
    }

    @ApiOperation(value="修改热门专业")
    @PostMapping("/updataPM")
    public Object updataPM(PopularMajor popularMajor){
        JSONObject jsonObject = new JSONObject();
        System.out.println(popularMajor);
        popularMajorService.updataPM(popularMajor);
        jsonObject.put("code",200);
        jsonObject.put("msg","修改成功");
        return jsonObject;
    }

    @ApiOperation(value="修改冷门专业")
    @PostMapping("/updataUPM")
    public Object updataUPM(UnPopularMajor unPopularMajor){
        JSONObject jsonObject = new JSONObject();
        System.out.println(unPopularMajor);
        unPopularMajorService.updataUPM(unPopularMajor);
        jsonObject.put("code",200);
        jsonObject.put("msg","修改成功");
        return jsonObject;
    }
}
