package com.loto.hotsearch.dao.mapper.snow;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.loto.hotsearch.dao.entity.snow.SnowflakeWorker;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author 蓝田_Loto
 */
@Repository
public interface SnowflakeWorkerMapper extends BaseMapper<SnowflakeWorker> {
    /**
     * 创建雪花工作者
     *
     * @param create 雪花工作者创建
     * @return 创建行数
     */
    Integer create(@Param("create") SnowflakeWorker create);

    /**
     * 获取我的工作者标识
     *
     * @param moduleName  模块名称
     * @param hostAddress 主机地址
     * @return 工作者标识
     */
    Long getMyWorkerId(@Param("moduleName") String moduleName, @Param("hostAddress") String hostAddress);
}
