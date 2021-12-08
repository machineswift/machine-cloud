package com.machine.dragon.service.system.rabbit.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.machine.dragon.service.system.rabbit.dao.indto.DragonRabbitReliableMessageUpdate4SubscribeInDTO;
import com.machine.dragon.service.system.rabbit.mapper.entity.DragonRabbitReliableMessageEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface DragonRabbitReliableMessageMapper extends BaseMapper<DragonRabbitReliableMessageEntity> {

    int deleteByMessageKey(@Param("messageKey") String messageKey);

    int deadById(@Param("id") String id);

    int update4Subscribe(@Param("inDto") DragonRabbitReliableMessageUpdate4SubscribeInDTO inDto);

    int update4ResendMessage(@Param("id") String id,
                             @Param("updateTime") LocalDateTime updateTime,
                             @Param("nextTimeSeconds") Integer nextTimeSeconds);

    List<DragonRabbitReliableMessageEntity> selectByCurrentDateTime(@Param("dateTime") LocalDateTime dateTime);

}
