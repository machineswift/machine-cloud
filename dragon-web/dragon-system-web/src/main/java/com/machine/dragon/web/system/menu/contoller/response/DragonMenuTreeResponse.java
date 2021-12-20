package com.machine.dragon.web.system.menu.contoller.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@ApiModel
@NoArgsConstructor
public class DragonMenuTreeResponse {

    @ApiModelProperty(name = "menuId", value = "菜单Id", dataType = "long", position = 10)
    private Long menuId;

    @ApiModelProperty(name = "parentId", value = "父菜单Id", dataType = "long", position = 20)
    private Long parentId;

    @ApiModelProperty(name = "code", value = "编码", dataType = "string", position = 30)
    private String code;

    @ApiModelProperty(name = "name", value = "名称", dataType = "string", position = 40)
    private String name;

    @ApiModelProperty(value = "排序", position = 60)
    private Integer sort;

    @ApiModelProperty(value = "是否打开新页面", position = 70)
    private Boolean opened;

    @ApiModelProperty(value = "是否有子孙节点", position = 80)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Boolean hasChildren;

    @ApiModelProperty(value = "子菜单", position = 90)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<DragonMenuTreeResponse> children;
}
