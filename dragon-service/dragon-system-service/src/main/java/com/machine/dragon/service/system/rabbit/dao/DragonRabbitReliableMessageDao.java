package com.machine.dragon.service.system.rabbit.dao;

import com.machine.dragon.common.core.bean.rabbit.DragonRabbitReliableMessage;
import com.machine.dragon.service.system.rabbit.dao.indto.DragonRabbitReliableMessageInitInDTO;
import com.machine.dragon.service.system.rabbit.dao.indto.DragonRabbitReliableMessageUpdate4SubscribeInDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface DragonRabbitReliableMessageDao {

    String insert(DragonRabbitReliableMessageInitInDTO inDto);

    int deleteById(String id);

    int deleteByMessageKey(String messageKey);

    void deadById(String id);

    void update4Subscribe(DragonRabbitReliableMessageUpdate4SubscribeInDTO inDto);

    int update4ResendMessage(String id,
                             LocalDateTime updateTime,
                             Integer nextTimeSeconds);

    DragonRabbitReliableMessage getById(String id);

    List<DragonRabbitReliableMessage> listByCurrentDateTime(LocalDateTime dateTime);

}
