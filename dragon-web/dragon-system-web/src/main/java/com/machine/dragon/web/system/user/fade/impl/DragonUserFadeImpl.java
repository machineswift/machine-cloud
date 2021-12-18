package com.machine.dragon.web.system.user.fade.impl;

import com.machine.dragon.common.tool.jackson.DragonJsonUtil;
import com.machine.dragon.service.system.user.feign.DragonUserClient;
import com.machine.dragon.service.system.user.feign.outvo.DragonUserDetailOutVO;
import com.machine.dragon.web.system.user.controller.request.QueryUserDetailRequest;
import com.machine.dragon.web.system.user.fade.DragonUserFade;
import com.machine.dragon.web.system.user.controller.response.DragonUserDetailResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DragonUserFadeImpl implements DragonUserFade {

    @Autowired
    private DragonUserClient dragonUserClient;

    @Override
    public DragonUserDetailResponse queryUserDetail(QueryUserDetailRequest request) {
        DragonUserDetailOutVO detailOutVO = dragonUserClient.getByUserId(request.getUserId());
        return DragonJsonUtil.copy(detailOutVO, DragonUserDetailResponse.class);
    }

}
