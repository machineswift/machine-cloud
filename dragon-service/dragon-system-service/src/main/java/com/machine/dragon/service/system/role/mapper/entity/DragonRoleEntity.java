package com.machine.dragon.service.system.role.mapper.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@TableName("t_dragon_role")
public class DragonRoleEntity {

    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 租户id
     */
    private Integer tenantId;

    /**
     * 角色Id。超级管理员角色此字段为1
     */
    private Long roleId;

    /**
     * 父角色Id。根角色此字段为0
     */
    private Long parentId;

    /**
     * 编码
     */
    private String code;

    /**
     * 名称
     */
    private String name;

    /**
     * 在父菜单中的次序值。sort值大的排序靠前
     */
    private Long sort;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改人
     */
    private String updateUser;

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