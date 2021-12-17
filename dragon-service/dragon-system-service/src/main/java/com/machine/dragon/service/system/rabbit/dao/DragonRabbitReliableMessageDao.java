package com.machine.dragon.service.system.rabbit.dao;

import com.machine.dragon.service.system.rabbit.dao.indto.DragonRabbitReliableMessageInitInDTO;
import com.machine.dragon.service.system.rabbit.dao.indto.DragonRabbitReliableMessageUpdate4SubscribeInDTO;
import com.machine.dragon.service.system.rabbit.dao.outdto.DragonRabbitReliableMessageOutDTO;

import java.util.List;

public interface DragonRabbitReliableMessageDao {

    String insert(DragonRabbitReliableMessageInitInDTO inDto);

    int deleteById(String id);

    void deadById(String id);

    void update4Subscribe(DragonRabbitReliableMessageUpdate4SubscribeInDTO inDto);

    int update4ResendMessage(String id,
                             Long updateTime,
                             Integer nextTimeMillis);

    DragonRabbitReliableMessageOutDTO getById(String id);

    String getIdByMessageKey(String messageKey);

    List<DragonRabbitReliableMessageOutDTO> listByCurrentTimeMillis(Long dateTime);
}
