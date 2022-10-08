package com.gcsj.controller;

import com.alibaba.fastjson.JSONObject;
import com.gcsj.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/test")
public class HelloController {
    
    @GetMapping("/hello")
    @ResponseBody
    @ApiOperation("hello测试")
    public String hello() {
        return "hello，不太聪明可达鸭";
    }

}
