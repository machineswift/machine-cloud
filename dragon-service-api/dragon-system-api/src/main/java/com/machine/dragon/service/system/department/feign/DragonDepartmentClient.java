package com.machine.dragon.service.system.department.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "dragon-system-service", path = "client/system/department")
public interface DragonDepartmentClient {
    @GetMapping("detail")
    String detail();
}
