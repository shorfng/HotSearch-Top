package com.loto.hotsearch.entity.snow;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 雪花工作者表
 * @author 蓝田_Loto
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_snowflake_worker")
public class SnowflakeWorker implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 雪花标识
     */
    @TableField("id")
    private Long id;

    /**
     * 模块名称
     */
    @TableId(value = "module_name", type = IdType.INPUT)
    private String moduleName;

    /**
     * 主机地址
     */
    @TableField("host_address")
    private String hostAddress;

    /**
     * 创建时间
     */
    @TableField("created_time")
    private Date createdTime;

    /**
     * 修改时间
     */
    @TableField("modified_time")
    private Date modifiedTime;
}
