package com.machine.dragon.service.crm.customer.resource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DragonCustomerResourceFallBack implements DragonCustomerResource {

    @Override
    public String detail() {
        log.error("查询客户明细异常");
        return "machine-failBack";
    }
}
