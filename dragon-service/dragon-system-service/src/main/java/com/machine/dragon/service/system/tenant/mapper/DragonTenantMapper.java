package com.machine.dragon.service.system.tenant.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.machine.dragon.service.system.tenant.mapper.entity.DragonTenantEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DragonTenantMapper extends BaseMapper<DragonTenantEntity> {

    DragonTenantEntity selectByTenantId(@Param("tenantId") Integer tenantId);
}
