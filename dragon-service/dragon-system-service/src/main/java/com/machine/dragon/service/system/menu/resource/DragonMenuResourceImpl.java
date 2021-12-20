package com.machine.dragon.service.system.menu.resource;

import com.machine.dragon.common.tool.jackson.DragonJsonUtil;
import com.machine.dragon.service.system.menu.resource.outvo.DragonMenuDetailOutVO;
import com.machine.dragon.service.system.menu.resource.outvo.DragonMenuListOutVO;
import com.machine.dragon.service.system.menu.service.DragonMenuService;
import com.machine.dragon.service.system.menu.service.outbo.DragonMenuDetailOutBO;
import com.machine.dragon.service.system.menu.service.outbo.DragonMenuListOutBO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RefreshScope
@RestController
@RequestMapping("menu")
public class DragonMenuResourceImpl implements DragonMenuResource {

    @Autowired
    private DragonMenuService dragonMenuService;

    @Override
    @GetMapping("getByMenuId")
    public DragonMenuDetailOutVO getByMenuId(Long menuId) {
        DragonMenuDetailOutBO detailOutBo = dragonMenuService.getByMenuId(menuId);
        return DragonJsonUtil.copy(detailOutBo, DragonMenuDetailOutVO.class);
    }

    @Override
    @GetMapping("selectMenuList")
    public List<DragonMenuListOutVO> selectMenuList() {
        List<DragonMenuListOutBO> outBOList = dragonMenuService.selectMenuList();
        return DragonJsonUtil.copyArray(outBOList, DragonMenuListOutVO.class);
    }
}
