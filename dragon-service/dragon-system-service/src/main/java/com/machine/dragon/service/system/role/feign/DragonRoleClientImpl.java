package com.machine.dragon.service.system.role.feign;

import com.machine.dragon.common.tool.jackson.DragonJsonUtil;
import com.machine.dragon.service.system.role.feign.outvo.DragonRoleDetailOutVO;
import com.machine.dragon.service.system.role.service.DragonRoleService;
import com.machine.dragon.service.system.role.service.outbo.DragonRoleDetailOutBO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RefreshScope
@RestController
@RequestMapping("client/system/role")
public class DragonRoleClientImpl implements DragonRoleClient {

    @Autowired
    private DragonRoleService dragonRoleService;

    @Override
    @GetMapping("getByRoleId")
    public DragonRoleDetailOutVO getByRoleId(Long roleId) {
        DragonRoleDetailOutBO detailOutBo = dragonRoleService.getByRoleId(roleId);
        return DragonJsonUtil.copy(detailOutBo, DragonRoleDetailOutVO.class);
    }
}
