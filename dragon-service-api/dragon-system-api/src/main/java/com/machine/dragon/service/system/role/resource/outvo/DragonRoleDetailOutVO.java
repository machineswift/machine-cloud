package com.machine.dragon.service.system.role.resource.outvo;

import lombok.Data;

@Data
public class DragonRoleDetailOutVO {

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
    private Long createTime;

    /**
     * 修改人
     */
    private String updateUser;

    /**
     * 更新时间
     */
    private Long updateTime;
}