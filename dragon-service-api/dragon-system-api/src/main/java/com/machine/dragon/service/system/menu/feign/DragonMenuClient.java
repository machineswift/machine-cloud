package com.machine.dragon.service.system.menu.feign;

import com.machine.dragon.service.system.menu.feign.outvo.DragonMenuDetailOutVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "dragon-system-service", path = "client/system/menu")
public interface DragonMenuClient {

    @GetMapping("getByMenuId")
    DragonMenuDetailOutVO getByMenuId(@RequestParam(name = "menuId") Long menuId);
}
