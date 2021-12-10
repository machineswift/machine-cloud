package com.machine.dragon.service.system.rabbit.dao.outdto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class DragonRabbitReliableMessageExternalOutDTO {
    private String id;
    private String messageContent;
    private String reason;
    private String remark;

    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Boolean deleted;
}