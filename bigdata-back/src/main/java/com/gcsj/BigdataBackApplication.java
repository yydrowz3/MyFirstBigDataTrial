package com.gcsj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.gcsj.mapper")
public class BigdataBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(BigdataBackApplication.class, args);
    }

}
