package com.machine.dragon.service.system.department.service;

import com.machine.dragon.service.system.department.service.outBo.DragonDepartmentDetailOutBo;

public interface DragonDepartmentService {
    DragonDepartmentDetailOutBo getByDepartmentId(Long departmentId);
}
