package com.machine.dragon.service.system.rabbit.service.impl;

import com.machine.dragon.common.core.bean.rabbit.DragonRabbitBaseMessage;
import com.machine.dragon.common.core.bean.rabbit.DragonRabbitReliableMessage;
import com.machine.dragon.common.tool.date.DragonLocalDateTimeUtil;
import com.machine.dragon.common.tool.jackson.DragonJsonUtil;
import com.machine.dragon.service.system.database.dao.DragonDataBaseDao;
import com.machine.dragon.service.system.rabbit.dao.DragonRabbitReliableMessageDao;
import com.machine.dragon.service.system.rabbit.dao.indto.DragonRabbitReliableMessageInitInDTO;
import com.machine.dragon.service.system.rabbit.dao.indto.DragonRabbitReliableMessageUpdate4SubscribeInDTO;
import com.machine.dragon.service.system.rabbit.service.DragonRabbitReliableMessageService;
import com.machine.dragon.service.system.rabbit.service.inbo.DragonRabbitReliableMessageInitInBO;
import com.machine.dragon.service.system.rabbit.service.inbo.DragonRabbitReliableMessageUpdate4SubscribeInBO;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class DragonRabbitReliableMessageServiceImpl implements DragonRabbitReliableMessageService {


    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private DragonDataBaseDao dragonDataBaseDao;

    @Autowired
    private DragonRabbitReliableMessageDao dragonRabbitReliableMessageDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String init(DragonRabbitReliableMessageInitInBO inBo) {
        dragonRabbitReliableMessageDao.deleteByMessageKey(inBo.getMessageKey());
        return dragonRabbitReliableMessageDao.insert(DragonJsonUtil.copy(inBo, DragonRabbitReliableMessageInitInDTO.class));
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
    public void update4Subscribe(DragonRabbitReliableMessageUpdate4SubscribeInBO inBo) {
        dragonRabbitReliableMessageDao.update4Subscribe(
                DragonJsonUtil.copy(inBo, DragonRabbitReliableMessageUpdate4SubscribeInDTO.class));
    }

    @Override
    public DragonRabbitReliableMessage getById(String id) {
        return dragonRabbitReliableMessageDao.getById(id);
    }

    @Override
    @SneakyThrows
    public void resendMessage() {
        LocalDateTime currentDateTime = dragonDataBaseDao.getCurrentDateTime();

        while (true) {
            List<DragonRabbitReliableMessage> reliableMessageList = dragonRabbitReliableMessageDao.
                    selectByCurrentDateTime(currentDateTime);
            if (CollectionUtils.isEmpty(reliableMessageList)) {
                return;
            }

            for (DragonRabbitReliableMessage reliableMessage : reliableMessageList) {
                Integer nextTimeSeconds = null;
                if (reliableMessage.getResendTimes() > reliableMessage.getMaxResendTimes()) {
                    //超过最大重发次数
                    deleteById(reliableMessage.getId());
                    continue;
                } else {
                    //发送次数超过消费次数（防止mq队列阻塞引起可靠消息被标记为死亡）
                    if (reliableMessage.getResendTimes() > reliableMessage.getSubscribeTimes()) {
                        List<Integer> retryStrategyList = DragonJsonUtil.readList(reliableMessage.getRetryStrategy(), Integer.class);
                        if (reliableMessage.getResendTimes() >= reliableMessageList.size()) {
                            nextTimeSeconds = retryStrategyList.get(reliableMessage.getResendTimes());
                        } else {
                            Long seconds = DragonLocalDateTimeUtil.getSecond(reliableMessage.getNextExeTime()) -
                                    DragonLocalDateTimeUtil.getSecond(reliableMessage.getLastSubscribeTime());
                            nextTimeSeconds = Math.toIntExact((reliableMessage.getResendTimes() -
                                    reliableMessage.getSubscribeTimes()) * seconds);
                        }
                    }
                }

                int count = dragonRabbitReliableMessageDao.update4ResendMessage(reliableMessage.getId(),
                        reliableMessage.getUpdateTime(), nextTimeSeconds);
                if (count > 0) {
                    //发送可靠消息
                    DragonRabbitBaseMessage rabbitBaseMessage = (DragonRabbitBaseMessage) DragonJsonUtil.parse(
                            reliableMessage.getMessageContent(), Class.forName(reliableMessage.getMessageClassName()));
                    rabbitBaseMessage.setReliableMessage(reliableMessage);
                    rabbitTemplate.convertAndSend(reliableMessage.getPublishExchange(),
                            reliableMessage.getPublishRoutingKey(), rabbitBaseMessage);
                }
            }
        }
    }

}
