package com.loto.hotsearch.service.wechat;

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
     *
     * @param grantType 获取access_token填写client_credential
     * @param appId     第三方用户唯一凭证
     * @param secret    第三方用户唯一凭证密钥，即appsecret
     * @return Access token
     */
    String getAccessToken(String grantType, String appId, String secret);
}
