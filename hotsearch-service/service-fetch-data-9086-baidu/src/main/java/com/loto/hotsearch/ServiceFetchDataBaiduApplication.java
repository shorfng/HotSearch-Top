package com.loto.hotsearch;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * PageName：ServiceFetchDataBaiduApplication.java<p>
 * Date：2023-01-11 20:20<p>
 * Function：数据抓取 - 百度
 *
 * @author 蓝田_Loto
 */

@SpringBootApplication
@MapperScan("com.loto.hotsearch.mapper.**.**")
public class ServiceFetchDataBaiduApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceFetchDataBaiduApplication.class, args);
    }
}
