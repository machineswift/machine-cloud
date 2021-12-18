package com.machine.dragon.web.system.user.controller.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@ApiModel
@NoArgsConstructor
public class DragonUserDetailResponse {

    @ApiModelProperty(name = "userId", value = "用户Id", dataType = "string", position = 10)
    private String userId;

    @ApiModelProperty(name = "account", value = "账号", dataType = "string", position = 20)
    private String account;

    @ApiModelProperty(name = "code", value = "编码", dataType = "string", position = 30)
    private String code;

    @ApiModelProperty(name = "name", value = "名称", dataType = "string", position = 40)
    private String name;

    @ApiModelProperty(name = "createTime", value = "创建时间", dataType = "long", position = 50)
    private Long createTime;

    @ApiModelProperty(name = "updateTime", value = "更新时间", dataType = "long", position = 60)
    private Long updateTime;
}
