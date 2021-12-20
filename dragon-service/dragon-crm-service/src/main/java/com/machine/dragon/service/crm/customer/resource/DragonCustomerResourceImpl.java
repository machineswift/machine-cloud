package com.machine.dragon.service.crm.customer.resource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RefreshScope
@RestController
@RequestMapping("client/crm/customer")
public class DragonCustomerResourceImpl implements DragonCustomerResource {

    @Override
    @GetMapping("detail")
    public String detail() {
        String customer = "customer";
        log.info(customer);
        return customer;
    }
}
