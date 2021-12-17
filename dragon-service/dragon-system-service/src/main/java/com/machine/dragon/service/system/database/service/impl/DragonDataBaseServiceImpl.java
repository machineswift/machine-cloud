package com.machine.dragon.service.system.database.service.impl;

import com.machine.dragon.service.system.database.dao.DragonDataBaseDao;
import com.machine.dragon.service.system.database.service.DragonDataBaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DragonDataBaseServiceImpl implements DragonDataBaseService {

    @Autowired
    private DragonDataBaseDao dragonDataBaseDao;

    @Override
    public Long getCurrentDateTime() {
        return dragonDataBaseDao.currentTimeMillis();
    }

}
