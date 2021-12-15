package com.machine.dragon.web.system.tenant.fade.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.machine.dragon.common.core.bean.tenant.DragonTenant;
import com.machine.dragon.common.tool.jackson.DragonJsonUtil;
import com.machine.dragon.service.system.tenant.feign.DragonTenantClient;
import com.machine.dragon.service.system.tenant.feign.query.DragonTenantPageQuery;
import com.machine.dragon.web.system.tenant.controller.request.QueryTenantPageRequest;
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
    public DragonTenantResponse queryTenantDetail(Integer tenantId) {
        DragonTenant dragonTenant = dragonTenantClient.getByTenantId(tenantId);
        return DragonJsonUtil.copy(dragonTenant, DragonTenantResponse.class);
    }

    @Override
    public IPage<DragonTenantResponse> queryTenantPage(QueryTenantPageRequest request) {
        DragonTenantPageQuery query = DragonJsonUtil.copy(request, DragonTenantPageQuery.class);
        return null;
    }
}
