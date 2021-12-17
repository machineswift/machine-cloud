package com.machine.dragon.service.system.rabbit.feign.invo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DragonRabbitReliableMessageInitInVO {
    private String messageKey;
    private String messageClassName;
    private String publishName;
    private String publishExchange;
    private String publishRoutingKey;
    private String subscribeQueues;
    private String subscribeName;
    private Integer maxResendTimes;
    private Integer resendTimes;
    private Integer subscribeTimes;
    private Long nextExeTime;
    private String retryStrategy;
    private String messageContent;
    private String reason;
    private String remark;

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
        this.setReason(reason.toString());
    }
}