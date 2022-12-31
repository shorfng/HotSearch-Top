package com.loto.hotsearch.controller;

import com.loto.hotsearch.service.snow.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * PageName：TestController.java<p>
 * Date：2022-12-31 16:49<p>
 * Function：
 *
 * @author 蓝田_Loto
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    IdGenerator idGenerator;

    @GetMapping("/hello")
    public String hello() {
        return "hello:" + idGenerator.nextId();
    }
}
