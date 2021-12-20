package com.machine.dragon.service.system.menu.resource;

import com.machine.dragon.service.system.menu.resource.outvo.DragonMenuDetailOutVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "dragon-system-service", path = "client/system/menu")
public interface DragonMenuResource {

    @GetMapping("getByMenuId")
    DragonMenuDetailOutVO getByMenuId(@RequestParam(name = "menuId") Long menuId);
}
