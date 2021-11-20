package com.machine.dragon.service.oms.order.feign;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RefreshScope
@RestController
@RequestMapping("client/order")
public class DragonOrderClientImpl implements DragonOrderClient {

    @Value("${machine}")
    private String machine;

    @Override
    @GetMapping("detail")
    public String detail() {
        String order = "order " + machine;
        log.info(order);
        return order;
    }
}
