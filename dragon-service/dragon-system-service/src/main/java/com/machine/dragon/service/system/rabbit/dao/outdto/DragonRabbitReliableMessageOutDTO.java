package com.machine.dragon.service.system.rabbit.dao.outdto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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
    private LocalDateTime lastSendTime;
    private Integer subscribeTimes;
    private LocalDateTime lastSubscribeTime;
    private LocalDateTime nextExeTime;
    private String retryStrategy;

    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Boolean deleted;
}