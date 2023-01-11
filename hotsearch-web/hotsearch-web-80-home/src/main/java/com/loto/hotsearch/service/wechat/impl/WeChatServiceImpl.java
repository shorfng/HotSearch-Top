package com.loto.hotsearch.service.wechat.impl;

import com.loto.hotsearch.controller.WeChatBasicController;
import com.loto.hotsearch.service.wechat.WeChatService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * PageName：WeChatServiceImpl.java<p>
 * Date：2023-01-11 10:12<p>
 * Function：微信通用方法实现类
 *
 * @author 蓝田_Loto
 */

@Service
public class WeChatServiceImpl implements WeChatService {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    WeChatBasicController weChatBasicController;

    /**
     * 微信通用方法 - 获取 AccessToken
     *
     * @return
     */
    @Override
    public String getAccessToken() {
        // 从 Redis 取 AccessToken
        String accessToken = redisTemplate.opsForValue().get("accessToken");

        // 如果没有，就调接口
        if (StringUtils.isNoneBlank(accessToken)) {
            accessToken = weChatBasicController.getAccessToken();
        }

        return accessToken;
    }
}
