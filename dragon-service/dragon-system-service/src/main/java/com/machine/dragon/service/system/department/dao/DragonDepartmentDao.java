package com.machine.dragon.service.system.department.dao;

import com.machine.dragon.service.system.department.dao.outdto.DragonDepartmentOutDTO;

public interface DragonDepartmentDao  {

    DragonDepartmentOutDTO getByDepartmentId(Long departmentId);
}
