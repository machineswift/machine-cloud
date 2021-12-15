package com.machine.dragon.web.system.tenant.controller.response;

import com.machine.dragon.common.core.envm.tenant.DragonTenantStatusEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@ApiModel
@NoArgsConstructor
public class DragonTenantResponse {

    @ApiModelProperty(name = "tenantId", value = "租户ID", dataType = "int", position = 10)
    private Integer tenantId;

    @ApiModelProperty(name = "name", value = "名称", dataType = "string", position = 20)
    private String name;

    @ApiModelProperty(name = "status", value = "状态", dataType = "string", position = 30)
    private DragonTenantStatusEnum status;
}
