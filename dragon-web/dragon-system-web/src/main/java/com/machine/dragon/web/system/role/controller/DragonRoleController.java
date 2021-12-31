package com.machine.dragon.web.system.role.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.machine.dragon.web.system.role.controller.response.DragonRoleDetailResponse;
import com.machine.dragon.web.system.role.fade.DragonRoleFade;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Api(tags = "角色模块")
@Slf4j
@RestController
@RequestMapping("role")
public class DragonRoleController {

    @Autowired
    private DragonRoleFade dragonRoleFade;

    @ApiOperationSupport(order = 10)
    @ApiOperation(value = "查询一个角色信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "roleId", value = "角色ID", paramType = "integer", format = "int64", required = true)
    })
    @GetMapping("queryRoleDetail")
    public DragonRoleDetailResponse queryRoleDetail(@RequestParam(value = "roleId") Long roleId) {
        return dragonRoleFade.queryRoleDetail(roleId);
    }
}
