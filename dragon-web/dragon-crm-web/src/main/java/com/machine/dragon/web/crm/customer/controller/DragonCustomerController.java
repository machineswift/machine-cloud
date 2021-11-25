package com.machine.dragon.web.crm.customer.controller;

import com.machine.dragon.service.crm.customer.feign.DragonCustomerClient;
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
@RequestMapping("web/customer")
public class DragonCustomerController {

    @Value("${machine1}")
    private String machine1;

    @Value("${machine2}")
    private String machine2;

    @Autowired
    private DragonCustomerClient dragonCustomerClient;

    @GetMapping("get")
    public String get() {
        String helloWorld = dragonCustomerClient.detail();
        log.info(helloWorld + machine2 + machine1);
        return helloWorld;
    }
}
