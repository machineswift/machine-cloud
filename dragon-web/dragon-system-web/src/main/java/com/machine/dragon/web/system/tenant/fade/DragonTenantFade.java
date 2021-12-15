package com.machine.dragon.web.system.tenant.fade;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.machine.dragon.web.system.tenant.controller.request.QueryTenantPageRequest;
import com.machine.dragon.web.system.tenant.controller.response.DragonTenantResponse;

public interface DragonTenantFade {
    DragonTenantResponse queryTenantDetail(Integer tenantId);

    Page<DragonTenantResponse> queryTenantPage(QueryTenantPageRequest request);
}
