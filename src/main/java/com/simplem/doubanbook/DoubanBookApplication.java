package com.simplem.doubanbook;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan(value = "com.simplem.doubanbook.mapper")
public class DoubanBookApplication {

    public static void main(String[] args) {
        SpringApplication.run(DoubanBookApplication.class, args);
    }

}
