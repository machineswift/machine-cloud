package com.machine.dragon.web.system.role.fade;

import com.machine.dragon.common.core.bean.page.DragonPage;
import com.machine.dragon.web.system.role.controller.request.QueryRolePageRequest;
import com.machine.dragon.web.system.role.controller.response.DragonRoleDetailResponse;
import com.machine.dragon.web.system.role.controller.response.DragonRoleListResponse;

public interface DragonRoleFade {
    DragonRoleDetailResponse queryRoleDetail(Long roleId);

    DragonPage<DragonRoleListResponse> queryRolePage(QueryRolePageRequest request);
}
