package com.machine.dragon.service.system.menu.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
@FeignClient(value = "dragon-system-service", path = "client/system/menu")
public interface DragonMenuClient {

    @GetMapping("detail")
    String detail();

}
