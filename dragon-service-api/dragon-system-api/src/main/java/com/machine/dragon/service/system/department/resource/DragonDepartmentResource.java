package com.machine.dragon.service.system.department.resource;

import com.machine.dragon.service.system.department.resource.outvo.DragonDepartmentDetailOutVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "dragon-system-service", path = "client/system/department")
public interface DragonDepartmentResource {

    @GetMapping("getByDepartmentId")
    DragonDepartmentDetailOutVO getByDepartmentId(@RequestParam(name = "departmentId") Long departmentId);
}
