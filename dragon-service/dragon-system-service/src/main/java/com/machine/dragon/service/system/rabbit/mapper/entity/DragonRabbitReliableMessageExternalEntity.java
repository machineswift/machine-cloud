package com.machine.dragon.service.system.rabbit.mapper.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@TableName("t_dragon_rabbit_reliable_message_external")
public class DragonRabbitReliableMessageExternalEntity {
    private String id;
    private String messageContent;
    private String reason;
    private String remark;

    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    @TableField(value = "is_deleted")
    private Boolean deleted;
}