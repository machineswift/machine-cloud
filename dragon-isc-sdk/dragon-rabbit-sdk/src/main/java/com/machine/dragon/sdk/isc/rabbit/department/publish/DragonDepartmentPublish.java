package com.machine.dragon.sdk.isc.rabbit.department.publish;

import com.machine.dragon.sdk.isc.rabbit.config.aspect.DragonRabbitPublishAnnotation;
import com.machine.dragon.sdk.isc.rabbit.department.config.DragonDepartmentRabbitConfig;
import com.machine.dragon.sdk.isc.rabbit.department.message.DragonDepartmentRabbitMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DragonDepartmentPublish {

    @DragonRabbitPublishAnnotation(producerName = "部门",
            routingKey = DragonDepartmentRabbitConfig.DRAGON_DEPARTMENT_ROUTINE_KEY)
    public void publishDragonDepartmentRabbitMessage(DragonDepartmentRabbitMessage rabbitMessage) {
    }

}
