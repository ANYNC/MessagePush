package com.anyn.messagePush.common.enums;

import com.anyn.messagePush.common.dto.model.ContentModel;
import com.anyn.messagePush.common.dto.model.SmsContentModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * 发送渠道枚举
 * @author anyn
 */

@Getter
@ToString
@AllArgsConstructor
public enum ChannelType {
    // 短信
    SMS(30,"sms(短信)", SmsContentModel.class, "push");
    // 编码值
    private final Integer code;
    // 描述
    private final String description;
    // 内容模型Class
    private final Class<? extends ContentModel> contentModelClass;
    // 英文标识
    private final String codeEn;

    /**
     * 通过code获取class
     * @param code
     * @return
     */
    public static Class<? extends ContentModel> getChannelModelClassByCode(Integer code) {
        ChannelType[] values = values();
        for (ChannelType value : values) {
            if (value.getCode().equals(code)) {
                return value.getContentModelClass();
            }
        }
        return null;
    }

    /**
     * 通过code获取enum
     * @param code
     * @return
     */
    public static ChannelType getEnumByCode(Integer code) {
        ChannelType[] values = values();
        for (ChannelType value : values) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }
}
