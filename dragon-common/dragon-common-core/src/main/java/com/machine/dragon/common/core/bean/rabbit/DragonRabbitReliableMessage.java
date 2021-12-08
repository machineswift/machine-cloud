package com.machine.dragon.common.core.bean.rabbit;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
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
    private LocalDateTime lastSendTime;
    private Integer subscribeTimes;
    private LocalDateTime lastSubscribeTime;
    private LocalDateTime nextExeTime;
    private String retryStrategy;
    private String messageContent;
    private String reason;
    private String remark;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Boolean deleted;
}