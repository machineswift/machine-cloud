package com.machine.dragon.service.system.tenant.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.machine.dragon.common.core.bean.tenant.DragonTenant;
import com.machine.dragon.common.tool.jackson.DragonJsonUtil;
import com.machine.dragon.service.system.tenant.dao.DragontenantDao;
import com.machine.dragon.service.system.tenant.dao.outdto.DragonTenantListOutDTO;
import com.machine.dragon.service.system.tenant.resource.query.DragonTenantPageQuery;
import com.machine.dragon.service.system.tenant.service.DragonTenantService;
import com.machine.dragon.service.system.tenant.service.outbo.DragonTenantListOutBO;
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

    @Override
    public Page<DragonTenantListOutBO> selectTenantPage(DragonTenantPageQuery query) {
        Page<DragonTenantListOutDTO> outDTOIPage = dragontenantDao.selectTenantPage(query);
        return DragonJsonUtil.convertT1ToT2(outDTOIPage, DragonTenantListOutBO.class);
    }
}
