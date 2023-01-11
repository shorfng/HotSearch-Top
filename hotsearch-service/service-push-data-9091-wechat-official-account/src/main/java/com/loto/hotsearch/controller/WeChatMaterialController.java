package com.loto.hotsearch.controller;

import com.loto.hotsearch.service.WeChatMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * PageName：WeChatMaterialController.java<p>
 * Date：2023-01-09 20:24<p>
 * Function：微信素材管理接口
 *
 * @author 蓝田_Loto
 */

@RestController
@RequestMapping("/weChatMaterial")
public class WeChatMaterialController {
    @Autowired
    WeChatMaterialService weChatMaterialService;

    /**
     * 微信素材管理接口 - 新增临时素材
     *
     * @return
     */
    @PostMapping("/uploadTemp")
    public String uploadTemp() {
        return weChatMaterialService.uploadTemp();
    }
}
