package com.anyn.messagePush.service.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Map;

/**
 * @Description: 消息参数
 * @Author: Anyn
 **/
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
