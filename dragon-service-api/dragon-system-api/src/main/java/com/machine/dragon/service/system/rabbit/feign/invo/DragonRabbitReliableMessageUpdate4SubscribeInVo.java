package com.machine.dragon.service.system.rabbit.feign.invo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class DragonRabbitReliableMessageUpdate4SubscribeInVo {

    private String id;
    private Integer nextTimeSeconds;
    private String reason;
    private String remark;
}