package com.machine.dragon.service.system.user.service.impl;

import com.machine.dragon.common.tool.jackson.DragonJsonUtil;
import com.machine.dragon.service.system.user.dao.DragonUserDao;
import com.machine.dragon.service.system.user.dao.outdto.DragonUserOutDTO;
import com.machine.dragon.service.system.user.service.DragonUserService;
import com.machine.dragon.service.system.user.service.outbo.DragonUserDetailOutBO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DragonUserServiceImpl implements DragonUserService {

    @Autowired
    private DragonUserDao dragonUserDao;

    @Override
    public DragonUserDetailOutBO getByUserId(String userId) {
        DragonUserOutDTO outDto = dragonUserDao.getByUserId(userId);
        return DragonJsonUtil.copy(outDto, DragonUserDetailOutBO.class);
    }
}
