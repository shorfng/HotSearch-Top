package com.loto;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author 蓝田_Loto
 */
@SpringBootApplication
@ComponentScan("com.loto.hotsearch")
@MapperScan("com.loto.hotsearch.dao.mapper.**")
public class HotSearchTopWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(HotSearchTopWebApplication.class, args);
    }
}
