package com.mobo.backstage.dao.datasource;

import com.alibaba.dubbo.common.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Auther: chengyunyi
 * @Date: 2019/1/17 17:53
 * @Description: 动态切换数据库
 */
public class ReadWriteSplitRoutingDataSource extends AbstractRoutingDataSource {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReadWriteSplitRoutingDataSource.class);
    private AtomicInteger count = new AtomicInteger(0);
    @Override
    protected Object determineCurrentLookupKey() {
        String typeKey = DbContextHolder.getDbType();
        if (StringUtils.isBlank(typeKey)){
            LOGGER.info("数据库路由为空,缺省使用数据库write.............");
            return DbType.MASTER.getType();
        }
        if (typeKey.equals(DbType.MASTER.getType())){
            LOGGER.info("使用数据库write.............");
            return typeKey;
        }
        //读库， 简单负载均衡
        int number = count.getAndAdd(1);
        //TODO 查询多个从库 怎么做负载均衡
        int lookupKey = number % 2;
        String tKey = DbType.SLAVE.getType() + (lookupKey + 1);
        LOGGER.info("使用数据库:" + tKey);
        return tKey;
    }
}
