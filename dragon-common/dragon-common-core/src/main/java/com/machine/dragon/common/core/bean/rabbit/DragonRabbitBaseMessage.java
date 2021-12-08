package com.machine.dragon.common.core.bean.rabbit;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DragonRabbitBaseMessage {

    private Integer tenantId;

    private DragonRabbitReliableMessage reliableMessage;

    /**
     * 添加失败堆栈信息
     */
    @JsonIgnore
    public void setException(Exception exception) {
        StringBuilder reason = new StringBuilder();
        String lineSeparator = System.lineSeparator();
        reason.append(exception.toString())
                .append(": ")
                .append(exception.getMessage())
                .append(lineSeparator);
        for (StackTraceElement elem : exception.getStackTrace()) {
            reason.append(elem)
                    .append(lineSeparator);
        }
        reliableMessage.setReason(reason.toString());
    }
}
