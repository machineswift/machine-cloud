package com.machine.dragon.service.system.department.service.impl;

import com.machine.dragon.common.tool.jackson.DragonJsonUtil;
import com.machine.dragon.sdk.isc.rabbit.department.message.DragonDepartmentRabbitMessage;
import com.machine.dragon.sdk.isc.rabbit.department.publish.DragonDepartmentPublish;
import com.machine.dragon.service.system.department.dao.DragonDepartmentDao;
import com.machine.dragon.service.system.department.dao.outdto.DragonDepartmentOutDTO;
import com.machine.dragon.service.system.department.service.DragonDepartmentService;
import com.machine.dragon.service.system.department.service.outbo.DragonDepartmentDetailOutBO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DragonDepartmentServiceImpl implements DragonDepartmentService {

    @Autowired
    private DragonDepartmentDao dragonDepartmentDao;

    @Autowired
    private DragonDepartmentPublish dragonDepartmentPublish;

    @Override
    public DragonDepartmentDetailOutBO getByDepartmentId(Long departmentId) {
        DragonDepartmentOutDTO outDto = dragonDepartmentDao.getByDepartmentId(departmentId);
        dragonDepartmentPublish.publishDragonDepartmentRabbitMessage(new DragonDepartmentRabbitMessage(departmentId));
        return DragonJsonUtil.copy(outDto, DragonDepartmentDetailOutBO.class);
    }
}
