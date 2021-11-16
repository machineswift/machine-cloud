package com.machine.dragon.core.feign;

import com.machine.dragon.common.launch.constant.DragonAppConstant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = DragonAppConstant.APPLICATION_CORE_NAME, path = "core")
public interface IDragonCoreClient {

    @GetMapping("detail")
    String detail();
}
