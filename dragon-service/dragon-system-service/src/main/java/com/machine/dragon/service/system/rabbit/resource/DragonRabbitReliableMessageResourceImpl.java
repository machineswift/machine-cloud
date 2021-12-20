package com.machine.dragon.service.system.rabbit.resource;

import com.machine.dragon.common.core.bean.rabbit.DragonRabbitReliableMessage;
import com.machine.dragon.common.tool.jackson.DragonJsonUtil;
import com.machine.dragon.service.system.rabbit.resource.invo.DragonRabbitReliableMessageInitInVO;
import com.machine.dragon.service.system.rabbit.resource.invo.DragonRabbitReliableMessageUpdate4SubscribeInVO;
import com.machine.dragon.service.system.rabbit.service.DragonRabbitReliableMessageService;
import com.machine.dragon.service.system.rabbit.service.inbo.DragonRabbitReliableMessageInitInBO;
import com.machine.dragon.service.system.rabbit.service.inbo.DragonRabbitReliableMessageUpdate4SubscribeInBO;
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
public class DragonRabbitReliableMessageResourceImpl implements DragonRabbitReliableMessageResource {

    @Autowired
    private DragonRabbitReliableMessageService dragonRabbitReliableMessageService;

    @Override
    @PostMapping("init")
    public String init(DragonRabbitReliableMessageInitInVO inVo) {
        log.info("初始化可靠消息 inVo:{}", DragonJsonUtil.toJson(inVo));
        return dragonRabbitReliableMessageService.init(DragonJsonUtil.copy(inVo, DragonRabbitReliableMessageInitInBO.class));
    }

    @Override
    @GetMapping("deleteById")
    public void deleteById(String id) {
        log.info("删除可靠消息 id:{}", id);
        dragonRabbitReliableMessageService.deleteById(id);
    }

    @Override
    @GetMapping("deadById")
    public void deadById(String id) {
        log.info("添加死亡消息 id:{}", id);
        dragonRabbitReliableMessageService.deadById(id);
    }

    @Override
    @PostMapping("update4Subscribe")
    public void update4Subscribe(DragonRabbitReliableMessageUpdate4SubscribeInVO inVo) {
        log.info("修改可靠消息消费状态 inVo:{}", DragonJsonUtil.toJson(inVo));
        //修改可靠消息的状态
        dragonRabbitReliableMessageService.update4Subscribe(
                DragonJsonUtil.copy(inVo, DragonRabbitReliableMessageUpdate4SubscribeInBO.class));
    }

    @Override
    @GetMapping("getById")
    public DragonRabbitReliableMessage getById(String id) {
        return dragonRabbitReliableMessageService.getById(id);
    }

    @Override
    @GetMapping("resendMessage")
    public void resendMessage() {
        log.info("定时任务重新发送可靠消息");
        dragonRabbitReliableMessageService.resendMessage();
    }
}


