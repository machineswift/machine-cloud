package com.machine.dragon.service.system.role.dao;

import com.machine.dragon.service.system.role.dao.outdto.DragonRoleDetailOutDTO;

public interface DragonRoleDao {

    DragonRoleDetailOutDTO getByRoleId(Long roleId);
}
