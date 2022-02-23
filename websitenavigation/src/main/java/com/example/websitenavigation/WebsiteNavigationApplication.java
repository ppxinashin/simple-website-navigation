package com.example.websitenavigation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.websitenavigation.mapper")
public class WebsiteNavigationApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebsiteNavigationApplication.class, args);
    }

}
