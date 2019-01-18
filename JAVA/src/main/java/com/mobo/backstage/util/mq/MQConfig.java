package com.mobo.backstage.util.mq;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Auther: chengyunyi
 * @Date: 2019/1/18 11:12
 * @Description:
 */
@Component
@ConfigurationProperties(prefix = "mq")
public class MQConfig {
    private String ip;
    private String user;
    private String password;
    private String port;
    private String onOfConsumer;
    private String interval;
    private String threadCount;
    private String msgCount;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getOnOfConsumer() {
        return onOfConsumer;
    }

    public void setOnOfConsumer(String onOfConsumer) {
        this.onOfConsumer = onOfConsumer;
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public String getThreadCount() {
        return threadCount;
    }

    public void setThreadCount(String threadCount) {
        this.threadCount = threadCount;
    }

    public String getMsgCount() {
        return msgCount;
    }

    public void setMsgCount(String msgCount) {
        this.msgCount = msgCount;
    }
}
