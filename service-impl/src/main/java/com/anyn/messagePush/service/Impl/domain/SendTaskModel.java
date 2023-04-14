package com.anyn.messagePush.service.Impl.domain;

import com.anyn.messagePush.common.domain.TaskInfo;
import com.anyn.messagePush.service.domain.MessageParam;
import com.anyn.messagePush.support.pipeline.ProcessModel;
import com.anyn.messagePush.support.domain.MessageTemplate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @description 发送消息任务模型
 * @author Anyn
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SendTaskModel implements ProcessModel {
    // 消息模板id
    private Long messageTemplateId;

    // 请求参数
    private List<MessageParam> messageParamList;

    // 发送任务的信息
    private List<TaskInfo> taskInfo;

    // 撤回任务的信息
    private MessageTemplate messageTemplate;
}
