package com.anyn.messagePush.support.pipeline;

/**
 * 业务执行器
 * @param <T>
 */
public interface BusinessProcess<T extends ProcessModel> {
    void process(ProcessContext<T> context);
}
