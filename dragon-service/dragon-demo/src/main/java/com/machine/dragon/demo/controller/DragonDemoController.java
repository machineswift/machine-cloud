package com.machine.dragon.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@RequestMapping("demo")
public class DragonDemoController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("detail")
    public String detail() {
        String helloWorld = restTemplate.getForObject("http://dragon-core/core/detail", String.class);
        //String helloWorld = restTemplate.getForObject("http://localhost:8080/core/detail", String.class);
        log.info(helloWorld);
        return helloWorld;
    }
}
