package com.loto.hotsearch;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 蓝田_Loto
 */
@SpringBootApplication
@MapperScan("com.loto.hotsearch.dao.mapper.**")
public class HotSearchTopWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(HotSearchTopWebApplication.class, args);
    }
}
