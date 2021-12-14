package com.machine.dragon.service.system.tenant.service.impl;

import com.machine.dragon.common.core.bean.tenant.DragonTenant;
import com.machine.dragon.service.system.tenant.dao.DragontenantDao;
import com.machine.dragon.service.system.tenant.service.DragonTenantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DragonTenantServiceImpl implements DragonTenantService {

    @Autowired
    private DragontenantDao dragontenantDao;

    @Override
    public DragonTenant getByTenantId(Integer tenantId) {
        return dragontenantDao.getByTenantId(tenantId);
    }
}
