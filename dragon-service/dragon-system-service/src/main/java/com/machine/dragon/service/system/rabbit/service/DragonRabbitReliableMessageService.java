package com.machine.dragon.service.system.rabbit.service;

import com.machine.dragon.common.core.bean.rabbit.DragonRabbitReliableMessage;
import com.machine.dragon.service.system.rabbit.service.inbo.DragonRabbitReliableMessageInitInBO;
import com.machine.dragon.service.system.rabbit.service.inbo.DragonRabbitReliableMessageUpdate4SubscribeInBO;

public interface DragonRabbitReliableMessageService {

    String init(DragonRabbitReliableMessageInitInBO inBo);

    void deleteById(String id);

    void deadById(String id);

    void update4Subscribe(DragonRabbitReliableMessageUpdate4SubscribeInBO inBo);

    void resendMessage();

    DragonRabbitReliableMessage getById(String id);
}
