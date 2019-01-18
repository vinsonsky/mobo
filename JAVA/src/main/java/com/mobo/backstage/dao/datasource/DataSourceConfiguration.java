package com.mobo.backstage.dao.datasource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @Auther: chengyunyi
 * @Date: 2019/1/17 17:23
 * @Description: 数据源配置
 */
@Configuration
public class DataSourceConfiguration {

    @Value("${druid.type}")
    private Class<? extends DataSource> dataSourceType;

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "druid.master")
    public DataSource masterDataSource(){return DataSourceBuilder.create().type(dataSourceType).build(); }

    @Bean
    @ConfigurationProperties(prefix = "druid.slave")
    public DataSource slaveDataSource(){return DataSourceBuilder.create().type(dataSourceType).build();}

    @Bean
    @ConfigurationProperties(prefix = "druid.slave2")
    public DataSource slave2DataSource(){return DataSourceBuilder.create().type(dataSourceType).build();}
}
