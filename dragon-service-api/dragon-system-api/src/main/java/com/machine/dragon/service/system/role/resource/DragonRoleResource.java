package com.machine.dragon.service.system.role.resource;

import com.machine.dragon.common.core.bean.page.DragonPage;
import com.machine.dragon.service.system.role.resource.outvo.DragonRoleDetailOutVO;
import com.machine.dragon.service.system.role.resource.outvo.DragonRoleListOutVO;
import com.machine.dragon.service.system.role.resource.query.DragonRolePageQuery;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "dragon-system-service", path = "role")
public interface DragonRoleResource {

    @GetMapping("getByRoleId")
    DragonRoleDetailOutVO getByRoleId(@RequestParam(name = "roleId") Long roleId);

    @PostMapping("selectRolePage")
    DragonPage<DragonRoleListOutVO> selectRolePage(@RequestBody DragonRolePageQuery query);
}
