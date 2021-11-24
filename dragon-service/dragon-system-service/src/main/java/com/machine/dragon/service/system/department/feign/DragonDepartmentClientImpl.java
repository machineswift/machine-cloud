package com.machine.dragon.service.system.department.feign;

import com.machine.dragon.common.tool.convert.DragonConvertUtil;
import com.machine.dragon.service.system.department.feign.outVo.DragonDepartmentDetailOutVo;
import com.machine.dragon.service.system.department.service.DragonDepartmentService;
import com.machine.dragon.service.system.department.service.outBo.DragonDepartmentDetailOutBo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RefreshScope
@RestController
@RequestMapping("client/system/department")
public class DragonDepartmentClientImpl implements DragonDepartmentClient {

    @Value("${machine}")
    private String machine;

    @Autowired
    private DragonDepartmentService dragonDepartmentService;

    @Override
    @GetMapping("getByDepartmentId")
    public DragonDepartmentDetailOutVo getByDepartmentId(Long departmentId) {
        DragonDepartmentDetailOutBo detailOutBo = dragonDepartmentService.getByDepartmentId(departmentId);
        if (null == detailOutBo) {
            return null;
        }
        return DragonConvertUtil.convert(detailOutBo, DragonDepartmentDetailOutVo.class);
    }
}
