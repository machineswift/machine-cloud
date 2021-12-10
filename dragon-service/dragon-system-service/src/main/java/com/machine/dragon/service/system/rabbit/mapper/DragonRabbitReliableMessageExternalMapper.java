package com.machine.dragon.service.system.rabbit.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.machine.dragon.service.system.rabbit.mapper.entity.DragonRabbitReliableMessageExternalEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DragonRabbitReliableMessageExternalMapper extends BaseMapper<DragonRabbitReliableMessageExternalEntity> {

    int deadById(@Param("id") String id);

}
