package com.machine.dragon.web.crm.customer.controller;

import com.machine.dragon.service.crm.customer.feign.DragonCustomerClient;
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

@Api(tags = "客户模块")
@Slf4j
@RefreshScope
@RestController
@RequestMapping("web/customer")
public class DragonCustomerController {

    @Value("${machine1}")
    private String machine1;

    @Autowired
    private DragonCustomerClient dragonCustomerClient;

    @ApiOperation(value = "部门详情")
    @ApiImplicitParam(name = "departmentId", value = "部门Id", paramType = "string", required = true)
    @GetMapping("get")
    public String get(@RequestParam(value = "customerId") String customerId) {
        String helloWorld = dragonCustomerClient.detail();
        log.info(helloWorld + machine1);
        return helloWorld;
    }
}
