package com.loto.hotsearch.service.wechat.impl;

import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSONObject;
import com.loto.hotsearch.common.constant.WeChatConstant;
import com.loto.hotsearch.service.wechat.WeChatBasicService;
import org.springframework.stereotype.Service;

/**
 * PageName：WeChatBasicServiceImpl.java<p>
 * Date：2023-01-09 20:10<p>
 * Function：微信基础接口实现类
 *
 * @author 蓝田_Loto
 */

@Service
public class WeChatBasicServiceImpl implements WeChatBasicService {
    /**
     * 微信基础接口 - 获取 Access token
     *
     * @param grantType 获取access_token填写client_credential
     * @param appId     第三方用户唯一凭证
     * @param secret    第三方用户唯一凭证密钥，即appsecret
     * @return Access token
     */
    @Override
    public String getAccessToken(String grantType, String appId, String secret) {
        // 调用http
        String url = WeChatConstant.URL_PREFIX + "/token?grant_type=" + grantType + "&appid=" + appId + "&secret=" + secret;
        HttpRequest request = HttpRequest.get(url);
        String response = request.execute().body();

        // 响应处理
        JSONObject jsonObject = JSONObject.parseObject(response);
        return jsonObject.getString("access_token");
    }
}
