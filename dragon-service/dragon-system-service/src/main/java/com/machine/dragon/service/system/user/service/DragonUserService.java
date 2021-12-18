package com.machine.dragon.service.system.user.service;

import com.machine.dragon.service.system.user.service.outbo.DragonUserDetailOutBO;

public interface DragonUserService {
    DragonUserDetailOutBO getByUserId(String userId);
}
