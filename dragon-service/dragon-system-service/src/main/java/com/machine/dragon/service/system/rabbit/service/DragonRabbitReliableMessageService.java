package com.machine.dragon.service.system.rabbit.service;

import com.machine.dragon.common.core.bean.rabbit.DragonRabbitReliableMessage;
import com.machine.dragon.service.system.rabbit.service.inbo.DragonRabbitReliableMessageInitInBo;
import com.machine.dragon.service.system.rabbit.service.inbo.DragonRabbitReliableMessageUpdate4SubscribeInBo;

import java.time.LocalDateTime;
import java.util.List;

public interface DragonRabbitReliableMessageService {

    String init(DragonRabbitReliableMessageInitInBo inBo);

    void deleteById(String id);

    void deadById(String id);

    void update4Subscribe(DragonRabbitReliableMessageUpdate4SubscribeInBo inBo);

    int update4ResendMessage(String id,
                             LocalDateTime updateTime,
                             Integer nextTimeSeconds);

    DragonRabbitReliableMessage getById(String id);

    List<DragonRabbitReliableMessage> selectByCurrentDateTime(LocalDateTime dateTime);
}
