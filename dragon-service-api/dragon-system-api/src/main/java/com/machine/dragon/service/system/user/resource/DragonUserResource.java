package com.machine.dragon.service.system.user.resource;

import com.machine.dragon.service.system.user.resource.outvo.DragonUserDetailOutVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "dragon-system-service", path = "user")
public interface DragonUserResource {

    @GetMapping("getByUserId")
    DragonUserDetailOutVO getByUserId(@RequestParam(name = "userId") String userId);
}
