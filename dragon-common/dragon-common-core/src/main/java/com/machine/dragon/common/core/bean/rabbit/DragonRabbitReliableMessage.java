package com.machine.dragon.common.core.bean.rabbit;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class DragonRabbitReliableMessage {

    public DragonRabbitReliableMessage(String messageClassName,
                                       String publishName,
                                       String publishExchange,
                                       String publishRoutingKey) {
        this.messageClassName = messageClassName;
        this.publishName = publishName;
        this.publishExchange = publishExchange;
        this.publishRoutingKey = publishRoutingKey;
    }

    private String id;
    private Integer tenantId;
    private String messageKey;
    private String messageClassName;
    private String publishName;
    private String publishExchange;
    private String publishRoutingKey;
    private String subscribeQueues;
    private String subscribeName;
    private Integer maxResendTimes;
    private Integer resendTimes;
    private Date lastSendTime;
    private Integer subscribeTimes;
    private Date lastSubscribeTime;
    private Date nextExeTime;
    private String messageContent;
    private String reason;
    private String remark;
    private Boolean deleted;
    private Date createTime;
    private Date updateTime;

    /**
     * 冗余字段
     */
    private Integer nextTimeSeconds;
}