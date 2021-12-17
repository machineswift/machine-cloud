package com.machine.dragon.service.system.rabbit.dao.outdto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DragonRabbitReliableMessageOutDTO {
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
    private Long lastSendTime;
    private Integer subscribeTimes;
    private Long lastSubscribeTime;
    private Long nextExeTime;
    private String retryStrategy;

    private Long createTime;
    private Long updateTime;
    private Boolean deleted;
}