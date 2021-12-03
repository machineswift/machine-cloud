package com.machine.dragon.service.system.rabbit.dao.indto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DragonRabbitReliableMessageUpdate4SubscribeInDto {

    private String id;
    private Integer nextTimeSeconds;
    private String reason;
    private String remark;
}