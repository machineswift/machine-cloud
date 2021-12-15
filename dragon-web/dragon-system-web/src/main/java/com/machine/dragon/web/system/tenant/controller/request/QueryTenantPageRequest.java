package com.machine.dragon.web.system.tenant.controller.request;

import com.machine.dragon.common.core.bean.page.DragonBasePageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@ApiModel
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class QueryTenantPageRequest extends DragonBasePageQuery {

    @ApiModelProperty(name = "name", value = "名称", dataType = "string", position = 10, required = false)
    private String name;

}
