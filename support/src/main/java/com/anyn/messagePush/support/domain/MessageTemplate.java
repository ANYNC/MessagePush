package com.anyn.messagePush.support.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @Description: 消息模板DO
 * @Author: Anyn
 **/

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Accessors(chain = true)
public class MessageTemplate implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 模板标题
    private String name;

    // 审核状态
    private Integer auditStatus;

    // 工单id（审核模板走工单）
    private String flowId;

    // 消息状态
    private Integer msgStatus;

    // 定时任务id
    private Integer cronTaskId;

    // 定时发送的人群的文件路径
    private String cronCrowPath;

    // 发送的id类型
    private Integer idType;

    // 发送渠道
    private Integer sendChannel;

    // 模板类型
    private Integer templateType;

    // 屏蔽类型
    private Integer shieldType;

    // 消息类型
    private Integer msgType;

    /**
     * 推送消息的时间
     * 0：立即推送
     * else：crontab表达式
     */
    private String exceptPushTime;

    // 消息内容{$var}为占位符
    private String msgContent;

    // 发送账号（邮件下可以有多个发送账号、短信可有多个发送账号）
    private Integer sendAccount;

    // 创建者
    private String creator;

    // 修改者
    private String updater;

    // 审核者
    private String auditor;

    // 业务方团队
    private String team;

    // 业务方
    private String proposer;

    /**
     * 是否删除
     * 0：未删除
     * 1：已删除
     */
    private Integer isDeleted;

    // 创建时间 单位 s
    private Integer created;

    // 更新时间 单位 s
    private Integer updated;
}
