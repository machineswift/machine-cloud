package com.machine.dragon.web.system.tenant.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.machine.dragon.common.core.bean.page.DragonPage;
import com.machine.dragon.common.tool.string.DragonStringUtil;
import com.machine.dragon.web.system.tenant.controller.request.QueryTenantPageRequest;
import com.machine.dragon.web.system.tenant.controller.response.DragonTenantResponse;
import com.machine.dragon.web.system.tenant.fade.DragonTenantFade;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(tags = "租户模块")
@Slf4j
@RestController
@RequestMapping("web/tenant")
public class DragonTenantController {

    @Autowired
    private DragonTenantFade dragonTenantFade;

    @ApiOperationSupport(order = 10)
    @ApiOperation(value = "查询一个租户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "tenantId", value = "租户ID", paramType = "integer", format = "int32", required = true)
    })
    @GetMapping("queryTenantDetail")
    public DragonTenantResponse describeTenantInfo(@RequestParam(value = "tenantId") Integer tenantId) {
        return dragonTenantFade.queryTenantDetail(tenantId);
    }

    @ApiOperationSupport(order = 20)
    @ApiOperation(value = "分页查询租户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "request", value = "分页查询", dataType = "QueryTenantPageRequest", paramType = "body", required = true)
    })
    @PostMapping("queryTenantPage")
    public DragonPage<DragonTenantResponse> queryTenantPage(@RequestBody @Validated QueryTenantPageRequest request) {
        request.setName(DragonStringUtil.escapeStr(request.getName()));
        return dragonTenantFade.queryTenantPage(request);
    }
}
