package com.machine.dragon.server.isc.xxljob.jobhandler.rabbit;

import com.machine.dragon.service.system.rabbit.feign.DragonRabbitReliableMessageClient;
import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitReliableMessageXxlJob {

    @Autowired
    private DragonRabbitReliableMessageClient dragonRabbitReliableMessageClient;

    @XxlJob("rabbitReliableMessageJobHandler")
    public void rabbitReliableMessageJobHandler() {
        XxlJobHelper.log("XXL-JOB,可靠消息 start .....");
        try {
            dragonRabbitReliableMessageClient.resendMessage();
        } catch (Exception e) {
            XxlJobHelper.log(e);
            XxlJobHelper.handleFail("XXL-JOB,可靠消息 fail:" + e.getMessage());
        }
        XxlJobHelper.log("XXL-JOB,可靠消息 end .....");
    }
}
