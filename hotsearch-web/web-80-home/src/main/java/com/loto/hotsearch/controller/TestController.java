package com.loto.hotsearch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * PageName：TestController.java<p>
 * Date：2022-12-31 16:49<p>
 * Function：
 *
 * @author 蓝田_Loto
 */
@Controller
@RequestMapping("/test")
public class TestController {
    //@Autowired
    //IdGenerator idGenerator;
    //
    //@ResponseBody
    //@GetMapping("/hello")
    //public String hello() {
    //    return "hello:" + idGenerator.nextId();
    //}

    @GetMapping("/index")
    public String index() {
        return "index";
    }
}
