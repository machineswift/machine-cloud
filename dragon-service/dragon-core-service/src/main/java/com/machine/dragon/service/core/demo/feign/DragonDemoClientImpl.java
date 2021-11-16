package com.machine.dragon.service.core.demo.feign;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RefreshScope
@RestController
@RequestMapping("demo")
public class DragonDemoClientImpl implements IDragonCoreClient {

    @Value("${machine}")
    private String machine;

    @Override
    @GetMapping("detail")
    public String detail() {
        String helloWorld = "Hello world! " + machine;
        log.info(helloWorld);
        return helloWorld;
    }
}
