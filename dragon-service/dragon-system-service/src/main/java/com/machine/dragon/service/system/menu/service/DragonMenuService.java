package com.machine.dragon.service.system.menu.service;

import com.machine.dragon.service.system.menu.service.outbo.DragonMenuDetailOutBO;

public interface DragonMenuService {
    DragonMenuDetailOutBO getByMenuId(Long menuId);
}
