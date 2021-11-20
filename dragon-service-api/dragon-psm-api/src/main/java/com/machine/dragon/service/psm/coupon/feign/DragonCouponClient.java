package com.machine.dragon.service.psm.coupon.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "dragon-psm-service", path = "client/psm/coupon")
public interface DragonCouponClient {

    @GetMapping("detail")
    String detail();

}
