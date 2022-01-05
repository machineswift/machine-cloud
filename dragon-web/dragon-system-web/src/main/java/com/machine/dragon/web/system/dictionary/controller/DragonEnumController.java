package com.machine.dragon.web.system.dictionary.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.machine.dragon.web.system.dictionary.controller.request.DragonEnumResponse;
import com.machine.dragon.web.system.dictionary.fade.DragonEnumFade;
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

@Api(tags = "枚举模块")
@Slf4j
@RestController
@RequestMapping("enum")
public class DragonEnumController {

    @Autowired
    private DragonEnumFade dragonEnumFade;

    @ApiOperationSupport(order = 10)
    @ApiOperation(value = "查询枚举集合")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "departmentId", value = "部门Id", paramType = "integer", format = "int64", required = true)
    })
    @GetMapping("queryEnumList")
    public List<DragonEnumResponse> queryEnumList(@RequestParam(value = "enumName") String enumName) {
        return dragonEnumFade.queryEnumList(enumName);
    }
}
