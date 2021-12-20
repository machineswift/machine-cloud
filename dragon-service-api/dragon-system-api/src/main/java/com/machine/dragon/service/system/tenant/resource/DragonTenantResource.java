package com.machine.dragon.service.system.tenant.resource;

import com.machine.dragon.common.core.bean.page.DragonPage;
import com.machine.dragon.common.core.bean.tenant.DragonTenant;
import com.machine.dragon.service.system.tenant.resource.outvo.DragonTenantListOutVO;
import com.machine.dragon.service.system.tenant.resource.query.DragonTenantPageQuery;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "dragon-system-service", path = "tenant")
public interface DragonTenantResource {

    @GetMapping("getByTenantId")
    DragonTenant getByTenantId(@RequestParam(name = "tenantId") Integer tenantId);

    @PostMapping("selectTenantPage")
    DragonPage<DragonTenantListOutVO> selectTenantPage(@RequestBody DragonTenantPageQuery query);
}
