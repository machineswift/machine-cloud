package com.machine.dragon.service.system.rabbit.feign.invo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class DragonRabbitReliableMessageInitInVO {
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
}