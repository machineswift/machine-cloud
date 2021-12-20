package com.machine.dragon.service.system.department.resource;

import com.machine.dragon.common.tool.jackson.DragonJsonUtil;
import com.machine.dragon.service.system.department.resource.outvo.DragonDepartmentDetailOutVO;
import com.machine.dragon.service.system.department.service.DragonDepartmentService;
import com.machine.dragon.service.system.department.service.outbo.DragonDepartmentDetailOutBO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RefreshScope
@RestController
@RequestMapping("client/system/department")
public class DragonDepartmentResourceImpl implements DragonDepartmentResource {

    @Autowired
    private DragonDepartmentService dragonDepartmentService;

    @Override
    @GetMapping("getByDepartmentId")
    public DragonDepartmentDetailOutVO getByDepartmentId(Long departmentId) {
        DragonDepartmentDetailOutBO detailOutBo = dragonDepartmentService.getByDepartmentId(departmentId);
        return DragonJsonUtil.copy(detailOutBo, DragonDepartmentDetailOutVO.class);
    }
}
