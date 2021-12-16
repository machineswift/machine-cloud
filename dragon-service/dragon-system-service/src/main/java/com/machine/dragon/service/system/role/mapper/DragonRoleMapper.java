package com.machine.dragon.service.system.role.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.machine.dragon.service.system.role.mapper.entity.DragonRoleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DragonRoleMapper extends BaseMapper<DragonRoleEntity> {

    DragonRoleEntity selectByRoleId(@Param("roleId") Long roleId);
}
