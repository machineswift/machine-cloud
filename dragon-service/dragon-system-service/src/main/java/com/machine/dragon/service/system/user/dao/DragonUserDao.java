package com.machine.dragon.service.system.user.dao;

import com.machine.dragon.service.system.user.dao.outdto.DragonUserOutDTO;

public interface DragonUserDao {

    DragonUserOutDTO getByUserId(String userId);
}
