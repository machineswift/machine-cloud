package com.machine.dragon.web.system.menu.fade;

import com.machine.dragon.web.system.menu.contoller.response.DragonMenuDetailResponse;
import com.machine.dragon.web.system.menu.contoller.response.DragonMenuTreeResponse;

import java.util.List;

public interface DragonMenuFade {
    DragonMenuDetailResponse queryMenuDetail(Long menuId);

    List<DragonMenuTreeResponse> queryMenuTree();
}
