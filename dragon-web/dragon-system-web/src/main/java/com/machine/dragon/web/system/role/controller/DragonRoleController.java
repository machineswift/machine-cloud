package com.machine.dragon.web.system.role.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.machine.dragon.common.core.bean.page.DragonPage;
import com.machine.dragon.common.tool.string.DragonStringUtil;
import com.machine.dragon.web.system.role.controller.request.QueryRolePageRequest;
import com.machine.dragon.web.system.role.controller.response.DragonRoleDetailResponse;
import com.machine.dragon.web.system.role.controller.response.DragonRoleListResponse;
import com.machine.dragon.web.system.role.fade.DragonRoleFade;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperationSupport(order = 20)
    @ApiOperation(value = "分页查询角色信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "request", value = "分页查询", dataType = "QueryRolePageRequest", paramType = "body", required = true)
    })
    @PostMapping("queryRolePage")
    public DragonPage<DragonRoleListResponse> queryRolePage(@RequestBody @Validated QueryRolePageRequest request) {
        log.info("分页查询角色信息 :{}", request);
        request.setName(DragonStringUtil.escapeStr(request.getName()));
        return dragonRoleFade.queryRolePage(request);
    }
}
