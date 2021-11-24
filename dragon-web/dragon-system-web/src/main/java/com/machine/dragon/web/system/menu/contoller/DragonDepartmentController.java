package com.machine.dragon.web.system.menu.contoller;

import com.machine.dragon.service.crm.customer.feign.DragonCustomerClient;
import com.machine.dragon.service.system.menu.feign.DragonMenuClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RefreshScope
@RestController
@RequestMapping("web/department")
public class DragonDepartmentController {

    @Value("${machine}")
    private String machine;

    @Value("${machine1}")
    private String machine1;

    @Autowired
    private DragonMenuClient dragonMenuClient;

    @Autowired
    private DragonCustomerClient dragonCustomerClient;

    @GetMapping("get")
    public String get() {
        String menu = dragonMenuClient.detail();
        String customer = dragonCustomerClient.detail();
        log.info(menu + customer + machine + machine1);
        return menu + customer;
    }
}