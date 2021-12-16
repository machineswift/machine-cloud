package com.machine.dragon.web.system.department.fade;

import com.machine.dragon.web.system.department.controller.response.DragonDepartmentDetailResponse;

public interface DragonDepartmentFade {
    DragonDepartmentDetailResponse queryDepartmentDetail(Long departmentId);
}
