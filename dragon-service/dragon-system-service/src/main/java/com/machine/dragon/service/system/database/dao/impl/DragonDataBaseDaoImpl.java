package com.machine.dragon.service.system.database.dao.impl;

import com.machine.dragon.service.system.database.dao.DragonDataBaseDao;
import com.machine.dragon.service.system.database.mapper.DragonDataBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public class DragonDataBaseDaoImpl implements DragonDataBaseDao {

    @Autowired
    private DragonDataBaseMapper dragonDataBaseMapper;

    @Override
    public LocalDateTime getCurrentDateTime() {
        return dragonDataBaseMapper.getCurrentDateTime();
    }
}
