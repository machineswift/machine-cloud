package com.machine.dragon.web.system.role.fade.impl;

import com.machine.dragon.common.tool.jackson.DragonJsonUtil;
import com.machine.dragon.service.system.role.feign.DragonRoleClient;
import com.machine.dragon.service.system.role.feign.outvo.DragonRoleDetailOutVO;
import com.machine.dragon.web.system.role.controller.response.DragonRoleDetailResponse;
import com.machine.dragon.web.system.role.fade.DragonRoleFade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DragonRoleFadeImpl implements DragonRoleFade {

    @Autowired
    private DragonRoleClient dragonRoleClient;

    @Override
    public DragonRoleDetailResponse queryRoleDetail(Long roleId) {
        DragonRoleDetailOutVO detailOutVO = dragonRoleClient.getByRoleId(roleId);
        return DragonJsonUtil.copy(detailOutVO, DragonRoleDetailResponse.class);
    }

}
