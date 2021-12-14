package com.machine.dragon.web.system.department.controller;

import com.machine.dragon.service.system.department.feign.DragonDepartmentClient;
import com.machine.dragon.service.system.department.feign.outvo.DragonDepartmentDetailOutVO;
import com.machine.dragon.service.system.menu.feign.DragonMenuClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "部门模块")
@Slf4j
@RefreshScope
@RestController
@RequestMapping("web/department")
public class DragonDepartmentController {

    @Value("${machine1}")
    private String machine1;

    @Autowired
    private DragonMenuClient dragonMenuClient;

    @Autowired
    private DragonDepartmentClient dragonDepartmentClient;

    @ApiOperation(value = "部门详情")
    @ApiImplicitParam(name = "departmentId", value = "部门Id", paramType = "long", required = true)
    @GetMapping("get")
    public String get(@RequestParam(value = "departmentId") Long departmentId) {
        String menu = dragonMenuClient.detail();
        DragonDepartmentDetailOutVO vo = dragonDepartmentClient.getByDepartmentId(departmentId);
        log.info(menu + machine1);
        return menu + vo.toString();
    }
}
