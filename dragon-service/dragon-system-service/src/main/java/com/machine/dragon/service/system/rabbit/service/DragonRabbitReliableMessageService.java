package com.machine.dragon.service.system.rabbit.service;

public interface DragonRabbitReliableMessageService {

    void deleteById(String id);

    void deleteByMessageKey(String messageKey);
}
