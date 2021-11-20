package com.machine.dragon.service.crm.customer.feign;

import com.machine.dragon.common.launch.constant.DragonAppConstant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = DragonAppConstant.APPLICATION_CRM_NAME, path = "client/customer")
public interface DragonCustomerClient {

    @GetMapping("detail")
    String detail();

}
