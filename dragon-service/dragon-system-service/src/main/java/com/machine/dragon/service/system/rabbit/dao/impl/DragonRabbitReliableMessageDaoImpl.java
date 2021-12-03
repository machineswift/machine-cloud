package com.machine.dragon.service.system.rabbit.dao.impl;

import com.machine.dragon.common.core.bean.rabbit.DragonRabbitReliableMessage;
import com.machine.dragon.common.tool.jackson.DragonJsonUtil;
import com.machine.dragon.service.system.rabbit.dao.DragonRabbitReliableMessageDao;
import com.machine.dragon.service.system.rabbit.dao.indto.DragonRabbitReliableMessageInitInDto;
import com.machine.dragon.service.system.rabbit.dao.indto.DragonRabbitReliableMessageUpdate4SubscribeInDto;
import com.machine.dragon.service.system.rabbit.mapper.DragonRabbitReliableMessageMapper;
import com.machine.dragon.service.system.rabbit.mapper.entity.DragonRabbitReliableMessageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DragonRabbitReliableMessageDaoImpl implements DragonRabbitReliableMessageDao {

    @Autowired
    private DragonRabbitReliableMessageMapper dragonRabbitReliableMessageMapper;

    @Override
    public String insert(DragonRabbitReliableMessageInitInDto inDto) {
        DragonRabbitReliableMessageEntity entity = DragonJsonUtil.copy(inDto, DragonRabbitReliableMessageEntity.class);
        //todo 处理租户信息
        entity.setTenantId(1);
        dragonRabbitReliableMessageMapper.insert(entity);
        return entity.getId();
    }

    @Override
    public int deleteById(String id) {
        return dragonRabbitReliableMessageMapper.deleteById(id);
    }

    @Override
    public int deleteByMessageKey(String messageKey) {
        return dragonRabbitReliableMessageMapper.deleteByMessageKey(messageKey);
    }

    @Override
    public void deadById(String id) {
        dragonRabbitReliableMessageMapper.deadById(id);
    }

    @Override
    public void update4Subscribe(DragonRabbitReliableMessageUpdate4SubscribeInDto inDto) {
        dragonRabbitReliableMessageMapper.update4Subscribe(inDto);
    }

    @Override
    public DragonRabbitReliableMessage getById(String id) {
        DragonRabbitReliableMessageEntity entity = dragonRabbitReliableMessageMapper.selectById(id);
        return DragonJsonUtil.copy(entity, DragonRabbitReliableMessage.class);
    }

}
