package com.machine.dragon.service.system.rabbit.feign;

import com.machine.dragon.common.core.bean.rabbit.DragonRabbitReliableMessage;
import com.machine.dragon.common.tool.jackson.DragonJsonUtil;
import com.machine.dragon.service.system.rabbit.feign.invo.DragonRabbitReliableMessageInitInVo;
import com.machine.dragon.service.system.rabbit.feign.invo.DragonRabbitReliableMessageUpdate4SubscribeInVo;
import com.machine.dragon.service.system.rabbit.service.DragonRabbitReliableMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RefreshScope
@RestController
@RequestMapping("client/system/rabbitReliableMessage")
public class DragonRabbitReliableMessageClientImpl implements DragonRabbitReliableMessageClient {

    @Autowired
    private DragonRabbitReliableMessageService dragonRabbitReliableMessageService;

    @Override
    @PostMapping("init")
    public String init(DragonRabbitReliableMessageInitInVo inVo) {
        log.info("初始化可靠消息 inVo:{}", DragonJsonUtil.toJson(inVo));
        deleteByMessageKey(inVo.getMessageKey());
        return null;
    }

    @Override
    @GetMapping("deleteById")
    public void deleteById(String id) {
        log.info("删除可靠消息 id:{}", id);
        dragonRabbitReliableMessageService.deleteById(id);
    }

    @Override
    public void deleteByMessageKey(String messageKey) {
        log.info("删除可靠消息 messageKey:{}", messageKey);
        dragonRabbitReliableMessageService.deleteByMessageKey(messageKey);
    }

    @Override
    @GetMapping("deadById")
    public void deadById(String id) {
        log.info("添加死亡消息 id:{}", id);

    }

    @Override
    @PostMapping("update4Subscribe")
    public void update4Subscribe(DragonRabbitReliableMessageUpdate4SubscribeInVo inVo) {

    }

    @Override
    @GetMapping("getById")
    public DragonRabbitReliableMessage getById(String id) {
        return null;
    }
}
