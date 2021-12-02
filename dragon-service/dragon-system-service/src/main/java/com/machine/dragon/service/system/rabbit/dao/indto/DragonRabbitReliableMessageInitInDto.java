package com.machine.dragon.service.system.rabbit.dao.indto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
public class DragonRabbitReliableMessageInitInDto {
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
    private String messageContent;
    private String reason;
    private String remark;
}