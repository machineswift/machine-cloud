package com.machine.dragon.web.system.role.fade.impl;

import com.machine.dragon.common.core.bean.page.DragonPage;
import com.machine.dragon.common.tool.jackson.DragonJsonUtil;
import com.machine.dragon.service.system.role.resource.DragonRoleResource;
import com.machine.dragon.service.system.role.resource.outvo.DragonRoleDetailOutVO;
import com.machine.dragon.service.system.role.resource.outvo.DragonRoleListOutVO;
import com.machine.dragon.service.system.role.resource.query.DragonRolePageQuery;
import com.machine.dragon.web.system.role.controller.request.QueryRolePageRequest;
import com.machine.dragon.web.system.role.controller.response.DragonRoleDetailResponse;
import com.machine.dragon.web.system.role.controller.response.DragonRoleListResponse;
import com.machine.dragon.web.system.role.fade.DragonRoleFade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DragonRoleFadeImpl implements DragonRoleFade {

    @Autowired
    private DragonRoleResource dragonRoleResource;

    @Override
    public DragonRoleDetailResponse queryRoleDetail(Long roleId) {
        DragonRoleDetailOutVO detailOutVO = dragonRoleResource.getByRoleId(roleId);
        return DragonJsonUtil.copy(detailOutVO, DragonRoleDetailResponse.class);
    }

    @Override
    public DragonPage<DragonRoleListResponse> queryRolePage(QueryRolePageRequest request) {
        DragonRolePageQuery query = DragonJsonUtil.copy(request, DragonRolePageQuery.class);
        DragonPage<DragonRoleListOutVO> outVOIPage = dragonRoleResource.selectRolePage(query);
        return DragonJsonUtil.convertT1ToT2(outVOIPage, DragonRoleListResponse.class);
    }

}
