package com.machine.dragon.web.system.department.fade.impl;

import com.machine.dragon.common.tool.jackson.DragonJsonUtil;
import com.machine.dragon.service.system.department.feign.DragonDepartmentClient;
import com.machine.dragon.service.system.department.feign.outvo.DragonDepartmentDetailOutVO;
import com.machine.dragon.web.system.department.controller.response.DragonDepartmentDetailResponse;
import com.machine.dragon.web.system.department.fade.DragonDepartmentFade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DragonDepartmentFadeImpl implements DragonDepartmentFade {

    @Autowired
    private DragonDepartmentClient dragonDepartmentClient;

    @Override
    public DragonDepartmentDetailResponse queryDepartmentDetail(Long departmentId) {
        DragonDepartmentDetailOutVO detailOutVO = dragonDepartmentClient.getByDepartmentId(departmentId);
        return DragonJsonUtil.copy(detailOutVO, DragonDepartmentDetailResponse.class);
    }
}
