package com.machine.dragon.service.system.rabbit.mapper.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

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
    private LocalDateTime lastSendTime;
    private Integer subscribeTimes;
    private LocalDateTime lastSubscribeTime;
    private LocalDateTime nextExeTime;
    private String messageContent;
    private String reason;
    private String remark;

    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    @TableField(value = "is_deleted")
    private Boolean deleted;
}