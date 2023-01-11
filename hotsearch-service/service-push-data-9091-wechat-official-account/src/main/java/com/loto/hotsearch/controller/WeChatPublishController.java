package com.loto.hotsearch.controller;

import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * PageName：WeChatPublishController.java<p>
 * Date：2023-01-08 23:30<p>
 * Function：
 *
 * @author 蓝田_Loto
 */
@RestController
@RequestMapping("/weChat")
public class WeChatPublishController {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @PostMapping("/publish")
    public String publish(String mediaId) {
        // 从 Redis 取 AccessToken，如果没有，就调接口
        String accessToken = redisTemplate.opsForValue().get("accessToken");

        // https://developers.weixin.qq.com/doc/offiaccount/Publish/Publish.html
        String url = "https://api.weixin.qq.com/cgi-bin/freepublish/submit?access_token=" + accessToken;

        // json参数传入
        JSONObject param_json = new JSONObject();
        param_json.put("media_id", mediaId);
        //param_json.put("media_id", "7SB_U-O565bF12pYCBfwZ64hn5RUZ0iNqbsdCru8eRjkBz_l_Bvm_fKxykUvQgon");


        // 调用http
        HttpRequest request = HttpRequest.post(url).body(JSONObject.toJSONString(param_json));
        String response = request.execute().body();

        System.out.println(mediaId);
        System.out.println(response);
        return response;
    }

    // 3、根据标签进行群发【订阅号与服务号认证后均可用】
    // https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Batch_Sends_and_Originality_Checks.html#_3%E3%80%81%E6%A0%B9%E6%8D%AE%E6%A0%87%E7%AD%BE%E8%BF%9B%E8%A1%8C%E7%BE%A4%E5%8F%91%E3%80%90%E8%AE%A2%E9%98%85%E5%8F%B7%E4%B8%8E%E6%9C%8D%E5%8A%A1%E5%8F%B7%E8%AE%A4%E8%AF%81%E5%90%8E%E5%9D%87%E5%8F%AF%E7%94%A8%E3%80%91
    // http请求方式: POST https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token=ACCESS_TOKEN
    // is_to_all	否	用于设定是否向全部用户发送，值为 true 或false，选择 true 该消息群发给所有用户，选择 false 可根据tag_id发送给指定群组的用户
}
