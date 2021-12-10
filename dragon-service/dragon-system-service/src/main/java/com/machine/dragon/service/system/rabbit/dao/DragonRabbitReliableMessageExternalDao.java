package com.machine.dragon.service.system.rabbit.dao;

import com.machine.dragon.service.system.rabbit.dao.indto.DragonRabbitReliableMessageExternalInitInDTO;
import com.machine.dragon.service.system.rabbit.dao.indto.DragonRabbitReliableMessageExternalUpdateInDTO;
import com.machine.dragon.service.system.rabbit.dao.outdto.DragonRabbitReliableMessageExternalOutDTO;

public interface DragonRabbitReliableMessageExternalDao {

    void init(DragonRabbitReliableMessageExternalInitInDTO inDTO);

    void deleteById(String id);

    void deadById(String id);

    void update(DragonRabbitReliableMessageExternalUpdateInDTO inDTO);

    DragonRabbitReliableMessageExternalOutDTO getById(String id);

}
