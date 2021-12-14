package com.machine.dragon.web.system.tenant.fade.impl;

import com.machine.dragon.common.core.bean.tenant.DragonTenant;
import com.machine.dragon.common.tool.jackson.DragonJsonUtil;
import com.machine.dragon.service.system.tenant.feign.DragonTenantClient;
import com.machine.dragon.web.system.tenant.controller.response.DragonTenantResponse;
import com.machine.dragon.web.system.tenant.fade.DragonTenantFade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DragonTenantFadeImpl implements DragonTenantFade {

    @Autowired
    private DragonTenantClient dragonTenantClient;

    @Override
    public DragonTenantResponse describeTenantInfo(Integer tenantId) {
        DragonTenant dragonTenant = dragonTenantClient.getByTenantId(tenantId);
        return DragonJsonUtil.copy(dragonTenant, DragonTenantResponse.class);
    }
}
