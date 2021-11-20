package com.machine.dragon.service.psm.coupon.feign;

import com.machine.dragon.common.launch.constant.DragonAppConstant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = DragonAppConstant.APPLICATION_PSM_NAME, path = "client/coupon")
public interface DragonCouponClient {

    @GetMapping("detail")
    String detail();

}
