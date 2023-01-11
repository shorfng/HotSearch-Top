package com.loto.hotsearch.service.wechat.impl;

import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSONObject;
import com.loto.hotsearch.common.constant.WeChatConstant;
import com.loto.hotsearch.service.wechat.WeChatMaterialService;
import com.loto.hotsearch.service.wechat.WeChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * PageName：WeChatMaterialServiceImpl.java<p>
 * Date：2023-01-09 20:28<p>
 * Function：微信素材管理接口实现类
 *
 * @author 蓝田_Loto
 */

@Service
public class WeChatMaterialServiceImpl implements WeChatMaterialService {
    @Autowired
    WeChatService weChatService;

    @Override
    public String uploadTemp() {
        // 获取 AccessToken
        String accessToken = weChatService.getAccessToken();

        // 调用http
        String url = WeChatConstant.URL_PREFIX + "/media/upload?access_token=" + accessToken + "&type=" + "appId";
        HttpRequest request = HttpRequest.get(url);
        String response = request.execute().body();

        // 响应处理
        JSONObject jsonObject = JSONObject.parseObject(response);
        String errCode = jsonObject.getString("errcode");
        if ("40164".equals(errCode)) {
            return "调用接口的 IP 地址不在白名单中，请在接口 IP 白名单中进行设置。";
        } else {
            String mediaId = jsonObject.getString("media_id");
            return mediaId;
        }
    }
}
