package com.machine.dragon.service.system.rabbit.dao;

import com.machine.dragon.service.system.rabbit.dao.indto.DragonRabbitReliableMessageInitInDTO;
import com.machine.dragon.service.system.rabbit.dao.indto.DragonRabbitReliableMessageUpdate4SubscribeInDTO;
import com.machine.dragon.service.system.rabbit.dao.outdto.DragonRabbitReliableMessageOutDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface DragonRabbitReliableMessageDao {

    String init(DragonRabbitReliableMessageInitInDTO inDto);

    int deleteById(String id);

    void deadById(String id);

    void update4Subscribe(DragonRabbitReliableMessageUpdate4SubscribeInDTO inDto);

    int update4ResendMessage(String id,
                             LocalDateTime updateTime,
                             Integer nextTimeSeconds);

    DragonRabbitReliableMessageOutDTO getById(String id);

    String getIdByMessageKey(String messageKey);

    List<DragonRabbitReliableMessageOutDTO> listByCurrentDateTime(LocalDateTime dateTime);
}
