package com.machine.dragon.web.system.tenant.fade;

import com.machine.dragon.common.core.bean.page.DragonPage;
import com.machine.dragon.web.system.tenant.controller.request.QueryTenantPageRequest;
import com.machine.dragon.web.system.tenant.controller.response.DragonTenantResponse;

public interface DragonTenantFade {
    DragonTenantResponse queryTenantDetail(Integer tenantId);

    DragonPage<DragonTenantResponse> queryTenantPage(QueryTenantPageRequest request);
}
