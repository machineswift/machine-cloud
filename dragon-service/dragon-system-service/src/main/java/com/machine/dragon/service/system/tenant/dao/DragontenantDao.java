package com.machine.dragon.service.system.tenant.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.machine.dragon.common.core.bean.tenant.DragonTenant;
import com.machine.dragon.service.system.tenant.dao.outdto.DragonTenantListOutDTO;
import com.machine.dragon.service.system.tenant.feign.query.DragonTenantPageQuery;

public interface DragontenantDao {

    DragonTenant getByTenantId(Integer tenantId);

    Page<DragonTenantListOutDTO> selectTenantPage(DragonTenantPageQuery query);
}
