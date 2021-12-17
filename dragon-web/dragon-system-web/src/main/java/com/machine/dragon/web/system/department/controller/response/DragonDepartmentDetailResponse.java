package com.machine.dragon.web.system.department.controller.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@ApiModel
@NoArgsConstructor
public class DragonDepartmentDetailResponse {

    @ApiModelProperty(name = "departmentId", value = "部门Id", dataType = "long", position = 10)
    private Long departmentId;

    @ApiModelProperty(name = "parentId", value = "父部门Id", dataType = "long", position = 20)
    private Long parentId;

    @ApiModelProperty(name = "code", value = "编码", dataType = "string", position = 30)
    private String code;

    @ApiModelProperty(name = "name", value = "名称", dataType = "string", position = 40)
    private String name;

    @ApiModelProperty(name = "createTime", value = "创建时间", dataType = "long", position = 50)
    private Long createTime;

    @ApiModelProperty(name = "updateTime", value = "更新时间", dataType = "long", position = 60)
    private Long updateTime;
}
