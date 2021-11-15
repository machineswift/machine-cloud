package com.machine.dragon.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RefreshScope
@RestController
@RequestMapping("demo")
public class DragonDemoController {

    @Value("${machine}")
    private String machine;

    @Value("${machine1}")
    private String machine1;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("detail")
    public String detail() {
        String helloWorld = restTemplate.getForObject("http://dragon-core/core/detail", String.class);
        log.info(helloWorld + machine + machine1);
        return helloWorld;
    }
}
