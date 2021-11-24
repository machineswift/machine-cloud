package com.machine.dragon.service.system.department.dao.impl;

import com.machine.dragon.common.tool.convert.DragonConvertUtil;
import com.machine.dragon.service.system.department.dao.DragonDepartmentDao;
import com.machine.dragon.service.system.department.dao.outdto.DragonDepartmentOutDto;
import com.machine.dragon.service.system.department.mapper.DragonDepartmentMapper;
import com.machine.dragon.service.system.department.mapper.entity.DragonDepartmentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DragonDepartmentDaoImpl implements DragonDepartmentDao {

    @Autowired
    private DragonDepartmentMapper dragonDepartmentMapper;

    @Override
    public DragonDepartmentOutDto getByDepartmentId(Long departmentId) {
        DragonDepartmentEntity entity = dragonDepartmentMapper.selectByDepartmentId(departmentId);
        if (null == entity) {
            return null;
        }
        return DragonConvertUtil.convert(entity, DragonDepartmentOutDto.class);
    }
}
