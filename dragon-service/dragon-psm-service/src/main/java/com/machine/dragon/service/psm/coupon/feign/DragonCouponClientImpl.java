package com.machine.dragon.service.psm.coupon.feign;

import com.machine.dragon.service.psm.coupon.feign.DragonCouponClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RefreshScope
@RestController
@RequestMapping("client/psm/coupon")
public class DragonCouponClientImpl implements DragonCouponClient {

    @Value("${machine}")
    private String machine;

    @Override
    @GetMapping("detail")
    public String detail() {
        String coupon = "coupon " + machine;
        log.info(coupon);
        return coupon;
    }
}
