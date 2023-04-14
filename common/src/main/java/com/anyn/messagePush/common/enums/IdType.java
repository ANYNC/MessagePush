package com.anyn.messagePush.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * 发送类型Id枚举
 */
@Getter
@AllArgsConstructor
@ToString
public enum IdType {
    PHONE(30, "phone"),
    EMAIL(50,"email"),;

    private final Integer code;
    private final String description;
}
