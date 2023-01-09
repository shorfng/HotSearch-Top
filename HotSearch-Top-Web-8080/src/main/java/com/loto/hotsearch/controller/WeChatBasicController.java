package com.loto.hotsearch.controller;

import com.loto.hotsearch.service.wechat.WeChatBasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
     *
     * @param grantType 获取access_token填写client_credential
     * @param appId     第三方用户唯一凭证
     * @param secret    第三方用户唯一凭证密钥，即appsecret
     * @return Access token
     */
    @GetMapping("/getAccessToken")
    public String getAccessToken(@RequestParam(value = "grant_type") String grantType, @RequestParam(value = "appid") String appId, String secret) {
        return weChatBasicService.getAccessToken(grantType, appId, secret);
    }
}
