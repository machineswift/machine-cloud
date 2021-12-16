package com.machine.dragon.service.system.role.dao.impl;

import com.machine.dragon.common.tool.jackson.DragonJsonUtil;
import com.machine.dragon.service.system.role.dao.DragonRoleDao;
import com.machine.dragon.service.system.role.dao.outdto.DragonRoleDetailOutDTO;
import com.machine.dragon.service.system.role.mapper.DragonRoleMapper;
import com.machine.dragon.service.system.role.mapper.entity.DragonRoleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DragonRoleDaoImpl implements DragonRoleDao {

    @Autowired
    private DragonRoleMapper dragonRoleMapper;

    @Override
    public DragonRoleDetailOutDTO getByRoleId(Long roleId) {
        DragonRoleEntity entity = dragonRoleMapper.selectByRoleId(roleId);
        return DragonJsonUtil.copy(entity, DragonRoleDetailOutDTO.class);
    }
}
