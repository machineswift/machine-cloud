package com.machine.dragon.common.core.bean.rabbit;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DragonRabbitBaseMessage {

    private Integer tenantId;

    private DragonRabbitReliableMessage reliableMessage;

}
