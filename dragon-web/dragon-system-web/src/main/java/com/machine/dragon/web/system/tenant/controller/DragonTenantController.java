package com.machine.dragon.web.system.tenant.controller;

import com.machine.dragon.web.system.tenant.controller.response.DragonTenantResponse;
import com.machine.dragon.web.system.tenant.fade.DragonTenantFade;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "租户模块")
@Slf4j
@RefreshScope
@RestController
@RequestMapping("web/tenant")
public class DragonTenantController {

    @Autowired
    private DragonTenantFade dragonTenantFade;

    @ApiOperation(value = "查询一个租户信息")
    @ApiImplicitParam(name = "tenantId", value = "租户ID", paramType = "integer", format = "int32", required = true)
    @GetMapping("describeTenantInfo")
    public DragonTenantResponse describeTenantInfo(@RequestParam(value = "tenantId") Integer tenantId) {
        return dragonTenantFade.describeTenantInfo(tenantId);
    }
}
