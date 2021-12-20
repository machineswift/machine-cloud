package com.machine.dragon.service.crm.customer.resource;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "dragon-crm-service", path = "client/crm/customer", fallback = DragonCustomerResourceFallBack.class)
public interface DragonCustomerResource {

    @GetMapping("detail")
    String detail();

}
