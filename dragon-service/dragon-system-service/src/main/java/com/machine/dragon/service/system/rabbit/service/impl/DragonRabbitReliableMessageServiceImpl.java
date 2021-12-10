package com.machine.dragon.service.system.rabbit.service.impl;

import com.machine.dragon.common.core.bean.rabbit.DragonRabbitBaseMessage;
import com.machine.dragon.common.core.bean.rabbit.DragonRabbitReliableMessage;
import com.machine.dragon.common.tool.date.DragonLocalDateTimeUtil;
import com.machine.dragon.common.tool.jackson.DragonJsonUtil;
import com.machine.dragon.common.tool.string.DragonStringUtil;
import com.machine.dragon.service.system.database.dao.DragonDataBaseDao;
import com.machine.dragon.service.system.rabbit.dao.DragonRabbitReliableMessageDao;
import com.machine.dragon.service.system.rabbit.dao.DragonRabbitReliableMessageExternalDao;
import com.machine.dragon.service.system.rabbit.dao.indto.DragonRabbitReliableMessageExternalInitInDTO;
import com.machine.dragon.service.system.rabbit.dao.indto.DragonRabbitReliableMessageExternalUpdateInDTO;
import com.machine.dragon.service.system.rabbit.dao.indto.DragonRabbitReliableMessageInitInDTO;
import com.machine.dragon.service.system.rabbit.dao.indto.DragonRabbitReliableMessageUpdate4SubscribeInDTO;
import com.machine.dragon.service.system.rabbit.dao.outdto.DragonRabbitReliableMessageExternalOutDTO;
import com.machine.dragon.service.system.rabbit.dao.outdto.DragonRabbitReliableMessageOutDTO;
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

    @Autowired
    private DragonRabbitReliableMessageExternalDao dragonRabbitReliableMessageExternalDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String init(DragonRabbitReliableMessageInitInBO inBo) {
        String reliableMessageId = dragonRabbitReliableMessageDao.getIdByMessageKey(inBo.getMessageKey());
        if (DragonStringUtil.isNotEmpty(reliableMessageId)) {
            dragonRabbitReliableMessageDao.deleteById(reliableMessageId);
            dragonRabbitReliableMessageExternalDao.deleteById(reliableMessageId);
        }
        reliableMessageId = dragonRabbitReliableMessageDao.init(DragonJsonUtil.copy(inBo, DragonRabbitReliableMessageInitInDTO.class));
        dragonRabbitReliableMessageExternalDao.init(new DragonRabbitReliableMessageExternalInitInDTO(reliableMessageId, inBo.getMessageContent()));
        return reliableMessageId;
    }

    @Override
    public void deleteById(String id) {
        dragonRabbitReliableMessageDao.deleteById(id);
        dragonRabbitReliableMessageExternalDao.deleteById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deadById(String id) {
        dragonRabbitReliableMessageDao.deadById(id);
        dragonRabbitReliableMessageDao.deleteById(id);

        dragonRabbitReliableMessageExternalDao.deadById(id);
        dragonRabbitReliableMessageExternalDao.deleteById(id);
    }

    @Override
    public void update4Subscribe(DragonRabbitReliableMessageUpdate4SubscribeInBO inBo) {
        dragonRabbitReliableMessageDao.update4Subscribe(
                DragonJsonUtil.copy(inBo, DragonRabbitReliableMessageUpdate4SubscribeInDTO.class));

        dragonRabbitReliableMessageExternalDao.update(DragonJsonUtil.copy(inBo, DragonRabbitReliableMessageExternalUpdateInDTO.class));
    }

    @Override
    public DragonRabbitReliableMessage getById(String id) {
        DragonRabbitReliableMessageOutDTO reliableMessageOutDTO = dragonRabbitReliableMessageDao.getById(id);
        if (null == reliableMessageOutDTO) {
            return null;
        }

        DragonRabbitReliableMessage reliableMessage = DragonJsonUtil.copy(reliableMessageOutDTO, DragonRabbitReliableMessage.class);
        DragonRabbitReliableMessageExternalOutDTO reliableMessageExternalOutDTO = dragonRabbitReliableMessageExternalDao.getById(id);
        reliableMessage.setMessageContent(reliableMessageExternalOutDTO.getMessageContent());
        reliableMessage.setReason(reliableMessageExternalOutDTO.getReason());
        reliableMessage.setRemark(reliableMessageExternalOutDTO.getRemark());
        return reliableMessage;
    }

    @Override
    @SneakyThrows
    public void resendMessage() {
        LocalDateTime currentDateTime = dragonDataBaseDao.getCurrentDateTime();

        while (true) {
            List<DragonRabbitReliableMessageOutDTO> reliableMessageOutDTOList = dragonRabbitReliableMessageDao.
                    listByCurrentDateTime(currentDateTime);
            if (CollectionUtils.isEmpty(reliableMessageOutDTOList)) {
                return;
            }

            for (DragonRabbitReliableMessageOutDTO reliableMessageOutDTO : reliableMessageOutDTOList) {
                Integer nextTimeSeconds = null;
                if (reliableMessageOutDTO.getResendTimes() > reliableMessageOutDTO.getMaxResendTimes()) {
                    //超过最大重发次数
                    deleteById(reliableMessageOutDTO.getId());
                    continue;
                } else {
                    //发送次数超过消费次数（防止mq队列阻塞引起可靠消息被标记为死亡）
                    if (reliableMessageOutDTO.getResendTimes() >= reliableMessageOutDTO.getSubscribeTimes()) {
                        List<Integer> retryStrategyList = DragonJsonUtil.readList(reliableMessageOutDTO.getRetryStrategy(), Integer.class);
                        if (reliableMessageOutDTO.getResendTimes() < reliableMessageOutDTOList.size()) {
                            nextTimeSeconds = retryStrategyList.get(reliableMessageOutDTO.getResendTimes());
                        } else {
                            Long seconds = DragonLocalDateTimeUtil.getSecond(reliableMessageOutDTO.getNextExeTime()) -
                                    DragonLocalDateTimeUtil.getSecond(reliableMessageOutDTO.getLastSubscribeTime());
                            nextTimeSeconds = Math.toIntExact((reliableMessageOutDTO.getResendTimes() -
                                    reliableMessageOutDTO.getSubscribeTimes()) * seconds);
                        }
                    }

                    if (null == nextTimeSeconds) {
                        //解决 DateTime 到秒级的并发问题
                        nextTimeSeconds = 10;
                    }
                }

                int count = dragonRabbitReliableMessageDao.update4ResendMessage(reliableMessageOutDTO.getId(),
                        reliableMessageOutDTO.getUpdateTime(), nextTimeSeconds);
                if (count > 0) {
                    //发送可靠消息
                    DragonRabbitReliableMessageExternalOutDTO reliableMessageExternalOutDTO = dragonRabbitReliableMessageExternalDao.getById(reliableMessageOutDTO.getId());
                    DragonRabbitBaseMessage rabbitBaseMessage = (DragonRabbitBaseMessage) DragonJsonUtil.parse(
                            reliableMessageExternalOutDTO.getMessageContent(), Class.forName(reliableMessageOutDTO.getMessageClassName()));

                    DragonRabbitReliableMessage reliableMessage = DragonJsonUtil.copy(reliableMessageOutDTO, DragonRabbitReliableMessage.class);
                    rabbitBaseMessage.setReliableMessage(reliableMessage);
                    rabbitTemplate.convertAndSend(reliableMessage.getPublishExchange(), reliableMessage.getPublishRoutingKey(), rabbitBaseMessage);
                }
            }
        }
    }

}
