package com.gcsj.source.Info;

import java.util.HashMap;
import java.util.Map;

public class Province {

    private String name;//省份名称
    private String area;//所属区域

    private HashMap<String,String> areaProvince;

    public Province(){

    }

    public Province(String name) {

        this.name = name;

        //初始化省份区域对照信息
        areaProvince = new HashMap();
        areaProvince.put("东北", "黑龙江,吉林,辽宁");
        areaProvince.put("华东", "上海,江苏,浙江,安徽,福建,江西,山东,台湾 ");
        areaProvince.put("华北", "北京,天津,山西,河北,内蒙古");
        areaProvince.put("华中", "河南,湖北,湖南");
        areaProvince.put("华南", "广东,广西,海南,香港,澳门");
        areaProvince.put("西南", "四川,贵州,云南,重庆,西藏");
        areaProvince.put("西北", "陕西,甘肃,青海,宁夏,新疆");
        //根据省份名查找并设置区域
        for (Map.Entry<String, String> entry : areaProvince.entrySet()) {
            if(entry.getValue().indexOf(name)!=-1) {
                this.area = entry.getKey();
                break;
            }
        }
    }

    public String getName() {
        return name;
    }



    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public HashMap<String, String> getAreaProvince() {
        return areaProvince;
    }

    public void setAreaProvince(HashMap<String, String> areaProvince) {
        this.areaProvince = areaProvince;
    }
}
