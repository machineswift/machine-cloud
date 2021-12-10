package com.machine.dragon.service.system.rabbit.dao.indto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DragonRabbitReliableMessageExternalUpdateInDTO {

    private String id;
    private String reason;
    private String remark;
}