package com.machine.dragon.service.system.role.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.machine.dragon.service.system.role.mapper.entity.DragonRoleEntity;
import com.machine.dragon.service.system.role.resource.query.DragonRolePageQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DragonRoleMapper extends BaseMapper<DragonRoleEntity> {

    DragonRoleEntity selectByRoleId(@Param("roleId") Long roleId);

    List<DragonRoleEntity> selectRoleList();
    
    IPage<DragonRoleEntity> selectRolePage(Page<DragonRoleEntity> page,
                                               @Param("query") DragonRolePageQuery query);
}
