package com.machine.dragon.service.system.rabbit.service.inbo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DragonRabbitReliableMessageUpdate4SubscribeInBO {

    private String id;
    private Integer nextTimeMillis;
    private String reason;
    private String remark;
}