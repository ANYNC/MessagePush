package com.anyn.messagePush.service.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Description: 发送接口返回值
 * @Author: Anyn
 **/
@Data
@Accessors(chain = true)
@AllArgsConstructor
public class SendResponse {
    // 响应状态
    private String code;

    // 响应编码
    private String msg;
}
