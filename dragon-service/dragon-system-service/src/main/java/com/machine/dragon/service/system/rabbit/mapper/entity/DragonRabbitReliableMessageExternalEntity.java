package com.machine.dragon.service.system.rabbit.mapper.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@TableName("t_dragon_rabbit_reliable_message_external")
public class DragonRabbitReliableMessageExternalEntity {
    private String id;
    private String messageContent;
    private String reason;
    private String description;

    @TableField(fill = FieldFill.INSERT)
    private Long createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updateTime;

    @TableField(value = "is_deleted")
    private Boolean deleted;
}