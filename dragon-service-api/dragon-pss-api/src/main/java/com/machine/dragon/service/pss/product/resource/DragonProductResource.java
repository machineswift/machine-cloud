package com.machine.dragon.service.pss.product.resource;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value ="dragon-pss-service", path = "client/pss/product")
public interface DragonProductResource {

    @GetMapping("detail")
    String detail();

}
