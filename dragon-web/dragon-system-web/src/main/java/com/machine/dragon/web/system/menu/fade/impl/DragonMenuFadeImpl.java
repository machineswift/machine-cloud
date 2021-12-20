package com.machine.dragon.web.system.menu.fade.impl;

import com.machine.dragon.common.tool.jackson.DragonJsonUtil;
import com.machine.dragon.service.system.menu.resource.DragonMenuResource;
import com.machine.dragon.service.system.menu.resource.outvo.DragonMenuDetailOutVO;
import com.machine.dragon.web.system.menu.contoller.response.DragonMenuDetailResponse;
import com.machine.dragon.web.system.menu.fade.DragonMenuFade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DragonMenuFadeImpl implements DragonMenuFade {

    @Autowired
    private DragonMenuResource dragonMenuResource;

    @Override
    public DragonMenuDetailResponse queryMenuDetail(Long menuId) {
        DragonMenuDetailOutVO detailOutVO = dragonMenuResource.getByMenuId(menuId);
        return DragonJsonUtil.copy(detailOutVO, DragonMenuDetailResponse.class);
    }

}
