package com.machine.dragon.service.system.menu.dao;

import com.machine.dragon.service.system.menu.dao.outdto.DragonMenuDetailOutDTO;
import com.machine.dragon.service.system.menu.dao.outdto.DragonMenuListOutDTO;

import java.util.List;

public interface DragonMenuDao {

    DragonMenuDetailOutDTO getByMenuId(Long menuId);

    List<DragonMenuListOutDTO> selectMenuList();
}
