package com.anyn.messagePush.service.domain;

import java.util.Map;

public class MessageParam {
    /**
     * 接受者
     * 多个用，逗号分隔
     * 小于100
     * 必传
     */
    private String receiver;

    /**
     * 消息中可变部分（占位符替换）
     */
    private Map<String, String> variables;

    /**
     * 扩展参数
     */
    private Map<String, String> extra;
}
