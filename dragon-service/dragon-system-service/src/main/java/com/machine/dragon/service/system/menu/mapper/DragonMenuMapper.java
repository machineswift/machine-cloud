package com.machine.dragon.service.system.menu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.machine.dragon.service.system.menu.mapper.entity.DragonMenuEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DragonMenuMapper extends BaseMapper<DragonMenuEntity> {

    DragonMenuEntity selectByMenuId(@Param("menuId") Long menuId);

    List<DragonMenuEntity> selectMenuList();
}
