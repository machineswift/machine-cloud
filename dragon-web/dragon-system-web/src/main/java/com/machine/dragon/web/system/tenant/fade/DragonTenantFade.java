package com.machine.dragon.web.system.tenant.fade;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.machine.dragon.web.system.tenant.controller.request.QueryTenantPageRequest;
import com.machine.dragon.web.system.tenant.controller.response.DragonTenantResponse;

public interface DragonTenantFade {
    DragonTenantResponse queryTenantDetail(Integer tenantId);

    IPage<DragonTenantResponse> queryTenantPage(QueryTenantPageRequest request);
}
