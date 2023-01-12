package com.loto.hotsearch.generate;

import cn.smallbun.screw.core.Configuration;
import cn.smallbun.screw.core.engine.EngineConfig;
import cn.smallbun.screw.core.engine.EngineFileType;
import cn.smallbun.screw.core.engine.EngineTemplateType;
import cn.smallbun.screw.core.execute.DocumentationExecute;
import cn.smallbun.screw.core.process.ProcessConfig;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * PageName：TableDetailGeneral.java<p>
 * Date：2023-01-12 14:42<p>
 * Function：导出数据库表结构
 *
 * @author 蓝田_Loto
 */

public class TableDetailGeneral {
    public static void main(String[] args) {
        tableDetailGeneral();
    }

    /**
     * 文档生成
     */
    public static void tableDetailGeneral() {
        // 数据源配置
        String dataBaseName = "HotSearch_Top";
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName("com.mysql.jdbc.Driver");
        hikariConfig.setJdbcUrl("jdbc:mysql://localhost:3306/" + dataBaseName + "?useUnicode=true&characterEncoding=utf-8&useSSL=false");
        hikariConfig.setUsername("root");
        hikariConfig.setPassword("root");

        // 数据源连接配置
        hikariConfig.addDataSourceProperty("useInformationSchema", "true");
        hikariConfig.setMinimumIdle(2);
        hikariConfig.setMaximumPoolSize(5);
        DataSource dataSource = new HikariDataSource(hikariConfig);

        // 生成文件的属性配置
        String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        EngineConfig engineConfig = EngineConfig.builder()
                // 生成的文件路径
                .fileOutputDir("D://")
                // 生成文件后，打开目录
                .openOutputDir(true)
                // 生成的文件类型
                //.fileType(EngineFileType.HTML)
                .fileType(EngineFileType.WORD)
                // 生成的文件模板
                .produceType(EngineTemplateType.freemarker)
                // 生成的文件名
                .fileName("数据库 " + dataBaseName + " 的表结构（" + currentDate + "导出）").build();

        // 忽略的表名
        ArrayList<String> ignoreTableName = new ArrayList<>();
        ignoreTableName.add("test_user");
        ignoreTableName.add("test_group");

        // 忽略的表前缀
        ArrayList<String> ignorePrefix = new ArrayList<>();
        ignorePrefix.add("test_");

        // 忽略的表后缀
        ArrayList<String> ignoreSuffix = new ArrayList<>();
        ignoreSuffix.add("_test");

        // 生成指定某几张表的结构
        ArrayList<String> designatedTableName = new ArrayList<>();
        designatedTableName.add("");

        // 生成表的结构，跳过忽略的表
        ProcessConfig processConfig = ProcessConfig.builder()
                // 1、生成指定的表的结构
                // 生成指定某几张表的结构
                //.designatedTableName(designatedTableName)
                // 根据表前缀生成
                .designatedTablePrefix(new ArrayList<>())
                // 根据表后缀生成
                .designatedTableSuffix(new ArrayList<>())
                // 2、忽略指定的表的结构
                // 忽略的表名
                .ignoreTableName(ignoreTableName)
                // 忽略的表前缀
                .ignoreTablePrefix(ignorePrefix)
                // 忽略的表后缀
                .ignoreTableSuffix(ignoreSuffix)
                // 3、执行构建
                .build();

        // 生成的文档注释
        Configuration config = Configuration.builder()
                // 版本
                .version("1.0.0")
                // 描述
                .description(dataBaseName + "数据库设计文档生成")
                // 数据源
                .dataSource(dataSource)
                // 生成配置（生成文件的属性配置）
                .engineConfig(engineConfig)
                // 生成配置（生成表的结构，跳过忽略的表）
                .produceConfig(processConfig)
                .build();

        // 执行生成
        new DocumentationExecute(config).execute();
    }
}
