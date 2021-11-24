package com.machine.dragon.service.system.department.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.machine.dragon.service.system.department.mapper.entity.DragonDepartmentEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DragonDepartmentMapper extends BaseMapper<DragonDepartmentEntity> {

    DragonDepartmentEntity selectByDepartmentId(@Param("departmentId") Long departmentId);
}
