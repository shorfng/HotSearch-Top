package com.loto.hotsearch.init;

import com.loto.hotsearch.config.NacosPropertiesConfig;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * PageName：RedissonLock.java<p>
 * Date：2022-06-30 16:20<p>
 * Function：Redis锁
 *
 * @author 蓝田_Loto
 */

@Configuration
public class RedissonLock {
    @Autowired
    private NacosPropertiesConfig nacosPropertiesConfig;

    /**
     * 用于创建锁、解锁
     *
     * @return
     */
    @Bean
    public RedissonClient redissonClient() {
        // 创建Config
        Config config = new Config();

        // 集群实现
        //config.useClusterServers()
        //        .setScanInterval(2000)
        //        .addNodeAddress(
        //                "redis://192.168.126.200:7001",
        //                "redis://192.168.126.200:7002",
        //                "redis://192.168.126.200:7003",
        //                "redis://192.168.126.200:7004",
        //                "redis://192.168.126.200:7005",
        //                "redis://192.168.126.200:7006");

        // 单机实现
        //config.useSingleServer().setAddress("redis://192.168.126.200:6379");
        config.useSingleServer().setAddress("redis://" + nacosPropertiesConfig.getRedisAddress());

        // 创建 RedissonClient
        return Redisson.create(config);
    }
}
