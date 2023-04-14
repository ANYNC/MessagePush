package com.anyn.messagePush.support.mq;

/**
 * 发送数据到消息队列
 * @author Anyn
 */
public interface SendMqService {
    void send(String topic, String jsonValue, String tagId);
    void send(String topic, String jsonValue);
}
