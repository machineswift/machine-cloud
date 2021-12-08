package com.machine.dragon.service.system.department.service.outBo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DragonDepartmentDetailOutBO {

    /**
     * 部门Id。根部门此字段为1
     */
    private Long departmentId;

    /**
     * 父部门Id。根部门此字段为0
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
     * 在父部门中的次序值。sort值大的排序靠前
     */
    private Long sort;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}