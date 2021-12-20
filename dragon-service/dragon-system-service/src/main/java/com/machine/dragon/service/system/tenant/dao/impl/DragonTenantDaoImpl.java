package com.machine.dragon.service.system.tenant.dao.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.machine.dragon.common.core.bean.tenant.DragonTenant;
import com.machine.dragon.common.tool.jackson.DragonJsonUtil;
import com.machine.dragon.service.system.tenant.dao.DragontenantDao;
import com.machine.dragon.service.system.tenant.dao.outdto.DragonTenantListOutDTO;
import com.machine.dragon.service.system.tenant.resource.query.DragonTenantPageQuery;
import com.machine.dragon.service.system.tenant.mapper.DragonTenantMapper;
import com.machine.dragon.service.system.tenant.mapper.entity.DragonTenantEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DragonTenantDaoImpl implements DragontenantDao {

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

    @Override
    public Page<DragonTenantListOutDTO> selectTenantPage(DragonTenantPageQuery query) {
        Page<DragonTenantEntity> page = new Page(query.getCurrent(), query.getSize());
        IPage<DragonTenantEntity> entityIPage = dragonTenantMapper.selectTenantPage(page, query);
        return DragonJsonUtil.convertT1ToT2(entityIPage, DragonTenantListOutDTO.class);
    }
}
