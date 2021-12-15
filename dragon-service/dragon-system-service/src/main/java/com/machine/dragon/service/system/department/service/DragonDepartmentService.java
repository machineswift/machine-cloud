package com.machine.dragon.service.system.department.service;

import com.machine.dragon.service.system.department.service.outbo.DragonDepartmentDetailOutBO;

public interface DragonDepartmentService {
    DragonDepartmentDetailOutBO getByDepartmentId(Long departmentId);
}
