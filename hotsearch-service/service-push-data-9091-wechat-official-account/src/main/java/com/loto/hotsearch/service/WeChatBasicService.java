package com.loto.hotsearch.service;

/**
 * PageName：WeChatBasicService.java<p>
 * Date：2023-01-09 20:10<p>
 * Function：微信基础接口
 *
 * @author 蓝田_Loto
 */

public interface WeChatBasicService {
    /**
     * 微信基础接口 - 获取 Access token
     * @return Access token
     */
    String getAccessToken();
}
