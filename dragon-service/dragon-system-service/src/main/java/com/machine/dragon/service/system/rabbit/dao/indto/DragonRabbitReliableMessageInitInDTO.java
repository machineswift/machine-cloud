package com.machine.dragon.service.system.rabbit.dao.indto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DragonRabbitReliableMessageInitInDTO {
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
    private String messageContent;
    private String reason;
    private String description;
}