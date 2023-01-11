package com.loto.hotsearch.service.baidu;

import com.baomidou.mybatisplus.extension.service.IService;
import com.loto.hotsearch.dao.entity.baidu.BaiDuHotContent;
import com.loto.hotsearch.model.dto.BaiDuHotContentDto;

import java.io.IOException;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 蓝田_Loto
 * @since 2023-01-01
 */
public interface BaiDuHotContentService extends IService<BaiDuHotContent> {
    Integer getDataFromBaiDuHotContent() throws IOException;

    //todo : 表需要添加时间，通过yyyymmdd查
    List<BaiDuHotContentDto> selectBaiDuHotContent();
}
