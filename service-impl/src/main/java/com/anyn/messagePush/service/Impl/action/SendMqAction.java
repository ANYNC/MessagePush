package com.anyn.messagePush.service.Impl.action;

import cn.hutool.core.collection.CollUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.anyn.messagePush.common.enums.RespStatusEnum;
import com.anyn.messagePush.common.vo.BasicResultVO;
import com.anyn.messagePush.service.Impl.domain.SendTaskModel;
import com.anyn.messagePush.service.enums.BusinessCode;
import com.anyn.messagePush.support.mq.SendMqService;
import com.anyn.messagePush.support.pipeline.BusinessProcess;
import com.anyn.messagePush.support.pipeline.ProcessContext;
import com.google.common.base.Throwables;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * 将消息发送到MQ
 *
 * @author Anyn
 **/

@Slf4j
@Service
public class SendMqAction implements BusinessProcess<SendTaskModel> {

    @Autowired
    private SendMqService sendMqService;

    @Value("${MessagePush.business.topic.name}")
    private String sendMessageTopic;

    @Value("${MessagePush.business.recall.topic.name}")
    private String messagePushRecall;

    @Value("${MessagePush.business.tagId.value}")
    private String tagId;

    @Value("${MessagePush.mq.pipeline}")
    private String mqPipeline;

    @Override
    public void process(ProcessContext<SendTaskModel> context) {
        SendTaskModel sendTaskModel = context.getProcessModel();
        try {
            if (BusinessCode.COMMON_SEND.getCode().equals(context.getCode())) {
                String message = JSON.toJSONString(sendTaskModel.getTaskInfo(), SerializerFeature.WriteClassName);
                sendMqService.send(sendMessageTopic, message, tagId);
            } else if (BusinessCode.RECALL.getCode().equals(context.getCode())) {
                String message = JSON.toJSONString(sendTaskModel.getMessageTemplate(), SerializerFeature.WriteClassName);
                sendMqService.send(messagePushRecall, message, tagId);
            }
        } catch (Exception e) {
            context.setNeedBreak(true).setResponse(BasicResultVO.fail(RespStatusEnum.SERVICE_ERROR));
            log.error("send {} fail! e:{}, params:{}",mqPipeline, Throwables.getStackTraceAsString(e),
                    JSON.toJSONString(CollUtil.getFirst(sendTaskModel.getTaskInfo().listIterator())));
        }
    }
}
