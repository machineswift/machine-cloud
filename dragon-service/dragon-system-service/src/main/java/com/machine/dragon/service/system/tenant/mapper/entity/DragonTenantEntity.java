package com.machine.dragon.service.system.tenant.mapper.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.machine.dragon.common.core.envm.tenant.DragonTenantStatusEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@TableName("t_dragon_tenant")
public class DragonTenantEntity {

    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 租户id
     */
    private Integer tenantId;

    /**
     * 名称
     */
    private String name;

    /**
     * 状态
     */
    private DragonTenantStatusEnum status;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 是否已删除
     */
    @TableField(value = "is_deleted")
    private Boolean deleted;
}