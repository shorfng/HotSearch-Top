package com.loto.hotsearch.model.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * PageName：BaiDuHotContentDto.java<p>
 * Date：2023-01-01 4:12<p>
 * Function：
 *
 * @author 蓝田_Loto
 */

@Data
public class BaiDuHotContentDto {
    private String url;

    private String desc1;

    private String hotScore;

    private String hotTag;

    private String img;

    private String index1;

    private String query1;

    private String isTop;

    /**
     * 主键
     */
    private Long id;

    private Long infoId;


}
