package com.machine.dragon.service.system.rabbit.dao.indto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DragonRabbitReliableMessageUpdate4SubscribeInDTO {

    private String id;
    private Integer nextTimeMillis;
}