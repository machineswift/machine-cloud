package com.machine.dragon.service.system.menu.feign;

import com.machine.dragon.common.tool.jackson.DragonJsonUtil;
import com.machine.dragon.service.system.menu.feign.outvo.DragonMenuDetailOutVO;
import com.machine.dragon.service.system.menu.service.DragonMenuService;
import com.machine.dragon.service.system.menu.service.outbo.DragonMenuDetailOutBO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RefreshScope
@RestController
@RequestMapping("client/system/menu")
public class DragonMenuClientImpl implements DragonMenuClient {

    @Autowired
    private DragonMenuService dragonMenuService;

    @Override
    @GetMapping("getByMenuId")
    public DragonMenuDetailOutVO getByMenuId(Long menuId) {
        DragonMenuDetailOutBO detailOutBo = dragonMenuService.getByMenuId(menuId);
        return DragonJsonUtil.copy(detailOutBo, DragonMenuDetailOutVO.class);
    }
}
