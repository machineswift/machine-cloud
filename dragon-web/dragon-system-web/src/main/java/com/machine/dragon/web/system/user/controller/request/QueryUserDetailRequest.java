package com.machine.dragon.web.system.user.controller.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@ApiModel
@NoArgsConstructor
public class QueryUserDetailRequest  {

    @ApiModelProperty(name = "userId", value = "用户Id", dataType = "string", position = 10, required = true)
    private String userId;

}
