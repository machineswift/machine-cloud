package com.machine.dragon.web.system.tenant.controller.response;

import com.machine.dragon.common.core.envm.tenant.DragonTenantStatusEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@ApiModel
public class DragonTenantResponse {

    @ApiModelProperty(value = "租户ID")
    private Integer tenantId;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "状态")
    private DragonTenantStatusEnum status;
}
