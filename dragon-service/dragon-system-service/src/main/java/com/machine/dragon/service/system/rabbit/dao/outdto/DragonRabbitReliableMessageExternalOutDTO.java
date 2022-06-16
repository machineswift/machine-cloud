package com.machine.dragon.service.system.rabbit.dao.outdto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DragonRabbitReliableMessageExternalOutDTO {
    private String id;
    private String messageContent;
    private String reason;
    private String description;

    private Long createTime;
    private Long updateTime;
    private Boolean deleted;
}