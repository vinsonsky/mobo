package com.mobo.backstage.util.mq;

/**
 * @Auther: chengyunyi
 * @Date: 2019/1/18 11:15
 * @Description:
 */
public enum RabbitMqEnum {

    MOBO_DEMO("mobo.demo","mobo测试mq");

    private String queue;
    private String name;

    RabbitMqEnum(String queue, String name) {
        this.queue = queue;
        this.name = name;
    }

    public String getQueue() {
        return queue;
    }

    public void setQueue(String queue) {
        this.queue = queue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
