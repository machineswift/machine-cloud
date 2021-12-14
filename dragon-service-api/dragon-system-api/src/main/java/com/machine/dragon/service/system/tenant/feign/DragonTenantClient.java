package com.machine.dragon.service.system.tenant.feign;

import com.machine.dragon.common.core.bean.tenant.DragonTenant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "dragon-system-service", path = "client/system/tenant")
public interface DragonTenantClient {

    @GetMapping("getByTenantId")
    DragonTenant getByTenantId(@RequestParam(name = "tenantId") Integer tenantId);
}
