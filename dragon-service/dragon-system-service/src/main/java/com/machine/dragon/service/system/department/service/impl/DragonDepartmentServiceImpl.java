package com.machine.dragon.service.system.department.service.impl;

import com.machine.dragon.common.tool.jackson.DragonJsonUtil;
import com.machine.dragon.service.system.department.dao.DragonDepartmentDao;
import com.machine.dragon.service.system.department.dao.outdto.DragonDepartmentOutDto;
import com.machine.dragon.service.system.department.service.DragonDepartmentService;
import com.machine.dragon.service.system.department.service.outBo.DragonDepartmentDetailOutBo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DragonDepartmentServiceImpl implements DragonDepartmentService {

    @Autowired
    private DragonDepartmentDao dragonDepartmentDao;

    @Override
    public DragonDepartmentDetailOutBo getByDepartmentId(Long departmentId) {
        DragonDepartmentOutDto outDto = dragonDepartmentDao.getByDepartmentId(departmentId);
        if (null == outDto) {
            return null;
        }
        return DragonJsonUtil.copy(outDto, DragonDepartmentDetailOutBo.class);
    }
}
