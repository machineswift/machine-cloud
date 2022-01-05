package com.machine.dragon.web.system.dictionary.controller.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class DragonEnumResponse {

    @ApiModelProperty(name = "code", value = "枚举编码", dataType = "int", required = true, position = 10, example = "0")
    private Integer code;

    @ApiModelProperty(name = "name", value = "枚举类型", dataType = "string", required = true, position = 20, example = "UNDEFINED")
    private String name;

    @ApiModelProperty(name = "msg", value = "枚举说明", dataType = "string", required = true, position = 30, example = "未知")
    private String msg;

}
