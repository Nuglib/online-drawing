package com.sdrc.onlinedrawing;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.sdrc.onlinedrawing.mapper"})
public class OnlineDrawingApplication {
    public static void main(String[] args) {
        SpringApplication.run(OnlineDrawingApplication.class, args);
    }
}