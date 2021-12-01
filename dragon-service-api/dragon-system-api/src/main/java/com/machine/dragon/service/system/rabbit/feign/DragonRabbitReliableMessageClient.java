package com.machine.dragon.service.system.rabbit.feign;

import com.machine.dragon.common.core.bean.rabbit.DragonRabbitReliableMessage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "dragon-system-service", path = "client/system/rabbitReliableMessage")
public interface DragonRabbitReliableMessageClient {

    @GetMapping("deleteById")
    void deleteById(@RequestParam(name = "id") String id);

    @GetMapping("getById")
    DragonRabbitReliableMessage getById(@RequestParam(name = "id") String id);

}
