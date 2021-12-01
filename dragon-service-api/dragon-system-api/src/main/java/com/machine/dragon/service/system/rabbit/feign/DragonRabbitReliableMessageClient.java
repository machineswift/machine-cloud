package com.machine.dragon.service.system.rabbit.feign;

import com.machine.dragon.common.core.bean.rabbit.DragonRabbitReliableMessage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "dragon-system-service", path = "client/system/rabbitReliableMessage")
public interface DragonRabbitReliableMessageClient {

    @PostMapping("init")
    String init(@RequestBody DragonRabbitReliableMessage reliableMessage);

    @GetMapping("deleteById")
    void deleteById(@RequestParam(name = "id") String id);

    @GetMapping("deadById")
    void deadById(@RequestParam(name = "id") String id);

    @PostMapping("updateSubscribeInfo")
    void updateSubscribeInfo(@RequestBody DragonRabbitReliableMessage reliableMessage);

    @GetMapping("getById")
    DragonRabbitReliableMessage getById(@RequestParam(name = "id") String id);
}
