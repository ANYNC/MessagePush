package com.anyn.messagePush.service.Impl.config;

import com.anyn.messagePush.service.Impl.action.AfterParamCheckAction;
import com.anyn.messagePush.service.Impl.action.AssembleAction;
import com.anyn.messagePush.service.Impl.action.PreParamCheckAction;
import com.anyn.messagePush.service.Impl.action.SendMqAction;
import com.anyn.messagePush.service.enums.BusinessCode;
import com.anyn.messagePush.support.pipeline.ProcessController;
import com.anyn.messagePush.support.pipeline.ProcessTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * api层的pipeline配置类
 *
 * @author Anyn
 **/

@Configuration
public class PipelineConfig {
    @Autowired
    private PreParamCheckAction preParamCheckAction;
    @Autowired
    private AssembleAction assembleAction;
    @Autowired
    private AfterParamCheckAction afterParamCheckAction;
    @Autowired
    private SendMqAction sendMqAction;

    /**
     * 普通发送执行流程
     * 1.前置参数校验
     * 2.组装参数
     * 3.后置参数校验
     * 4.发送消息至MQ
     * @return
     */
    @Bean("commonSendTemplate")
    public ProcessTemplate commonSendTemplate() {
        ProcessTemplate processTemplate = new ProcessTemplate();
        processTemplate.setProcessList(Arrays.asList(preParamCheckAction, assembleAction, afterParamCheckAction, sendMqAction));
        return processTemplate;
    }

    /**
     * 撤回消息执行流程
     * 1.组装参数
     * 2.发送MQ
     * @return
     */
    @Bean("recallMessageTemplate")
    public ProcessTemplate recallMessageTemplate() {
        ProcessTemplate processTemplate = new ProcessTemplate();
        processTemplate.setProcessList(Arrays.asList(preParamCheckAction, assembleAction));
        return processTemplate;
    }

    @Bean
    public ProcessController processController() {
        ProcessController processController = new ProcessController();
        Map<String, ProcessTemplate> templateConfig = new HashMap<>(4);
        templateConfig.put(BusinessCode.COMMON_SEND.getCode(), commonSendTemplate());
        templateConfig.put(BusinessCode.RECALL.getCode(), recallMessageTemplate());
        processController.setTemplateConfig(templateConfig);
        return processController;
    }


}
