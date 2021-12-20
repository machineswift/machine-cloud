package com.machine.dragon.service.system.menu.dao.impl;

import com.machine.dragon.common.tool.jackson.DragonJsonUtil;
import com.machine.dragon.service.system.menu.dao.DragonMenuDao;
import com.machine.dragon.service.system.menu.dao.outdto.DragonMenuDetailOutDTO;
import com.machine.dragon.service.system.menu.dao.outdto.DragonMenuListOutDTO;
import com.machine.dragon.service.system.menu.mapper.DragonMenuMapper;
import com.machine.dragon.service.system.menu.mapper.entity.DragonMenuEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DragonMenuDaoImpl implements DragonMenuDao {

    @Autowired
    private DragonMenuMapper dragonMenuMapper;

    @Override
    public DragonMenuDetailOutDTO getByMenuId(Long menuId) {
        DragonMenuEntity entity = dragonMenuMapper.selectByMenuId(menuId);
        return DragonJsonUtil.copy(entity, DragonMenuDetailOutDTO.class);
    }

    @Override
    public List<DragonMenuListOutDTO> selectMenuList() {
        List<DragonMenuEntity> entityList = dragonMenuMapper.selectMenuList();
        return DragonJsonUtil.copyArray(entityList, DragonMenuListOutDTO.class);
    }
}
