package com.machine.dragon.service.system.tenant.service.outbo;

import com.machine.dragon.common.core.envm.tenant.DragonTenantStatusEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DragonTenantListOutBO {
    private Integer tenantId;

    private String name;

    private DragonTenantStatusEnum status;
}
