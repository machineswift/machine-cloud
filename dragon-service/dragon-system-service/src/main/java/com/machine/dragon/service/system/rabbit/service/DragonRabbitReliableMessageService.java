package com.machine.dragon.service.system.rabbit.service;

import com.machine.dragon.common.core.bean.rabbit.DragonRabbitReliableMessage;
import com.machine.dragon.service.system.rabbit.service.inbo.DragonRabbitReliableMessageInitInBo;
import com.machine.dragon.service.system.rabbit.service.inbo.DragonRabbitReliableMessageUpdate4SubscribeInBo;

public interface DragonRabbitReliableMessageService {

    String init(DragonRabbitReliableMessageInitInBo inBo);

    void deleteById(String id);

    void deadById(String id);

    void update4Subscribe(DragonRabbitReliableMessageUpdate4SubscribeInBo inBo);

    DragonRabbitReliableMessage getById(String id);

}
