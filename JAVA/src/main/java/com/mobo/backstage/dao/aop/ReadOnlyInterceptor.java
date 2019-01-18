package com.mobo.backstage.dao.aop;

import com.mobo.backstage.dao.datasource.DbContextHolder;
import com.mobo.backstage.dao.datasource.DbType;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;

/**
 * @Auther: chengyunyi
 * @Date: 2019/1/18 09:42
 * @Description:
 */
@Aspect
@EnableAspectJAutoProxy(exposeProxy=true,proxyTargetClass = true)
@Component
public class ReadOnlyInterceptor implements PriorityOrdered {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReadOnlyInterceptor.class);

    @Before("@annotation(com.mobo.backstage.dao.annotation.ReadOnly)")
    public void setReadOnlyDataSource(){
        DbContextHolder.setDbType(DbType.SLAVE);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
