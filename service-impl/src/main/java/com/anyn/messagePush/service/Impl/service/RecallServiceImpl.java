package com.anyn.messagePush.service.Impl.service;

import com.anyn.messagePush.common.vo.BasicResultVO;
import com.anyn.messagePush.service.Impl.domain.SendTaskModel;
import com.anyn.messagePush.service.domain.SendRequest;
import com.anyn.messagePush.service.domain.SendResponse;
import com.anyn.messagePush.service.service.RecallService;
import com.anyn.messagePush.support.pipeline.ProcessContext;
import com.anyn.messagePush.support.pipeline.ProcessController;
import com.anyn.messagePush.support.pipeline.ProcessModel;

/**
 * 撤回接口
 *
 * @author Anyn
 **/

public class RecallServiceImpl implements RecallService {
    private ProcessController processController;
    @Override
    public SendResponse recall(SendRequest sendRequest) {
        SendTaskModel sendTaskModel = SendTaskModel.builder()
                .messageTemplateId(sendRequest.getMessageTemplateId())
                .build();
        ProcessContext context = ProcessContext.builder()
                .code(sendRequest.getCode())
                .processModel(sendTaskModel)
                .needBreak(false)
                .response(BasicResultVO.success()).build();
        ProcessContext process = processController.process(context);
        return new SendResponse(process.getResponse().getStatus(), process.getResponse().getMsg());
    }
}
