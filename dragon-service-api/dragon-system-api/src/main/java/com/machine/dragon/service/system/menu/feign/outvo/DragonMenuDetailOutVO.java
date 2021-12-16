package com.machine.dragon.service.system.menu.feign.outvo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DragonMenuDetailOutVO {

    /**
     * 菜单Id
     */
    private Long menuId;

    /**
     * 父菜单Id。顶级菜单此字段为0
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
}