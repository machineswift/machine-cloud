package com.machine.dragon.service.system.rabbit.resource;

import com.machine.dragon.common.core.bean.rabbit.DragonRabbitReliableMessage;
import com.machine.dragon.service.system.rabbit.resource.invo.DragonRabbitReliableMessageInitInVO;
import com.machine.dragon.service.system.rabbit.resource.invo.DragonRabbitReliableMessageUpdate4SubscribeInVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "dragon-system-service", path = "rabbitReliableMessage")
public interface DragonRabbitReliableMessageResource {

    @PostMapping("init")
    String init(@RequestBody DragonRabbitReliableMessageInitInVO inVo);

    @GetMapping("deleteById")
    void deleteById(@RequestParam(name = "id") String id);

    @GetMapping("deadById")
    void deadById(@RequestParam(name = "id") String id);

    @PostMapping("update4Subscribe")
    void update4Subscribe(@RequestBody DragonRabbitReliableMessageUpdate4SubscribeInVO inVo);

    @GetMapping("getById")
    DragonRabbitReliableMessage getById(@RequestParam(name = "id") String id);

    @GetMapping("resendMessage")
    void resendMessage();
}
