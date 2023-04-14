package com.anyn.messagePush.service.service;

import com.anyn.messagePush.service.domain.SendRequest;
import com.anyn.messagePush.service.domain.SendResponse;

/**
 * 撤回接口
 */
public interface RecallService {
    /**
     * 根据模板id撤回消息
     * @param sendRequest
     * @return
     */
    SendResponse recall(SendRequest sendRequest);
}
