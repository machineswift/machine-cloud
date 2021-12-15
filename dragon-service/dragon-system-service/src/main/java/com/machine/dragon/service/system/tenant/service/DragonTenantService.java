package com.machine.dragon.service.system.tenant.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.machine.dragon.common.core.bean.tenant.DragonTenant;
import com.machine.dragon.service.system.tenant.feign.query.DragonTenantPageQuery;
import com.machine.dragon.service.system.tenant.service.outbo.DragonTenantListOutBO;

public interface DragonTenantService {
    DragonTenant getByTenantId(Integer tenantId);

    Page<DragonTenantListOutBO> selectTenantPage(DragonTenantPageQuery query);
}
