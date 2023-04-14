package com.anyn.messagePush.service.Impl.action;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.anyn.messagePush.common.constant.MessagePushConstant;
import com.anyn.messagePush.common.enums.RespStatusEnum;
import com.anyn.messagePush.common.vo.BasicResultVO;
import com.anyn.messagePush.service.Impl.domain.SendTaskModel;
import com.anyn.messagePush.service.domain.MessageParam;
import com.anyn.messagePush.support.pipeline.BusinessProcess;
import com.anyn.messagePush.support.pipeline.ProcessContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Description: 前置参数校验
 * @Author: Anyn
 **/

@Slf4j
@Service
public class PreParamCheckAction implements BusinessProcess<SendTaskModel> {

    @Override
    public void process(ProcessContext<SendTaskModel> context) {
        SendTaskModel sendTaskModel = context.getProcessModel();
        Long messageTemplateId = sendTaskModel.getMessageTemplateId();
        List<MessageParam> messageParamList = sendTaskModel.getMessageParamList();

        // 1.没有传入消息模板id或者messageParam
        if (Objects.isNull(messageTemplateId) || CollUtil.isEmpty(messageParamList)) {
            context.setNeedBreak(true).setResponse(BasicResultVO.fail(RespStatusEnum.CLIENT_BAD_PARAMETERS));
            return;
        }

        // 2.过滤Receiver = null的messageParam
        List<MessageParam> resultMessageParamList = messageParamList.stream()
                .filter(messageParam -> StrUtil.isBlank(messageParam.getReceiver()))
                .collect(Collectors.toList());

        if (CollUtil.isEmpty(resultMessageParamList)) {
            context.setNeedBreak(true).setResponse(BasicResultVO.fail(RespStatusEnum.CLIENT_BAD_PARAMETERS));
            return;
        }

        // 3.过滤receiver大于100的请求
        if (resultMessageParamList.stream()
                .anyMatch(messageParam -> messageParam.getReceiver()
                        .split(StrUtil.COMMA).length > MessagePushConstant.BATCH_RECEIVER_SIZE)) {
            context.setNeedBreak(true).setResponse(BasicResultVO.fail(RespStatusEnum.TOO_MANY_RECEIVER));
            return;
        }

        sendTaskModel.setMessageParamList(resultMessageParamList);
    }
}
