package com.machine.dragon.web.system.menu.contoller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.machine.dragon.web.system.menu.contoller.response.DragonMenuDetailResponse;
import com.machine.dragon.web.system.menu.contoller.response.DragonMenuTreeResponse;
import com.machine.dragon.web.system.menu.fade.DragonMenuFade;
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

import java.util.List;

@Api(tags = "菜单模块")
@Slf4j
@RestController
@RequestMapping("menu")
public class DragonMenuController {

    @Autowired
    private DragonMenuFade dragonMenuFade;

    @ApiOperationSupport(order = 10)
    @ApiOperation(value = "查询一个菜单信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "menuId", value = "菜单ID", paramType = "integer", format = "int32", required = true)
    })
    @GetMapping("queryMenuDetail")
    public DragonMenuDetailResponse queryMenuDetail(@RequestParam(value = "menuId") Long menuId) {
        return dragonMenuFade.queryMenuDetail(menuId);
    }

    @ApiOperationSupport(order = 10)
    @ApiOperation(value = "查询菜单树")
    @GetMapping("queryMenuTree")
    public List<DragonMenuTreeResponse> queryMenuTree() {
        return dragonMenuFade.queryMenuTree();
    }

}
