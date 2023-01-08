package com.loto.hotsearch.dao.entity.baidu;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author 蓝田_Loto
 * @since 2023-01-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("bai_du_hot_content")
public class BaiDuHotContent implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("url")
    private String url;

    @TableField("desc1")
    @JSONField(alternateNames = "desc")
    private String desc1;

    @TableField("hot_score")
    private String hotScore;

    @TableField("hot_tag")
    private String hotTag;

    @TableField("img")
    private String img;

    @TableField("index1")
    @JSONField(alternateNames = "index")
    private String index1;

    @TableField("query1")
    @JSONField(alternateNames = "query")
    private String query1;

    @TableField("is_top")
    private String isTop;

    /**
     * 主键
     */
    @TableId("id")
    private Long id;

    @TableField("info_id")
    private Long infoId;


}
