package com.loto.hotsearch.dao.entity.baidu;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

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
@TableName("bai_du_hot_info")
public class BaiDuHotInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("content")
    private String content;

    @TableField("text1")
    @JSONField(alternateNames = "text")
    private String text1;

    @TableField("update_time")
    private Date updateTime;

    @TableId("id")
    private Long id;


}
