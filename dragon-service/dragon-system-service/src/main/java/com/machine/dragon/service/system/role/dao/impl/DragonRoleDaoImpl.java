package com.machine.dragon.service.system.role.dao.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.machine.dragon.common.tool.jackson.DragonJsonUtil;
import com.machine.dragon.service.system.role.dao.DragonRoleDao;
import com.machine.dragon.service.system.role.dao.outdto.DragonRoleDetailOutDTO;
import com.machine.dragon.service.system.role.dao.outdto.DragonRoleListOutDTO;
import com.machine.dragon.service.system.role.mapper.DragonRoleMapper;
import com.machine.dragon.service.system.role.mapper.entity.DragonRoleEntity;
import com.machine.dragon.service.system.role.resource.query.DragonRolePageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DragonRoleDaoImpl implements DragonRoleDao {

    @Autowired
    private DragonRoleMapper dragonRoleMapper;

    @Override
    public DragonRoleDetailOutDTO getByRoleId(Long roleId) {
        DragonRoleEntity entity = dragonRoleMapper.selectByRoleId(roleId);
        return DragonJsonUtil.copy(entity, DragonRoleDetailOutDTO.class);
    }

    @Override
    public List<DragonRoleListOutDTO> selectRoleList() {
        List<DragonRoleEntity> entityList = dragonRoleMapper.selectRoleList();
        return DragonJsonUtil.copyArray(entityList, DragonRoleListOutDTO.class);
    }

    @Override
    public Page<DragonRoleListOutDTO> selectRolePage(DragonRolePageQuery query) {
        Page<DragonRoleEntity> page = new Page(query.getCurrent(), query.getSize());
        IPage<DragonRoleEntity> entityIPage = dragonRoleMapper.selectRolePage(page, query);
        return DragonJsonUtil.convertT1ToT2(entityIPage, DragonRoleListOutDTO.class);
    }
}
