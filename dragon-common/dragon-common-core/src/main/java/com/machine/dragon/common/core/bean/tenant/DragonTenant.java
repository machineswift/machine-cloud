package com.machine.dragon.common.core.bean.tenant;

import com.machine.dragon.common.core.envm.tenant.DragonTenantStatusEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DragonTenant {
    private Integer tenantId;

    private String name;

    private String fullName;

    private DragonTenantStatusEnum status;

    private String description;
}
