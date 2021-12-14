package com.machine.dragon.service.system.tenant.dao;

import com.machine.dragon.common.core.bean.tenant.DragonTenant;

public interface DragontenantDao {

    DragonTenant getByTenantId(Integer tenantId);
}
