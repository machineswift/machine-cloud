package com.machine.dragon.web.system.role.fade;

import com.machine.dragon.web.system.role.controller.response.DragonRoleDetailResponse;

public interface DragonRoleFade {
    DragonRoleDetailResponse queryRoleDetail(Long roleId);
}
