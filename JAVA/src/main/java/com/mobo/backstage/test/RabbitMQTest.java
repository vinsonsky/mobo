package com.mobo.backstage.test;

import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


/**
 * @Auther: chengyunyi
 * @Date: 2019/1/18 12:00
 * @Description:
 */
@Component
public class RabbitMQTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQTest.class);

    @RabbitListener(queues = "mobo.demo.queue")
    public void test(Channel channel, Message message)throws Exception{
        try {
            MessageProperties messageProperties = message.getMessageProperties();
            String messageContent = new String(message.getBody(), "UTF-8");
            LOGGER.info("接收到的消息："+messageContent);
            String messageId = messageProperties.getMessageId();
            LOGGER.info("消息ID："+messageId);
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            channel.basicNack(message.getMessageProperties().getDeliveryTag(),false,false);
        }
    }
}
