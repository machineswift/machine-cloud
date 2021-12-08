package com.machine.dragon.service.system.department.service;

import com.machine.dragon.service.system.department.service.outBo.DragonDepartmentDetailOutBO;

public interface DragonDepartmentService {
    DragonDepartmentDetailOutBO getByDepartmentId(Long departmentId);
}
