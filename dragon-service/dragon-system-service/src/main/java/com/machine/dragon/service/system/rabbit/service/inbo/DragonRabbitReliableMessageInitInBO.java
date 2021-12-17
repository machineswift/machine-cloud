package com.machine.dragon.service.system.rabbit.service.inbo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DragonRabbitReliableMessageInitInBO {
    private String messageKey;
    private String messageClassName;
    private String publishName;
    private String publishExchange;
    private String publishRoutingKey;
    private String subscribeQueues;
    private String subscribeName;
    private Integer maxResendTimes;
    private Integer resendTimes;
    private Integer subscribeTimes;
    private Long nextExeTime;
    private String retryStrategy;
    private String messageContent;
    private String reason;
    private String remark;
}