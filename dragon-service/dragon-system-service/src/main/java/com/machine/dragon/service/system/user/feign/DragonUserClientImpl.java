package com.machine.dragon.service.system.user.feign;

import com.machine.dragon.common.tool.jackson.DragonJsonUtil;
import com.machine.dragon.service.system.user.feign.outvo.DragonUserDetailOutVO;
import com.machine.dragon.service.system.user.service.DragonUserService;
import com.machine.dragon.service.system.user.service.outbo.DragonUserDetailOutBO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RefreshScope
@RestController
@RequestMapping("client/system/user")
public class DragonUserClientImpl implements DragonUserClient {

    @Autowired
    private DragonUserService dragonUserService;

    @Override
    @GetMapping("getByUserId")
    public DragonUserDetailOutVO getByUserId(String userId) {
        DragonUserDetailOutBO detailOutBo = dragonUserService.getByUserId(userId);
        return DragonJsonUtil.copy(detailOutBo, DragonUserDetailOutVO.class);
    }
}
