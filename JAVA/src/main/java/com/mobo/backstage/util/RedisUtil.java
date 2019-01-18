package com.mobo.backstage.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @Auther: chengyunyi
 * @Date: 2019/1/18 15:05
 * @Description:
 */
@Component
public class RedisUtil {

    @Autowired
    private RedisTemplate redisTemplate;

    public void add(String key,Object value){
        redisTemplate.opsForValue().set(key,value);
    }

    public Object get(String key){
        return redisTemplate.opsForValue().get(key);
    }
}
