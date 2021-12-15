package com.machine.dragon.common.core.bean.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public abstract class DragonBasePage {
    @ApiModelProperty(name = "current", value = "当前页(默认1)", dataType = "int", position = Integer.MAX_VALUE, required = true)
    private Integer current = 1;

    @ApiModelProperty(name = "current", value = "每页的数量(默认10)", dataType = "int", position = Integer.MAX_VALUE, required = true)
    private Integer size = 10;
}
