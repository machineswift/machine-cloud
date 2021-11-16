package com.machine.dragon.core.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "dragon-core", path = "core")
public interface IDragonCoreClient {

    @GetMapping("detail")
    String detail();
}
