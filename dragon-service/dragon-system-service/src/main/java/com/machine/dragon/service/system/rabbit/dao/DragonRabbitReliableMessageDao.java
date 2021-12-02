package com.machine.dragon.service.system.rabbit.dao;

public interface DragonRabbitReliableMessageDao {
    int deleteById(String id);

    int deleteByMessageKey(String messageKey);
}
