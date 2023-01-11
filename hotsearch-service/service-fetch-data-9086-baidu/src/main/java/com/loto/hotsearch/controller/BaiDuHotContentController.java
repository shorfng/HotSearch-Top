package com.loto.hotsearch.controller;

import com.loto.hotsearch.model.dto.BaiDuHotContentDto;
import com.loto.hotsearch.service.BaiDuHotContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 蓝田_Loto
 * @since 2023-01-01
 */
@RestController
@RequestMapping("/baiDuHotContent")
public class BaiDuHotContentController {
    @Autowired
    private BaiDuHotContentService baiDuHotContentService;

    @GetMapping("/catchDataFromBaiDuHotContent")
    public String catchDataFromBaiDuHotContent() throws IOException {
        Integer baiDuHotContentSize = baiDuHotContentService.getDataFromBaiDuHotContent();

        return "数据库入库，本次总计：" + baiDuHotContentSize + "条";
    }

    @GetMapping("/selectBaiDuHotContent")
    public List<BaiDuHotContentDto> selectBaiDuHotContent() {
        return baiDuHotContentService.selectBaiDuHotContent();
    }
}

