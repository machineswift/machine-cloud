package com.machine.dragon.service.crm.customer.feign;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RefreshScope
@RestController
@RequestMapping("client/customer")
public class DragonCustomerClientImpl implements DragonCustomerClient {

    @Value("${machine}")
    private String machine;

    @Override
    @GetMapping("detail")
    public String detail() {
        String customer = "customer " + machine;
        log.info(customer);
        return customer;
    }
}
