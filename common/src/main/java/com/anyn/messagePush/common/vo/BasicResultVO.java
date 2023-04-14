package com.anyn.messagePush.common.vo;

import com.anyn.messagePush.common.enums.RespStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Description: 流程处理结果
 * @Author: Anyn
 **/

@Data
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class BasicResultVO<T> {
    // 状态
    private String status;

    // 响应编码
    private String msg;

    // 返回数据
    private T data;

    public BasicResultVO(String status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public BasicResultVO(RespStatusEnum status, String msg, T data) {
        this.status = status.getMsg();
        this.msg = msg;
        this.data = data;
    }

    public BasicResultVO(RespStatusEnum status, T data) {
        this(status, status.getMsg(), data);
    }

    public BasicResultVO(RespStatusEnum status) {
        this(status, null);
    }

    /**
     * @return 默认响应成功
     */
    public static BasicResultVO<Void> success() {
        return new BasicResultVO<>(RespStatusEnum.SUCCESS);
    }

    /**
     * @param data
     * @return 带数据的相响应成功
     * @param <T>
     */
    public static <T> BasicResultVO<T> success(T data) {
        return new BasicResultVO<>(RespStatusEnum.SUCCESS, data);
    }

    public static <T> BasicResultVO<T> success(String msg) {
        return new BasicResultVO<>(RespStatusEnum.SUCCESS, msg, null);
    }

    /**
     *
     * @return 默认失败响应
     * @param <T>
     */
    public static <T> BasicResultVO<T> fail() {
        return new BasicResultVO<>(
                RespStatusEnum.FAIL,
                RespStatusEnum.FAIL.getMsg(),
                null
        );
    }

    /**
     *
     * @param status
     * @param msg
     * @return 自定义状态和信息的失败响应
     * @param <T>
     */
    public static <T> BasicResultVO<T> fail(RespStatusEnum status, String msg) {
        return new BasicResultVO<>(status, msg, null);
    }

    /**
     * 自定义状态的失败响应
     * @param status
     * @return
     * @param <T>
     */
    public static <T> BasicResultVO<T> fail(RespStatusEnum status) {
        return fail(status, status.getMsg());
    }

    /**
     * 自定义错误信息的失败响应
     * @param msg
     * @return
     * @param <T>
     */
    public static <T> BasicResultVO<T> fail(String msg) {
        return fail(RespStatusEnum.FAIL, msg);
    }


}
