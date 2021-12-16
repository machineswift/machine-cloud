package com.machine.dragon.web.system.department.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.machine.dragon.web.system.department.controller.response.DragonDepartmentDetailResponse;
import com.machine.dragon.web.system.department.fade.DragonDepartmentFade;
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

@Api(tags = "部门模块")
@Slf4j
@RestController
@RequestMapping("web/department")
public class DragonDepartmentController {

    @Autowired
    private DragonDepartmentFade dragonDepartmentFade;

    @ApiOperationSupport(order = 10)
    @ApiOperation(value = "查询一个部门信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "departmentId", value = "部门Id", paramType = "integer", format = "int64", required = true)
    })
    @GetMapping("queryDepartmentDetail")
    public DragonDepartmentDetailResponse queryDepartmentDetail(@RequestParam(value = "departmentId") Long departmentId) {
        return dragonDepartmentFade.queryDepartmentDetail(departmentId);
    }
}
