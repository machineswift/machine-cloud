package com.machine.dragon.common.core.bean.rabbit;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class DragonRabbitReliableMessage {

    public DragonRabbitReliableMessage(String messageClassName,
                                       String producerName,
                                       String producerExchange,
                                       String producerRoutingKey) {
        this.messageClassName = messageClassName;
        this.producerName = producerName;
        this.producerExchange = producerExchange;
        this.producerRoutingKey = producerRoutingKey;
    }

    private Long id;
    private Long tenantId;
    private String messageKey;
    private String messageClassName;
    private String producerName;
    private String producerExchange;
    private String producerRoutingKey;
    private String consumerQueues;
    private String consumerName;
    private String retryStrategy;
    private Integer maxResendTimes;
    private Integer resendTimes;
    private Date lastSendTime;
    private Integer consumerTimes;
    private Date lastConsumerTime;
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