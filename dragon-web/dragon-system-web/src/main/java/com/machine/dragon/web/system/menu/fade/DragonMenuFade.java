package com.machine.dragon.web.system.menu.fade;

import com.machine.dragon.web.system.menu.contoller.response.DragonMenuDetailResponse;

public interface DragonMenuFade {
    DragonMenuDetailResponse queryMenuDetail(Long menuId);
}
