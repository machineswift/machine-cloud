package com.machine.dragon.service.system.role.service;

import com.machine.dragon.service.system.role.service.outbo.DragonRoleDetailOutBO;

public interface DragonRoleService {
    DragonRoleDetailOutBO getByRoleId(Long roleId);
}
