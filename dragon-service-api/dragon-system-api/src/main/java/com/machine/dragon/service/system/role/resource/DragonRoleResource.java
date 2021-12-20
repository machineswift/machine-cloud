package com.machine.dragon.service.system.role.resource;

import com.machine.dragon.service.system.role.resource.outvo.DragonRoleDetailOutVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "dragon-system-service", path = "role")
public interface DragonRoleResource {

    @GetMapping("getByRoleId")
    DragonRoleDetailOutVO getByRoleId(@RequestParam(name = "roleId") Long roleId);
}
