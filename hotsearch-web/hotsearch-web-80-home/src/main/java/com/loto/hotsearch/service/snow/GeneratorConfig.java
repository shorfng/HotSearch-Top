package com.loto.hotsearch.service.snow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 雪花生成器注入参数
 * @author 蓝田_Loto
 */
@Configuration
public class GeneratorConfig {
    /**
     * 工作者标识提供者接口
     */
    @Autowired
    private WorkerIdProvider workerIdProvider;

    /**
     * 注入工作者标识
     */
    @Bean
    public SnowflakeIdGenerator snowflakeIdGenerator() {
        return new SnowflakeIdGenerator(workerIdProvider);
    }
}
