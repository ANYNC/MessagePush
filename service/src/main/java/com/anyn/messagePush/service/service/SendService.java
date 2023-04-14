package com.anyn.messagePush.service.service;

import com.anyn.messagePush.service.domain.BatchSendRequest;
import com.anyn.messagePush.service.domain.SendRequest;
import com.anyn.messagePush.service.domain.SendResponse;

/**
 * 发送接口
 */
public interface SendService {
    /**
     * 单文案发送接口
     * @param sendRequest
     * @return
     */
    SendResponse send(SendRequest sendRequest);

    /**
     * 多文案发送接口
     * @param batchSendRequest
     * @return
     */
    SendResponse batchSend(BatchSendRequest batchSendRequest);
}
