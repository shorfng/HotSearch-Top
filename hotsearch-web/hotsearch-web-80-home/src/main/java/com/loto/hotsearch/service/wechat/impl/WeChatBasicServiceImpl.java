package com.loto.hotsearch.service.wechat.impl;

import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSONObject;
import com.loto.hotsearch.common.constant.WeChatConstant;
import com.loto.hotsearch.config.NacosPropertiesConfig;
import com.loto.hotsearch.service.wechat.WeChatBasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * PageName：WeChatBasicServiceImpl.java<p>
 * Date：2023-01-09 20:10<p>
 * Function：微信基础接口实现类
 *
 * @author 蓝田_Loto
 */

@Service
public class WeChatBasicServiceImpl implements WeChatBasicService {
    @Autowired
    NacosPropertiesConfig nacosPropertiesConfig;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 微信基础接口 - 获取 Access token
     *
     * @return Access token
     */
    @Override
    public String getAccessToken() {
        // 调用http
        String url = WeChatConstant.URL_PREFIX + "/token?grant_type=" + nacosPropertiesConfig.getGrantType() + "&appid=" + nacosPropertiesConfig.getAppId() + "&secret=" + nacosPropertiesConfig.getSecret();
        HttpRequest request = HttpRequest.get(url);
        String response = request.execute().body();

        // 响应处理
        JSONObject jsonObject = JSONObject.parseObject(response);
        String errCode = jsonObject.getString("errcode");
        if ("40164".equals(errCode)) {
            return "调用接口的 IP 地址不在白名单中，请在接口 IP 白名单中进行设置。";
        } else {
            String accessToken = jsonObject.getString("access_token");
            long expiresIn = Long.parseLong(jsonObject.getString("expires_in"));

            // 把 AccessToken 存入 Redis，并设置过期时间
            redisTemplate.opsForValue().set("accessToken", accessToken, expiresIn, TimeUnit.SECONDS);
            return accessToken;
        }
    }
}
