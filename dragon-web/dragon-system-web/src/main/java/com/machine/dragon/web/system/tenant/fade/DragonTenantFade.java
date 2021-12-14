package com.machine.dragon.web.system.tenant.fade;

import com.machine.dragon.web.system.tenant.controller.response.DragonTenantResponse;

public interface DragonTenantFade {
    DragonTenantResponse describeTenantInfo(Integer tenantId);
}
