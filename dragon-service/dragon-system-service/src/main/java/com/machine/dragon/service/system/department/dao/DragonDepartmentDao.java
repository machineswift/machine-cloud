package com.machine.dragon.service.system.department.dao;

import com.machine.dragon.service.system.department.dao.outdto.DragonDepartmentOutDto;

public interface DragonDepartmentDao  {

    DragonDepartmentOutDto getByDepartmentId(Long departmentId);
}
