package com.machine.dragon.service.system.tenant.service;

import com.machine.dragon.common.core.bean.tenant.DragonTenant;

public interface DragonTenantService {
    DragonTenant getByTenantId(Integer tenantId);
}
