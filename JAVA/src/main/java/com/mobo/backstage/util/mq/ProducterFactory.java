package com.mobo.backstage.util.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: chengyunyi
 * @Date: 2019/1/18 11:46
 * @Description:
 */
public class ProducterFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProducterFactory.class);

    private static Map<String, ProducterConfiguration> mapMsgConfig = new HashMap<>();

    public static void init(){
        for (RabbitMqEnum rabbitMqEnum : RabbitMqEnum.values()) {
            ProducterFactory.createInstance(rabbitMqEnum.getQueue());
        }
    }

    public static ProducterConfiguration createInstance(String type){
        String exchange = type + ".exchange";
        String queueName = type + ".queue";
        String routingKey = type + ".routing";

        ProducterConfiguration msgconfig=mapMsgConfig.get(type);
        if (msgconfig==null){
            msgconfig = new ProducterConfiguration(queueName, exchange, routingKey);
        }
        return msgconfig;
    }
}
