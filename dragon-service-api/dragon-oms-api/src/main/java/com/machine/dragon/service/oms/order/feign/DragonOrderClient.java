package com.machine.dragon.service.oms.order.feign;

import com.machine.dragon.common.launch.constant.DragonAppConstant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = DragonAppConstant.APPLICATION_OMS_NAME, path = "client/order")
public interface DragonOrderClient {

    @GetMapping("detail")
    String detail();

}
