package com.anyn.messagePush.support.pipeline;

import com.anyn.messagePush.common.vo.BasicResultVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 责任链上下文
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Accessors(chain = true)
public class ProcessContext<T extends ProcessModel> {
    /**
    * 标识责任链的code
    **/
    private String code;

    /**
     * 存储责任链上下文数据的类型
     */
    private T processModel;

    /**
    * 责任链中断的标识
    */
    private Boolean needBreak;

    /**
     * 流程处理的结果
     */
    public BasicResultVO response;
}
