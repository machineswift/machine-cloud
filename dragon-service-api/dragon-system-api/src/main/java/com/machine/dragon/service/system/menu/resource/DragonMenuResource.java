package com.machine.dragon.service.system.menu.resource;

import com.machine.dragon.service.system.menu.resource.outvo.DragonMenuDetailOutVO;
import com.machine.dragon.service.system.menu.resource.outvo.DragonMenuListOutVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "dragon-system-service", path = "menu")
public interface DragonMenuResource {

    @GetMapping("getByMenuId")
    DragonMenuDetailOutVO getByMenuId(@RequestParam(name = "menuId") Long menuId);

    @GetMapping("selectMenuList")
    List<DragonMenuListOutVO> selectMenuList();
}
