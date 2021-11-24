package com.machine.dragon.service.system.department.feign;

import com.machine.dragon.service.system.department.feign.outVo.DragonDepartmentDetailOutVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "dragon-system-service", path = "client/system/department")
public interface DragonDepartmentClient {

    @GetMapping("getById")
    DragonDepartmentDetailOutVo getById(@RequestParam(name = "id") Long id);
}
