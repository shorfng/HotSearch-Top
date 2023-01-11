package com.loto.hotsearch.controller;

import com.loto.hotsearch.service.WeChatBasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * PageName：WeChatBasicController.java<p>
 * Date：2023-01-09 19:02<p>
 * Function：微信基础接口
 *
 * @author 蓝田_Loto
 */

@RestController
@RequestMapping("/weChatBasic")
public class WeChatBasicController {
    @Autowired
    WeChatBasicService weChatBasicService;

    /**
     * 微信基础接口 - 获取 Access token
     * @return Access token
     */
    @GetMapping("/getAccessToken")
    public String getAccessToken() {
        return weChatBasicService.getAccessToken();
    }
}
