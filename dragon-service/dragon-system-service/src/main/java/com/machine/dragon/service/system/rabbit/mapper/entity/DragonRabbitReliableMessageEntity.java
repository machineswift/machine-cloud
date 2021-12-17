package com.machine.dragon.service.system.rabbit.mapper.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@TableName("t_dragon_rabbit_reliable_message")
public class DragonRabbitReliableMessageEntity {

    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    private Integer tenantId;
    private String messageKey;
    private String messageClassName;
    private String publishName;
    private String publishExchange;
    private String publishRoutingKey;
    private String subscribeQueues;
    private String subscribeName;
    private Integer maxResendTimes;
    private Integer resendTimes;
    private Long lastSendTime;
    private Integer subscribeTimes;
    private Long lastSubscribeTime;

    private Long nextExeTime;

    private String retryStrategy;

    @TableField(fill = FieldFill.INSERT)
    private Long createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updateTime;

    @TableField(value = "is_deleted")
    private Boolean deleted;
}