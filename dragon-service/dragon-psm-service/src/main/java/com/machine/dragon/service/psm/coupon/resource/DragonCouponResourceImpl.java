package com.machine.dragon.service.psm.coupon.resource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RefreshScope
@RestController
@RequestMapping("client/psm/coupon")
public class DragonCouponResourceImpl implements DragonCouponResource {

    @Override
    @GetMapping("detail")
    public String detail() {
        String coupon = "coupon";
        log.info(coupon);
        return coupon;
    }
}
