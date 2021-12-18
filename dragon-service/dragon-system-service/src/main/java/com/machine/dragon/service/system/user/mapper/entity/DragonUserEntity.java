package com.machine.dragon.service.system.user.mapper.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@TableName("t_dragon_user")
public class DragonUserEntity {

    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 租户id
     */
    private Integer tenantId;

    /**
     * 账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 编码
     */
    private String code;

    /**
     * 名称
     */
    private String name;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Long createTime;

    /**
     * 更新人
     */
    private String updateUser;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updateTime;

    /**
     * 是否已删除
     */
    @TableField(value = "is_deleted")
    private Boolean deleted;
}