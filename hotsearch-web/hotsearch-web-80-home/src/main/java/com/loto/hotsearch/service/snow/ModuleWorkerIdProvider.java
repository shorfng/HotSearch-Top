package com.loto.hotsearch.service.snow;

import cn.hutool.core.net.NetUtil;
import com.loto.hotsearch.dao.entity.snow.SnowflakeWorker;
import com.loto.hotsearch.dao.mapper.snow.SnowflakeWorkerMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Objects;

/**
 * 模块工作者标识提供者类
 *
 * @author 蓝田_Loto
 */
@Service
public class ModuleWorkerIdProvider implements WorkerIdProvider {
    /**
     * 雪花工作者DAO
     */
    @Autowired
    private SnowflakeWorkerMapper snowflakeWorkerMapper;

    /**
     * 模块名称
     */
    @Value("${module.name:HotSearch-Top-Web}")
    private String moduleName;

    /**
     * 获取工作者标识
     *
     * @return 工作者标识
     */
    @Override
    public long getWorkerId() {
        // 检查模块名称
        Assert.isTrue(StringUtils.isNoneBlank(moduleName), "模块名称未设置");

        // 获取本机地址
        String hostAddress = NetUtil.getLocalhostStr();
        Assert.isTrue(StringUtils.isNoneBlank(hostAddress), "获取本机地址无效");

        // 获取工作者标识
        Long workerId = snowflakeWorkerMapper.getMyWorkerId(moduleName, hostAddress);
        if (Objects.isNull(workerId)) {
            // 创建工作者信息
            SnowflakeWorker workerCreate = new SnowflakeWorker();
            workerCreate.setModuleName(moduleName);
            workerCreate.setHostAddress(hostAddress);
            snowflakeWorkerMapper.create(workerCreate);

            // 获取工作者标识
            workerId = snowflakeWorkerMapper.getMyWorkerId(moduleName, hostAddress);

        }
        Assert.notNull(workerId, "获取工作者标识为空");

        // 返回工作标识
        return workerId.longValue();
    }
}
