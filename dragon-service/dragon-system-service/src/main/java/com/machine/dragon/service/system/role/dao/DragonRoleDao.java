package com.machine.dragon.service.system.role.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.machine.dragon.service.system.role.dao.outdto.DragonRoleDetailOutDTO;
import com.machine.dragon.service.system.role.dao.outdto.DragonRoleListOutDTO;
import com.machine.dragon.service.system.role.resource.query.DragonRolePageQuery;

import java.util.List;

public interface DragonRoleDao {

    DragonRoleDetailOutDTO getByRoleId(Long roleId);

    List<DragonRoleListOutDTO> selectRoleList();

    Page<DragonRoleListOutDTO> selectRolePage(DragonRolePageQuery query);
}
