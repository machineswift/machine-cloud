package com.machine.dragon.service.system.rabbit.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.machine.dragon.service.system.rabbit.dao.indto.DragonRabbitReliableMessageUpdate4SubscribeInDto;
import com.machine.dragon.service.system.rabbit.mapper.entity.DragonRabbitReliableMessageEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DragonRabbitReliableMessageMapper extends BaseMapper<DragonRabbitReliableMessageEntity> {

    int deleteByMessageKey(@Param("messageKey") String messageKey);

    int deadById(@Param("id") String id);

    int update4Subscribe(@Param("inDto") DragonRabbitReliableMessageUpdate4SubscribeInDto inDto);
}
