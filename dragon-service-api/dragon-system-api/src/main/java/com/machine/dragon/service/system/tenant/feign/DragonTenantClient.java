package com.machine.dragon.service.system.tenant.feign;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.machine.dragon.common.core.bean.tenant.DragonTenant;
import com.machine.dragon.service.system.tenant.feign.outvo.DragonTenantListOutVO;
import com.machine.dragon.service.system.tenant.feign.query.DragonTenantPageQuery;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "dragon-system-service", path = "client/system/tenant")
public interface DragonTenantClient {

    @GetMapping("getByTenantId")
    DragonTenant getByTenantId(@RequestParam(name = "tenantId") Integer tenantId);

    @PostMapping("selectTenantPage")
    IPage<DragonTenantListOutVO> selectTenantPage(@RequestBody DragonTenantPageQuery query);
}
