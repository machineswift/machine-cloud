package com.machine.dragon.service.system.tenant.dao.impl;

import com.machine.dragon.common.core.bean.tenant.DragonTenant;
import com.machine.dragon.common.tool.jackson.DragonJsonUtil;
import com.machine.dragon.service.system.tenant.dao.DragontenantDao;
import com.machine.dragon.service.system.tenant.mapper.DragonTenantMapper;
import com.machine.dragon.service.system.tenant.mapper.entity.DragonTenantEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DragonTanantDaoImpl implements DragontenantDao {

    @Autowired
    private DragonTenantMapper dragonTenantMapper;

    @Override
    public DragonTenant getByTenantId(Integer tenantId) {
        DragonTenantEntity entity = dragonTenantMapper.selectByTenantId(tenantId);
        if (null == entity) {
            return null;
        }
        return DragonJsonUtil.copy(entity, DragonTenant.class);
    }
}
