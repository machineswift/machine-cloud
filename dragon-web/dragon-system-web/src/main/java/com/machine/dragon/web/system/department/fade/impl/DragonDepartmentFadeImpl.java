package com.machine.dragon.web.system.department.fade.impl;

import com.machine.dragon.common.tool.jackson.DragonJsonUtil;
import com.machine.dragon.service.system.department.resource.DragonDepartmentResource;
import com.machine.dragon.service.system.department.resource.outvo.DragonDepartmentDetailOutVO;
import com.machine.dragon.web.system.department.controller.response.DragonDepartmentDetailResponse;
import com.machine.dragon.web.system.department.fade.DragonDepartmentFade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DragonDepartmentFadeImpl implements DragonDepartmentFade {

    @Autowired
    private DragonDepartmentResource dragonDepartmentResource;

    @Override
    public DragonDepartmentDetailResponse queryDepartmentDetail(Long departmentId) {
        DragonDepartmentDetailOutVO detailOutVO = dragonDepartmentResource.getByDepartmentId(departmentId);
        return DragonJsonUtil.copy(detailOutVO, DragonDepartmentDetailResponse.class);
    }
}
