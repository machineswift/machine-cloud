package com.machine.dragon.service.system.rabbit.service.impl;

import com.machine.dragon.service.system.rabbit.dao.DragonRabbitReliableMessageDao;
import com.machine.dragon.service.system.rabbit.service.DragonRabbitReliableMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DragonRabbitReliableMessageServiceImpl implements DragonRabbitReliableMessageService {

    @Autowired
    private DragonRabbitReliableMessageDao dragonRabbitReliableMessageDao;

    @Override
    public void deleteById(String id) {
        dragonRabbitReliableMessageDao.deleteById(id);
    }

    @Override
    public void deleteByMessageKey(String messageKey) {
        dragonRabbitReliableMessageDao.deleteByMessageKey(messageKey);
    }
}
