package com.loto.hotsearch.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * PageName：NacosPropertiesConfig.java<p>
 * Date：2023-01-09 23:59<p>
 * Function：Nacos 属性配置项
 *
 * @author 蓝田_Loto
 */

@Component
@Data
@RefreshScope
public class NacosPropertiesConfig {
    /**
     * 微信接口 - 获取access_token填写client_credential
     */
    @Value("${weChat.grant_type}")
    private String grantType;

    /**
     * 微信接口 - 第三方用户唯一凭证
     */
    @Value("${weChat.appid}")
    private String appId;

    /**
     * 微信接口 - 第三方用户唯一凭证密钥，即appsecret
     */
    @Value("${weChat.secret}")
    private String secret;
}
