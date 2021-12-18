package com.machine.dragon.web.system.user.fade;

import com.machine.dragon.web.system.user.controller.request.QueryUserDetailRequest;
import com.machine.dragon.web.system.user.controller.response.DragonUserDetailResponse;

public interface DragonUserFade {
    DragonUserDetailResponse queryUserDetail(QueryUserDetailRequest request);
}
