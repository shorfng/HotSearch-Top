package com.loto.hotsearch.controller;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.alibaba.fastjson.JSONObject;
import com.loto.hotsearch.common.constant.WeiXinConstant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * PageName：WeiXinBasicController.java<p>
 * Date：2023-01-09 19:02<p>
 * Function：微信基础接口
 *
 * @author 蓝田_Loto
 */

@RestController
@RequestMapping("/weChatBasic")
public class WeiXinBasicController {
    /**
     * 微信基础接口 - 获取 Access token
     * @param grantType 获取access_token填写client_credential
     * @param appId 第三方用户唯一凭证
     * @param secret 第三方用户唯一凭证密钥，即appsecret
     * @return Access token
     */
    @GetMapping("/getAccessToken")
    public String getAccessToken(@RequestParam(value = "grant_type") String grantType, @RequestParam(value = "appid") String appId, String secret) {
        // 调用http
        String url = WeiXinConstant.URL_PREFIX + "/token?grant_type=" + grantType + "&appid=" + appId + "&secret=" + secret;
        HttpRequest request = HttpRequest.get(url);
        String response = request.execute().body();

        // 响应处理
        JSONObject jsonObject = JSONObject.parseObject(response);
        return jsonObject.getString("access_token");
    }
}
