package com.machine.dragon.service.pss.product.feign;

import com.machine.dragon.common.launch.constant.DragonAppConstant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = DragonAppConstant.APPLICATION_PSS_NAME, path = "client/product")
public interface DragonProductClient {

    @GetMapping("detail")
    String detail();

}
