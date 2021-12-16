package com.machine.dragon.service.system.menu.dao;

import com.machine.dragon.service.system.menu.dao.outdto.DragonMenuDetailOutDTO;

public interface DragonMenuDao {

    DragonMenuDetailOutDTO getByMenuId(Long menuId);
}
