package com.loto.hotsearch.service.baidu.impl;

import com.alibaba.fastjson.JSONObject;
import com.loto.hotsearch.dao.entity.baidu.BaiDuHotContent;
import com.loto.hotsearch.dao.entity.baidu.BaiDuHotInfo;
import com.loto.hotsearch.dao.mapper.baidu.BaiDuHotContentMapper;
import com.loto.hotsearch.model.dto.BaiDuHotContentDto;
import com.loto.hotsearch.service.baidu.BaiDuHotContentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.loto.hotsearch.service.baidu.BaiDuHotInfoService;
import com.loto.hotsearch.service.snow.IdGenerator;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 蓝田_Loto
 * @since 2023-01-01
 */
@Service
public class BaiDuHotContentServiceImpl extends ServiceImpl<BaiDuHotContentMapper, BaiDuHotContent> implements BaiDuHotContentService {
    @Autowired
    private BaiDuHotInfoService baiDuHotInfoService;

    @Autowired
    private IdGenerator idGenerator;

    @Override
    public Integer getDataFromBaiDuHotContent() throws IOException {
        HttpGet request = new HttpGet("https://top.baidu.com/board?tab=realtime");
        HttpResponse response = HttpClients.createDefault().execute(request);
        String contentTemp = EntityUtils.toString(response.getEntity(), "gbk");

        String[] split = contentTemp.split("data:\\{\"data\":\\{\"cards\":");
        String baiDuDataTemp = split[1];

        String[] baiDuDataArr = baiDuDataTemp.split(",\\\"curBoardName\\\"");
        String baiDuDataStr = baiDuDataArr[0];
        System.out.println("baiDuHotContentStr:" + baiDuDataStr);

        List<BaiDuHotInfo> baiDuHotInfoList = JSONObject.parseArray(baiDuDataStr, BaiDuHotInfo.class);
        System.out.println("大小" + baiDuHotInfoList.size());

        int count = 0;
        // 百度热搜榜信息
        for (BaiDuHotInfo baiDuHotInfo : baiDuHotInfoList) {
            baiDuHotInfo.setId(idGenerator.nextId());
            // 1、百度热搜榜信息 - 入库
            baiDuHotInfoService.save(baiDuHotInfo);

            // 百度热搜榜信息详情列表
            String content = baiDuHotInfo.getContent();
            List<BaiDuHotContent> baiDuHotContentList = JSONObject.parseArray(content, BaiDuHotContent.class);
            for (BaiDuHotContent baiDuHotContent : baiDuHotContentList) {
                baiDuHotContent.setId(idGenerator.nextId());

                baiDuHotContent.setInfoId(baiDuHotInfo.getId());
                count++;
            }
            // 2、百度热搜榜信息详情列表 - 入库
            this.saveBatch(baiDuHotContentList);
            System.out.println("baiDuHotContentList:" + baiDuHotContentList);
        }
        return count;
    }

    @Override
    public List<BaiDuHotContentDto> selectBaiDuHotContent() {
        List<BaiDuHotContent> baiDuHotContentList = this.list();

        List<BaiDuHotContentDto> resultList = new ArrayList<>();
        for (BaiDuHotContent baiDuHotContent : baiDuHotContentList) {
            BaiDuHotContentDto baiDuHotContentDto = new BaiDuHotContentDto();
            BeanUtils.copyProperties(baiDuHotContent, baiDuHotContentDto);
            resultList.add(baiDuHotContentDto);
        }

        return resultList;
    }
}
