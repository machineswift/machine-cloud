package com.machine.dragon.service.system.rabbit.dao.indto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DragonRabbitReliableMessageExternalInitInDTO {

    public DragonRabbitReliableMessageExternalInitInDTO(String id,
                                                        String messageContent) {
        this.id = id;
        this.messageContent = messageContent;
    }



    private String id;
    private String messageContent;
    private String reason;
    private String remark;
}