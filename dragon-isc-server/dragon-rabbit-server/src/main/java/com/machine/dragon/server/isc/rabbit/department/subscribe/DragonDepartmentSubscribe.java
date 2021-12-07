package com.machine.dragon.server.isc.rabbit.department.subscribe;

import com.machine.dragon.common.tool.jackson.DragonJsonUtil;
import com.machine.dragon.sdk.isc.rabbit.department.config.DragonDepartmentRabbitConfig;
import com.machine.dragon.sdk.isc.rabbit.department.message.DragonDepartmentRabbitMessage;
import com.machine.dragon.server.isc.rabbit.config.DragonRabbitServerConfig;
import com.machine.dragon.server.isc.rabbit.config.aspect.DragonRabbitReliableMessageAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DragonDepartmentSubscribe {

    @DragonRabbitReliableMessageAnnotation(publishName = "部门", retryStrategy = {5, 30, 300, 1800, 3600, 7200},
            uniqueKeyFields = {"departmentId"}, maxResendTimes = 10)
    @RabbitListener(queues = DragonDepartmentRabbitConfig.DRAGON_DEPARTMENT_QUEUE,
            containerFactory = DragonRabbitServerConfig.LISTENER_4_HIGH_DELAY)
    public void convertWxMpUser2Customer(DragonDepartmentRabbitMessage rabbitMessage) {
        String ss = null;
        ss.length();
        log.info("-----------:{}", DragonJsonUtil.toJson(rabbitMessage));
    }

}
