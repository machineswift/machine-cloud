package com.machine.dragon.service.system.database.mapper;

import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface DragonDataBaseMapper {
    Long currentTimeMillis();
}
