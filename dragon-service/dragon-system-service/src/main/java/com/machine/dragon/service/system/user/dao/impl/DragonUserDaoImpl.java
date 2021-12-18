package com.machine.dragon.service.system.user.dao.impl;

import com.machine.dragon.common.tool.jackson.DragonJsonUtil;
import com.machine.dragon.service.system.user.dao.DragonUserDao;
import com.machine.dragon.service.system.user.dao.outdto.DragonUserOutDTO;
import com.machine.dragon.service.system.user.mapper.DragonUserMapper;
import com.machine.dragon.service.system.user.mapper.entity.DragonUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DragonUserDaoImpl implements DragonUserDao {

    @Autowired
    private DragonUserMapper dragonUserMapper;

    @Override
    public DragonUserOutDTO getByUserId(String userId) {
        DragonUserEntity entity = dragonUserMapper.selectById(userId);
        return DragonJsonUtil.copy(entity, DragonUserOutDTO.class);
    }
}
