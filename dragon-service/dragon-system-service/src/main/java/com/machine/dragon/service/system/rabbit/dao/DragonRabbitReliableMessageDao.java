package com.machine.dragon.service.system.rabbit.dao;

import com.machine.dragon.common.core.bean.rabbit.DragonRabbitReliableMessage;
import com.machine.dragon.service.system.rabbit.dao.indto.DragonRabbitReliableMessageInitInDto;
import com.machine.dragon.service.system.rabbit.dao.indto.DragonRabbitReliableMessageUpdate4SubscribeInDto;

public interface DragonRabbitReliableMessageDao {

    String insert(DragonRabbitReliableMessageInitInDto inDto);

    int deleteById(String id);

    int deleteByMessageKey(String messageKey);

    void deadById(String id);

    void update4Subscribe(DragonRabbitReliableMessageUpdate4SubscribeInDto inDto);

    DragonRabbitReliableMessage getById(String id);

}
