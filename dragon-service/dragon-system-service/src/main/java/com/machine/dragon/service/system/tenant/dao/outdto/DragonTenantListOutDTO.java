package com.machine.dragon.service.system.tenant.dao.outdto;

import com.machine.dragon.common.core.envm.tenant.DragonTenantStatusEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DragonTenantListOutDTO {
    private Integer tenantId;

    private String name;

    private DragonTenantStatusEnum status;
}
