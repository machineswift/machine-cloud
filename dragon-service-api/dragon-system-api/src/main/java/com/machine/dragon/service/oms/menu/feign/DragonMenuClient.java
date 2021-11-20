package com.machine.dragon.service.oms.menu.feign;

import com.machine.dragon.common.launch.constant.DragonAppConstant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = DragonAppConstant.APPLICATION_SYSTEM_NAME, path = "client/menu")
public interface DragonMenuClient {

    @GetMapping("detail")
    String detail();

}
