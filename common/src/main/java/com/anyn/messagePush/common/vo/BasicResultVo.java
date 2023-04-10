package com.anyn.messagePush.common.vo;

/**
 * @Description: 流程处理结果
 * @Author: Anyn
 **/

public class BasicResultVo<T> {
    // 状态
    private String status;

    // 响应编码
    private String msg;

    // 返回数据
    private T data;

    public BasicResultVo(String status, String msg) {
        this.status = status;
        this.msg = msg;
    }

}
