package com.machine.dragon.service.system.tenant.feign.query;

import com.machine.dragon.common.core.bean.page.DragonBasePageQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class DragonTenantPageQuery extends DragonBasePageQuery {

    private String name;

}
