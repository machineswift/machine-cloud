package com.machine.dragon.service.system.rabbit.feign.invo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class DragonRabbitReliableMessageUpdate4SubscribeInVO {

    private String id;
    private Integer nextTimeSeconds;
    private String reason;
    private String remark;
}