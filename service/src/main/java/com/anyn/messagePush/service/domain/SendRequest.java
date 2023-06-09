package com.anyn.messagePush.service.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @Description: 发送/撤回接口的参数
 * @Author: Anyn
 **/

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SendRequest {
    /**
     * 执行业务类型
     * send：发送消息
     * recall：撤回消息
     */
    private String code;

    /**
     * 模板消息id
     * 必填
     */
    private Long messageTemplateId;

    /**
     * 消息相关的参数
     * 当业务类型为“send”，必传
     */
    private MessageParam messageParam;
}
