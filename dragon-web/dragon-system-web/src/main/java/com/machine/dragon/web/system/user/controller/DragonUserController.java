package com.machine.dragon.web.system.user.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.machine.dragon.common.tool.string.DragonStringUtil;
import com.machine.dragon.web.system.user.controller.request.QueryUserDetailRequest;
import com.machine.dragon.web.system.user.controller.response.DragonUserDetailResponse;
import com.machine.dragon.web.system.user.fade.DragonUserFade;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "角色模块")
@Slf4j
@RestController
@RequestMapping("web/user")
public class DragonUserController {

    @Autowired
    private DragonUserFade dragonUserFade;

    @ApiOperationSupport(order = 10)
    @ApiOperation(value = "查询一个用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "request", value = "用户明细", dataType = "QueryUserDetailRequest", paramType = "body", required = true)
    })
    @PostMapping("queryUserDetail")
    public DragonUserDetailResponse queryRoleDetail(@RequestBody QueryUserDetailRequest request) {
        request.setUserId(DragonStringUtil.escapeStr(request.getUserId()));
        return dragonUserFade.queryUserDetail(request);
    }

}
