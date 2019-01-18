package com.mobo.backstage.dao.datasource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: chengyunyi
 * @Date: 2019/1/17 17:45
 * @Description:
 */
@Configuration
@AutoConfigureAfter(DataSourceConfiguration.class)
@MapperScan("com.mobo.backstage.dao.mapper")
public class MybatisConfiguration {
    private static final Logger LOGGER = LoggerFactory.getLogger(MybatisConfiguration.class);

    @Value("${mybatis.mapperLocations}")
    private String mapperLocations;

    @Autowired
    @Qualifier("masterDataSource")
    private DataSource masterDataSource;

    @Autowired
    @Qualifier("slaveDataSource")
    private DataSource slaveDataSource;

    @Autowired
    @Qualifier("slave2DataSource")
    private DataSource slave2DataSource;

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception{
        //TODO
        LOGGER.info("======sqlSessionFactory init =======");
        SqlSessionFactoryBean sessionFactoryBean=new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(roundRobinDataSouceProxy());

        // 读取配置
        sessionFactoryBean.setTypeAliasesPackage("com.mobo.backstage.dao.domain");

        //设置mapper.xml文件所在位置
        Resource[] resources=new PathMatchingResourcePatternResolver().getResources(mapperLocations);
        sessionFactoryBean.setMapperLocations(resources);

        return sessionFactoryBean.getObject();
    }

    @Bean
    public AbstractRoutingDataSource roundRobinDataSouceProxy(){
        ReadWriteSplitRoutingDataSource proxy=new ReadWriteSplitRoutingDataSource();
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DbType.MASTER.getType(), masterDataSource);
        targetDataSources.put(DbType.SLAVE.getType() + "1", slaveDataSource);
        targetDataSources.put(DbType.SLAVE.getType() + "2", slave2DataSource);

        proxy.setDefaultTargetDataSource(masterDataSource);
        proxy.setTargetDataSources(targetDataSources);
        return proxy;
    }
}
