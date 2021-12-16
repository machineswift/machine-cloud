package com.machine.dragon.web.system.role.controller.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@ApiModel
@NoArgsConstructor
public class DragonRoleDetailResponse {

    @ApiModelProperty(name = "roleId", value = "角色Id", dataType = "long", position = 10)
    private Long roleId;

    @ApiModelProperty(name = "parentId", value = "父角色Id", dataType = "long", position = 20)
    private Long parentId;

    @ApiModelProperty(name = "code", value = "编码", dataType = "string", position = 30)
    private String code;

    @ApiModelProperty(name = "name", value = "名称", dataType = "string", position = 40)
    private String name;

    @ApiModelProperty(name = "remark", value = "备注", dataType = "string", position = 50)
    private String remark;
}
