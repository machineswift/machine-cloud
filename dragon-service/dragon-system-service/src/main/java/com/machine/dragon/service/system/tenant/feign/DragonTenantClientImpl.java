package com.machine.dragon.service.system.tenant.feign;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.machine.dragon.common.core.bean.page.DragonPage;
import com.machine.dragon.common.core.bean.tenant.DragonTenant;
import com.machine.dragon.common.tool.jackson.DragonJsonUtil;
import com.machine.dragon.service.system.tenant.feign.outvo.DragonTenantListOutVO;
import com.machine.dragon.service.system.tenant.feign.query.DragonTenantPageQuery;
import com.machine.dragon.service.system.tenant.service.DragonTenantService;
import com.machine.dragon.service.system.tenant.service.outbo.DragonTenantListOutBO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RefreshScope
@RestController
@RequestMapping("client/system/tenant")
public class DragonTenantClientImpl implements DragonTenantClient {

    @Autowired
    private DragonTenantService dragonTenantService;

    @Override
    @GetMapping("getByTenantId")
    public DragonTenant getByTenantId(Integer tenantId) {
        return dragonTenantService.getByTenantId(tenantId);
    }

    @Override
    public DragonPage<DragonTenantListOutVO> selectTenantPage(DragonTenantPageQuery query) {
        Page<DragonTenantListOutBO> outBOIPage = dragonTenantService.selectTenantPage(query);
        Page<DragonTenantListOutVO> outVOIPage = DragonJsonUtil.convertT1ToT2(outBOIPage, DragonTenantListOutVO.class);
        return DragonPage.convert2DragonPage(outVOIPage);
    }
}
