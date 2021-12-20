package com.machine.dragon.service.system.menu.service;

import com.machine.dragon.service.system.menu.service.outbo.DragonMenuDetailOutBO;
import com.machine.dragon.service.system.menu.service.outbo.DragonMenuListOutBO;

import java.util.List;

public interface DragonMenuService {
    DragonMenuDetailOutBO getByMenuId(Long menuId);

    List<DragonMenuListOutBO> selectMenuList();
}
