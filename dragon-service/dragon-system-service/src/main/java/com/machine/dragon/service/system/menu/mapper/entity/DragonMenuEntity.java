package com.machine.dragon.service.system.menu.mapper.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@TableName("t_dragon_menu")
public class DragonMenuEntity {

    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 租户id
     */
    private Integer tenantId;

    /**
     * 菜单Id
     */
    private Long menuId;

    /**
     * 父级菜单Id。顶级菜单的父id为0
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
     * 菜单别名
     */
    private String alias;

    /**
     * 请求地址
     */
    private String path;

    /**
     * 在父菜单中的次序值。sort值大的排序靠前
     */
    private Long sort;

    /**
     * 备注
     */
    private String remark;

    /**
     * 是否打开新页面
     */
    @TableField(value = "is_opened")
    private Boolean opened;

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
     * 修改人
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