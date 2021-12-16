package com.machine.dragon.service.system.role.service.impl;

import com.machine.dragon.common.tool.jackson.DragonJsonUtil;
import com.machine.dragon.service.system.menu.dao.DragonMenuDao;
import com.machine.dragon.service.system.menu.dao.outdto.DragonMenuDetailOutDTO;
import com.machine.dragon.service.system.menu.service.DragonMenuService;
import com.machine.dragon.service.system.menu.service.outbo.DragonMenuDetailOutBO;
import com.machine.dragon.service.system.role.dao.DragonRoleDao;
import com.machine.dragon.service.system.role.dao.outdto.DragonRoleDetailOutDTO;
import com.machine.dragon.service.system.role.service.DragonRoleService;
import com.machine.dragon.service.system.role.service.outbo.DragonRoleDetailOutBO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DragonRoleServiceImpl implements DragonRoleService {

    @Autowired
    private DragonRoleDao dragonRoleDao;

    @Override
    public DragonRoleDetailOutBO getByRoleId(Long roleId) {
        DragonRoleDetailOutDTO outDto = dragonRoleDao.getByRoleId(roleId);
        return DragonJsonUtil.copy(outDto, DragonRoleDetailOutBO.class);
    }
}
