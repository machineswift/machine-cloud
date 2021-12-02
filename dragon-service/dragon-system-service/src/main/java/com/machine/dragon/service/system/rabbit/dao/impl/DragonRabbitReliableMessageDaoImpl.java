package com.machine.dragon.service.system.rabbit.dao.impl;

import com.machine.dragon.service.system.rabbit.dao.DragonRabbitReliableMessageDao;
import com.machine.dragon.service.system.rabbit.mapper.DragonRabbitReliableMessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DragonRabbitReliableMessageDaoImpl implements DragonRabbitReliableMessageDao {

    @Autowired
    private DragonRabbitReliableMessageMapper dragonRabbitReliableMessageMapper;

    @Override
    public int deleteById(String id) {
        return dragonRabbitReliableMessageMapper.deleteById(id);
    }

    @Override
    public int deleteByMessageKey(String messageKey) {
        return dragonRabbitReliableMessageMapper.deleteByMessageKey(messageKey);
    }

}
