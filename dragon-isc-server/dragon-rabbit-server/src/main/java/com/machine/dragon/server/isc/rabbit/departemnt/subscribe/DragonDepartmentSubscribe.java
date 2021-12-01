package com.machine.dragon.server.isc.rabbit.departemnt.subscribe;

import com.machine.dragon.common.tool.jackson.DragonJsonUtil;
import com.machine.dragon.sdk.isc.rabbit.department.config.DragonDepartmentRabbitConfig;
import com.machine.dragon.sdk.isc.rabbit.department.message.DragonDepartmentRabbitMessage;
import com.machine.dragon.server.isc.rabbit.config.DragonRabbitServerConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DragonDepartmentSubscribe {

    //@MessageReliableAnnotation(consumerName = "粉丝数据转化为客户数据")
    @RabbitListener(queues = DragonDepartmentRabbitConfig.DRAGON_DEPARTMENT_QUEUE,
            containerFactory = DragonRabbitServerConfig.LISTENER_4_HIGH_DELAY)
    public void convertWxMpUser2Customer(DragonDepartmentRabbitMessage rabbitMessage) {
        log.info("-----------:{}",DragonJsonUtil.toJson(rabbitMessage));
    }

}
