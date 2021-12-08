package com.machine.dragon.service.system.database.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDateTime;

@Mapper
public interface DragonDataBaseMapper {
    LocalDateTime getCurrentDateTime();
}
