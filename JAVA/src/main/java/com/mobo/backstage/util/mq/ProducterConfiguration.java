package com.mobo.backstage.util.mq;

import com.mobo.backstage.util.ApplicationContextHandler;
import com.mobo.backstage.util.SnowflakeIdWorker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Auther: chengyunyi
 * @Date: 2019/1/18 11:17
 * @Description:
 */
public class ProducterConfiguration {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProducterConfiguration.class);

    @Autowired
    private MQConfig mqConfig= ApplicationContextHandler.getBean("MQConfig");

    private String queueName;
    private String exchange;
    private String routingKey;
    private RabbitTemplate rabbitTemplate;

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getRoutingKey() {
        return routingKey;
    }

    public void setRoutingKey(String routingKey) {
        this.routingKey = routingKey;
    }

    public ProducterConfiguration() {
    }

    public ProducterConfiguration(String queueName, String exchange, String routingKey) {
        this.queueName = queueName;
        this.exchange = exchange;
        this.routingKey = routingKey;
        this.rabbitTemplate=rabbitTemplate();

        Queue queue = new Queue(queueName, true);

        DirectExchange directExchange = new DirectExchange(exchange, true, true);
        //注册交换机和队列
        RabbitAdmin admin = new RabbitAdmin(rabbitTemplate.getConnectionFactory());
        admin.declareQueue(queue);
        admin.declareExchange(directExchange);
        admin.declareBinding(BindingBuilder.bind(queue).to(directExchange).with(routingKey));
    }

    private RabbitTemplate rabbitTemplate(){
        RabbitTemplate template = new RabbitTemplate(connectionFactory());
        template.setRoutingKey(this.routingKey);
        template.setQueue(this.queueName);
        template.setMandatory(true);
        return template;
    }

    private ConnectionFactory connectionFactory(){
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(mqConfig.getIp());
        connectionFactory.setUsername(mqConfig.getUser());
        connectionFactory.setPassword(mqConfig.getPassword());
        connectionFactory.setPort(Integer.valueOf(mqConfig.getPort()));
        //如果要进行消息回调，则这里必须要设置为true
        connectionFactory.setPublisherConfirms(true);
        connectionFactory.setPublisherReturns(true);
        connectionFactory.setVirtualHost("/");
        connectionFactory.setChannelCacheSize(100);
        connectionFactory.setConnectionCacheSize(5);
        connectionFactory.setRequestedHeartBeat(30);
        //connectionFactory.setChannelCheckoutTimeout(20000); //不能启用，会导致启动创建队列特别慢
        connectionFactory.setConnectionTimeout(20000);
        connectionFactory.setCacheMode(CachingConnectionFactory.CacheMode.CONNECTION);
        return connectionFactory;
    }

    public void send(String message){
        String uuId = SnowflakeIdWorker.getInstance().nextId() + "";
        CorrelationData correlationData=new CorrelationData(uuId);
        LOGGER.info("消息id："+correlationData.getId());

        rabbitTemplate.convertAndSend(exchange, routingKey, message, new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                //设置信息的属性信息&设置发送模式（PERSISTENT:连续的）
                MessageProperties props = message.getMessageProperties();

                message.getMessageProperties().setPriority(1);
                props.setMessageId(uuId);
                props.setDeliveryMode(MessageDeliveryMode.PERSISTENT);
                props.setContentEncoding("UTF-8");
                props.setHeader("header", "1.0.0");

                return message;
            }
        },correlationData);
    }
}
