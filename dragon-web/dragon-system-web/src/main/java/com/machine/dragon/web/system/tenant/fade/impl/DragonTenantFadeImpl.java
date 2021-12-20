package com.machine.dragon.web.system.tenant.fade.impl;

import com.machine.dragon.common.core.bean.page.DragonPage;
import com.machine.dragon.common.core.bean.tenant.DragonTenant;
import com.machine.dragon.common.tool.jackson.DragonJsonUtil;
import com.machine.dragon.service.system.tenant.resource.DragonTenantResource;
import com.machine.dragon.service.system.tenant.resource.outvo.DragonTenantListOutVO;
import com.machine.dragon.service.system.tenant.resource.query.DragonTenantPageQuery;
import com.machine.dragon.web.system.tenant.controller.request.QueryTenantPageRequest;
import com.machine.dragon.web.system.tenant.controller.response.DragonTenantDetailResponse;
import com.machine.dragon.web.system.tenant.controller.response.DragonTenantResponse;
import com.machine.dragon.web.system.tenant.fade.DragonTenantFade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DragonTenantFadeImpl implements DragonTenantFade {

    @Autowired
    private DragonTenantResource dragonTenantResource;

    @Override
    public DragonTenantDetailResponse queryTenantDetail(Integer tenantId) {
        DragonTenant dragonTenant = dragonTenantResource.getByTenantId(tenantId);
        return DragonJsonUtil.copy(dragonTenant, DragonTenantDetailResponse.class);
    }

    @Override
    public DragonPage<DragonTenantResponse> queryTenantPage(QueryTenantPageRequest request) {
        DragonTenantPageQuery query = DragonJsonUtil.copy(request, DragonTenantPageQuery.class);
        DragonPage<DragonTenantListOutVO> outVOIPage = dragonTenantResource.selectTenantPage(query);
        return DragonJsonUtil.convertT1ToT2(outVOIPage, DragonTenantResponse.class);
    }
}
