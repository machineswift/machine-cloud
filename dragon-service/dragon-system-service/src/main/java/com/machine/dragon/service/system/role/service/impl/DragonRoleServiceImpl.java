package com.machine.dragon.service.system.role.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.machine.dragon.common.tool.jackson.DragonJsonUtil;
import com.machine.dragon.service.system.role.dao.DragonRoleDao;
import com.machine.dragon.service.system.role.dao.outdto.DragonRoleDetailOutDTO;
import com.machine.dragon.service.system.role.dao.outdto.DragonRoleListOutDTO;
import com.machine.dragon.service.system.role.resource.query.DragonRolePageQuery;
import com.machine.dragon.service.system.role.service.DragonRoleService;
import com.machine.dragon.service.system.role.service.outbo.DragonRoleDetailOutBO;
import com.machine.dragon.service.system.role.service.outbo.DragonRoleListOutBO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<DragonRoleListOutBO> selectRoleList() {
        List<DragonRoleListOutDTO> outDTOList = dragonRoleDao.selectRoleList();
        return DragonJsonUtil.copyArray(outDTOList, DragonRoleListOutBO.class);
    }

    @Override
    public Page<DragonRoleListOutBO> selectRolePage(DragonRolePageQuery query) {
        Page<DragonRoleListOutDTO> outDTOIPage = dragonRoleDao.selectRolePage(query);
        return DragonJsonUtil.convertT1ToT2(outDTOIPage, DragonRoleListOutBO.class);
    }
}
