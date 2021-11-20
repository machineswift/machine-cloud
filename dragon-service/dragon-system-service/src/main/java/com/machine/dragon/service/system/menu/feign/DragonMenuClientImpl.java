package com.machine.dragon.service.system.menu.feign;

import com.machine.dragon.service.oms.menu.feign.DragonMenuClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RefreshScope
@RestController
@RequestMapping("client/menu")
public class DragonMenuClientImpl implements DragonMenuClient {

    @Value("${machine}")
    private String machine;

    @Override
    @GetMapping("detail")
    public String detail() {
        String menu = "menu " + machine;
        log.info(menu);
        return menu;
    }
}
