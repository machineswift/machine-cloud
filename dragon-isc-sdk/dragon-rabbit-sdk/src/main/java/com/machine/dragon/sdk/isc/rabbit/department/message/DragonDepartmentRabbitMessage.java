package com.machine.dragon.sdk.isc.rabbit.department.message;

import com.machine.dragon.sdk.isc.rabbit.config.DragonRabbitBaseMessage;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DragonDepartmentRabbitMessage extends DragonRabbitBaseMessage {

    public DragonDepartmentRabbitMessage(Long departmentId) {
        this.departmentId = departmentId;
    }

    private Long departmentId;
}
