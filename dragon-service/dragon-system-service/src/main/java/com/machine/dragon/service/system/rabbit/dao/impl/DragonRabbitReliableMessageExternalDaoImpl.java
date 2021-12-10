package com.machine.dragon.service.system.rabbit.dao.impl;

import com.machine.dragon.common.tool.jackson.DragonJsonUtil;
import com.machine.dragon.service.system.rabbit.dao.DragonRabbitReliableMessageExternalDao;
import com.machine.dragon.service.system.rabbit.dao.indto.DragonRabbitReliableMessageExternalInitInDTO;
import com.machine.dragon.service.system.rabbit.dao.indto.DragonRabbitReliableMessageExternalUpdateInDTO;
import com.machine.dragon.service.system.rabbit.dao.outdto.DragonRabbitReliableMessageExternalOutDTO;
import com.machine.dragon.service.system.rabbit.mapper.DragonRabbitReliableMessageExternalMapper;
import com.machine.dragon.service.system.rabbit.mapper.entity.DragonRabbitReliableMessageExternalEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DragonRabbitReliableMessageExternalDaoImpl implements DragonRabbitReliableMessageExternalDao {

    @Autowired
    private DragonRabbitReliableMessageExternalMapper dragonRabbitReliableMessageExternalMapper;

    @Override
    public void init(DragonRabbitReliableMessageExternalInitInDTO inDTO) {
        DragonRabbitReliableMessageExternalEntity entity = DragonJsonUtil.copy(inDTO, DragonRabbitReliableMessageExternalEntity.class);
        dragonRabbitReliableMessageExternalMapper.insert(entity);
    }

    @Override
    public void deleteById(String id) {
        dragonRabbitReliableMessageExternalMapper.deleteById(id);
    }

    @Override
    public void deadById(String id) {
        dragonRabbitReliableMessageExternalMapper.deadById(id);
    }

    @Override
    public void update(DragonRabbitReliableMessageExternalUpdateInDTO inDTO) {
        DragonRabbitReliableMessageExternalEntity entity = DragonJsonUtil.copy(inDTO, DragonRabbitReliableMessageExternalEntity.class);
        dragonRabbitReliableMessageExternalMapper.updateById(entity);
    }

    @Override
    public DragonRabbitReliableMessageExternalOutDTO getById(String id) {
        DragonRabbitReliableMessageExternalEntity entity = dragonRabbitReliableMessageExternalMapper.selectById(id);
        if (null == entity) {
            return null;
        }
        return DragonJsonUtil.copy(entity, DragonRabbitReliableMessageExternalOutDTO.class);
    }
}
