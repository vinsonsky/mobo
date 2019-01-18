package com.mobo.backstage.controller;

import com.mobo.backstage.constant.ApiResult;
import com.mobo.backstage.util.mq.ProducterConfiguration;
import com.mobo.backstage.util.mq.ProducterFactory;
import com.mobo.backstage.util.mq.RabbitMqEnum;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: chengyunyi
 * @Date: 2019/1/18 11:56
 * @Description:
 */
@RestController
public class RabbitMQController {

    @RequestMapping("/rabbit")
    public ApiResult rabbitDemo(){
        ApiResult result = new ApiResult();

        ProducterConfiguration producterConfiguration = ProducterFactory.createInstance(RabbitMqEnum.MOBO_DEMO.getQueue());
        producterConfiguration.send("测试rabbit,时间戳："+System.currentTimeMillis());
        return result;
    }
}
