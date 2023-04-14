package com.anyn.messagePush.support.utils;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import com.anyn.messagePush.common.constant.CommonConstant;

import java.util.Date;

/**
 * @Description: 生成 消息推送的URL 工具类
 * @Author: Anyn
 **/

public class TaskInfoUtils {
    private static final int TYPE_FLAG = 1000000;
    private static String CODE = "track_code_bid";

    /**
     * 生成BusinessId：模板类型+模板Id+当天日期（固定16位）
     * @param templateId
     * @param templateType
     * @return
     */
    public static Long generateBusinessId(Long templateId, Integer templateType) {
        Integer today = Integer.valueOf(DateUtil.format(new Date(), DatePattern.PURE_DATE_PATTERN));
        return Long.valueOf(String.format("%d%s", templateType * TYPE_FLAG + templateId,today));
    }

    /**
     * 第2到8位为MessageTemplateId，切割出来
     * @param businessId
     * @return
     */
    public static Long getMessageTemplateFromBusinessId(Long businessId) {
        return Long.valueOf(String.valueOf(businessId).substring(1,8));
    }

    /**
     * 从BusinessId切割出日期
     * @param businessId
     * @return
     */
    public static Long getDateFromBusinessId(Long businessId) {
        return Long.valueOf(String.valueOf(businessId).substring(8));
    }

    public static String generateUrl(String url, Long templateId, Integer templateType) {
        url = url.trim();
        Long businessId = generateBusinessId(templateId, templateType);
        if ((url.indexOf(CommonConstant.QM) == -1)) {
            return url + CommonConstant.QM_STRING + CODE + CommonConstant.EQUAL_STRING + businessId;
        } else {
            return url + CommonConstant.AND_STRING + CODE + CommonConstant.EQUAL_STRING + businessId;
        }
    }
}
