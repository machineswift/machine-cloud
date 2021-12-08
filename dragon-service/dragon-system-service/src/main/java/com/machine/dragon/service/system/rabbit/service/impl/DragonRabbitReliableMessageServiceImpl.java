package com.machine.dragon.service.system.rabbit.service.impl;

import com.machine.dragon.common.core.bean.rabbit.DragonRabbitReliableMessage;
import com.machine.dragon.common.tool.jackson.DragonJsonUtil;
import com.machine.dragon.service.system.rabbit.dao.DragonRabbitReliableMessageDao;
import com.machine.dragon.service.system.rabbit.dao.indto.DragonRabbitReliableMessageInitInDto;
import com.machine.dragon.service.system.rabbit.dao.indto.DragonRabbitReliableMessageUpdate4SubscribeInDto;
import com.machine.dragon.service.system.rabbit.service.DragonRabbitReliableMessageService;
import com.machine.dragon.service.system.rabbit.service.inbo.DragonRabbitReliableMessageInitInBo;
import com.machine.dragon.service.system.rabbit.service.inbo.DragonRabbitReliableMessageUpdate4SubscribeInBo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class DragonRabbitReliableMessageServiceImpl implements DragonRabbitReliableMessageService {

    @Autowired
    private DragonRabbitReliableMessageDao dragonRabbitReliableMessageDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String init(DragonRabbitReliableMessageInitInBo inBo) {
        dragonRabbitReliableMessageDao.deleteByMessageKey(inBo.getMessageKey());
        return dragonRabbitReliableMessageDao.insert(DragonJsonUtil.copy(inBo, DragonRabbitReliableMessageInitInDto.class));
    }

    @Override
    public void deleteById(String id) {
        dragonRabbitReliableMessageDao.deleteById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deadById(String id) {
        dragonRabbitReliableMessageDao.deadById(id);
        dragonRabbitReliableMessageDao.deleteById(id);
    }

    @Override
    public void update4Subscribe(DragonRabbitReliableMessageUpdate4SubscribeInBo inBo) {
        dragonRabbitReliableMessageDao.update4Subscribe(
                DragonJsonUtil.copy(inBo, DragonRabbitReliableMessageUpdate4SubscribeInDto.class));
    }

    @Override
    public int update4ResendMessage(String id,
                                    LocalDateTime updateTime,
                                    Integer nextTimeSeconds) {
        return dragonRabbitReliableMessageDao.update4ResendMessage(id, updateTime, nextTimeSeconds);
    }

    @Override
    public DragonRabbitReliableMessage getById(String id) {
        return dragonRabbitReliableMessageDao.getById(id);
    }

    @Override
    public List<DragonRabbitReliableMessage> selectByCurrentDateTime(LocalDateTime dateTime) {
        return dragonRabbitReliableMessageDao.selectByCurrentDateTime(dateTime);
    }
}
