package com.machine.dragon.service.crm.customer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "dragon-crm-service", path = "client/crm/customer", fallback = DragonCustomerClientFallBack.class)
public interface DragonCustomerClient {

    @GetMapping("detail")
    String detail();

}
