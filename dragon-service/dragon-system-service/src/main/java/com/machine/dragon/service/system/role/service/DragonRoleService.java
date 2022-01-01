package com.machine.dragon.service.system.role.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.machine.dragon.service.system.role.resource.query.DragonRolePageQuery;
import com.machine.dragon.service.system.role.service.outbo.DragonRoleDetailOutBO;
import com.machine.dragon.service.system.role.service.outbo.DragonRoleListOutBO;

import java.util.List;

public interface DragonRoleService {
    DragonRoleDetailOutBO getByRoleId(Long roleId);

    List<DragonRoleListOutBO> selectRoleList();

    Page<DragonRoleListOutBO> selectRolePage(DragonRolePageQuery query);
}
