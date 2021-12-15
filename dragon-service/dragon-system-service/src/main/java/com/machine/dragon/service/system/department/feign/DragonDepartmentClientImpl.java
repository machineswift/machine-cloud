package com.machine.dragon.service.system.department.feign;

import com.machine.dragon.common.tool.jackson.DragonJsonUtil;
import com.machine.dragon.service.system.department.feign.outvo.DragonDepartmentDetailOutVO;
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
public class DragonDepartmentClientImpl implements DragonDepartmentClient {

    @Autowired
    private DragonDepartmentService dragonDepartmentService;

    @Override
    @GetMapping("getByDepartmentId")
    public DragonDepartmentDetailOutVO getByDepartmentId(Long departmentId) {
        DragonDepartmentDetailOutBO detailOutBo = dragonDepartmentService.getByDepartmentId(departmentId);
        if (null == detailOutBo) {
            return null;
        }
        return DragonJsonUtil.copy(detailOutBo, DragonDepartmentDetailOutVO.class);
    }
}
