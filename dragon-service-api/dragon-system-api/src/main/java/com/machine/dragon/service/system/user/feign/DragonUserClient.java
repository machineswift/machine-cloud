package com.machine.dragon.service.system.user.feign;

import com.machine.dragon.service.system.user.feign.outvo.DragonUserDetailOutVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "dragon-system-service", path = "client/system/user")
public interface DragonUserClient {

    @GetMapping("getByUserId")
    DragonUserDetailOutVO getByUserId(@RequestParam(name = "userId") String userId);
}
