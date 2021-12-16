package com.machine.dragon.service.system.menu.service.impl;

import com.machine.dragon.common.tool.jackson.DragonJsonUtil;
import com.machine.dragon.service.system.menu.dao.DragonMenuDao;
import com.machine.dragon.service.system.menu.dao.outdto.DragonMenuDetailOutDTO;
import com.machine.dragon.service.system.menu.service.DragonMenuService;
import com.machine.dragon.service.system.menu.service.outbo.DragonMenuDetailOutBO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DragonMenuServiceImpl implements DragonMenuService {

    @Autowired
    private DragonMenuDao dragonMenuDao;

    @Override
    public DragonMenuDetailOutBO getByMenuId(Long menuId) {
        DragonMenuDetailOutDTO outDto = dragonMenuDao.getByMenuId(menuId);
        return DragonJsonUtil.copy(outDto, DragonMenuDetailOutBO.class);
    }
}
