package com.loto.hotsearch.generate;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * PageName：MybatisPlusCodeGenerate.java<p>
 * Date：2022-12-31 16:49<p>
 * Function：MybatisPlus 逆向生成工具
 *
 * @author 蓝田_Loto
 */

public class MybatisPlusCodeGenerate {
    public static void main(String[] args) {
        // 作者
        String author = "蓝田_Loto";
        // 逆向生成的包的路径
        String newGeneratedPackage = "baidu";
        // 逆向生成的项目的路径
        String projectServicePath = "/service-fetch-data-9086-baidu";
        // 数据库信息
        DbType dbType = DbType.MYSQL;  // 数据库类型
        String driverName = "com.mysql.cj.jdbc.Driver";
        String userName = "root";
        String password = "root";
        String url = "jdbc:mysql://localhost:3306/HotSearch_Top?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
        String tableName1 = "bai_du_hot_info";
        String tableName2 = "bai_du_hot_info";
        String tableName3 = "bai_du_hot_info";

        // 1、全局配置
        GlobalConfig gc = new GlobalConfig();
        //作者
        gc.setAuthor(author);
        // 路径
        String projectPath = System.getProperty("user.dir") + projectServicePath;
        gc.setOutputDir(projectPath + "/src/main/java");
        // XML ResultMap
        gc.setBaseResultMap(true);
        // XML column List
        gc.setBaseColumnList(true);
        // 使用swagger2
        //gc.setSwagger2(true);
        // 设置主键生成策略
        /* gc.setIdType(IdType.ID_WORKER_STR);*/
        // 关闭二级缓存
        gc.setEnableCache(false);
        // 去掉默认带"I"
        gc.setServiceName("%sService");
        // 覆盖
        gc.setFileOverride(true);
        // 打开文件目录
        gc.setOpen(false);
        gc.setDateType(DateType.ONLY_DATE);
        AutoGenerator mpg = new AutoGenerator();
        mpg.setGlobalConfig(gc);

        // 2、数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(dbType);
        dsc.setDriverName(driverName);
        dsc.setUsername(userName);
        dsc.setPassword(password);
        dsc.setUrl(url);
        mpg.setDataSource(dsc);

        // 3、数据库策略配置
        StrategyConfig strategy = new StrategyConfig();
        // 全局大写命名
        strategy.setCapitalMode(false);
        // 实体类使用lombok
        strategy.setEntityLombokModel(true);
        // rest风格controller
        strategy.setRestControllerStyle(true);
        // is_xxx 去除is_ 前缀
        strategy.setEntityBooleanColumnRemoveIsPrefix(true);
        // 字段注释
        strategy.setEntityTableFieldAnnotationEnable(true);
        // 数据表命名策略
        strategy.setNaming(NamingStrategy.underline_to_camel);
        // 数据表列生成策略
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        // 去掉表前缀
        strategy.setTablePrefix("t_");
        // 逻辑删除配置
        //strategy.setLogicDeleteFieldName("deleted");
        // 乐观锁配置
        //strategy.setVersionFieldName("version");
        // 自动填充配置
        //List<TableFill> tableFills = new ArrayList<>();
        //TableFill gmtCreate = new TableFill("gmt_create", FieldFill.INSERT);
        //TableFill gmtModified = new TableFill("gmt_modified", FieldFill.INSERT_UPDATE);
        //tableFills.add(gmtCreate);
        //tableFills.add(gmtModified);
        //strategy.setTableFillList(tableFills);
        // 类型转换
        // 需要生成的表

        // 数据库表信息
        strategy.setInclude(tableName1, tableName2, tableName3);
        mpg.setStrategy(strategy);

        // 4、包配置
        String newModule = "." + newGeneratedPackage;
        PackageConfig pc = new PackageConfig();
        // 模块名
        pc.setModuleName("");
        pc.setParent("com.loto.hotsearch");
        pc.setService("service" + newModule);
        pc.setServiceImpl("service" + newModule + ".impl");
        pc.setEntity("dao.entity" + newModule);
        pc.setMapper("dao.mapper" + newModule);
        mpg.setPackageInfo(pc);

        // 5、设置 XXXMapper.xml 的路径存放到 src/main/resources/mapper/ 下
        // 如果模板引擎是 freemarker
        //String templatePath = "/templates/mapper.xml.ftl";

        // 如果模板引擎是 velocity
        String templatePath = "/templates/mapper.xml.vm";

        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig(templatePath) {
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                if (StringUtils.isEmpty(pc.getModuleName())) {
                    return projectPath + "/src/main/resources/mapper/" + tableInfo.getXmlName() + StringPool.DOT_XML;
                } else {
                    return projectPath + "/src/main/resources/mapper/" + pc.getModuleName() + "/" + tableInfo.getXmlName() + StringPool.DOT_XML;
                }
            }
        });

        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        mpg.setTemplate(new TemplateConfig().setXml(null));

        // 6、执行生成
        mpg.execute();
    }
}
