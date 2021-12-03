package com.machine.dragon.service.system.rabbit.service.inbo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DragonRabbitReliableMessageUpdate4SubscribeInBo {

    private String id;
    private Integer nextTimeSeconds;
    private String reason;
    private String remark;
}