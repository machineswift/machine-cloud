package com.machine.dragon.service.system.tenant.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.machine.dragon.service.system.tenant.feign.query.DragonTenantPageQuery;
import com.machine.dragon.service.system.tenant.mapper.entity.DragonTenantEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DragonTenantMapper extends BaseMapper<DragonTenantEntity> {

    DragonTenantEntity selectByTenantId(@Param("tenantId") Integer tenantId);

    IPage<DragonTenantEntity> selectTenantPage(IPage<DragonTenantEntity> page,
                                              @Param("query") DragonTenantPageQuery query);
}
