package com.machine.dragon.service.core.demo.feign;

import com.machine.dragon.common.launch.constant.DragonAppConstant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = DragonAppConstant.APPLICATION_CORE_NAME, path = "demo")
public interface IDragonCoreClient {

    @GetMapping("detail")
    String detail();
}
