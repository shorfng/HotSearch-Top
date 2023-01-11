package com.loto.hotsearch.controller;

import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.loto.hotsearch.common.constant.WeChatConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * PageName：WeChatDraftController.java<p>
 * Date：2023-01-09 19:58<p>
 * Function：微信草稿箱接口
 *
 * @author 蓝田_Loto
 */

@RestController
@RequestMapping("/weChatDraft")
public class WeChatDraftController {
    @Autowired
    WeChatPublishController weChatPublishController;

    /**
     * 微信草稿箱接口 - 新建草稿
     *
     * @return
     */
    @PostMapping("/addDraft")
    public void addDraft() {
        // https://developers.weixin.qq.com/doc/offiaccount/Draft_Box/Add_draft.html
        String url = WeChatConstant.URL_PREFIX + "/draft/add?access_token=64_o2hujbAvF2SXY9R3NXBXxBg42f-4OSCKYnaXYCvDOCLBoggGy-oCypJad-U0a57XY9TR2Xu06YWd_LoACIFVTRQu7jpf7jHHzFb0YLUWwlSXaeYS1Gdmb648dzwYSVgAJASMP";

        // json参数传入
        JSONObject param_json = new JSONObject();
        JSONArray articles = new JSONArray();
        JSONObject oneArticle = new JSONObject();
        oneArticle.put("title", "今日热点搜索3");
        oneArticle.put("author", "蓝田_Loto");
        oneArticle.put("digest", null);
        oneArticle.put("content", "content");
        //oneArticle.put("content_source_url", );
        oneArticle.put("thumb_media_id", "7SB_U-O565bF12pYCBfwZ_XFw7_kdxOJ5kw1W6RRBYMb8riY_7bWtR78LoiV_8Qf");
        oneArticle.put("need_open_comment", 0);
        oneArticle.put("only_fans_can_comment", 0);
        articles.add(oneArticle);
        param_json.put("articles", articles);

        // 调用http
        HttpRequest request = HttpRequest.post(url).body(JSONObject.toJSONString(param_json));
        String response = request.execute().body();
        System.out.println(response);

        JSONObject jsonObject = JSONObject.parseObject(response);
        String mediaId = jsonObject.getString("media_id");
        // 发布
        weChatPublishController.publish(mediaId);
        //return mediaId;
    }

}
