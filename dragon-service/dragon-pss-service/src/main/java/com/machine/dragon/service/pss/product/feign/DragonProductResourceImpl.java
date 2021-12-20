package com.machine.dragon.service.pss.product.feign;

import com.machine.dragon.service.pss.product.resource.DragonProductResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RefreshScope
@RestController
@RequestMapping("client/pss/product")
public class DragonProductResourceImpl implements DragonProductResource {

    @Override
    @GetMapping("detail")
    public String detail() {
        String product = "product";
        log.info(product);
        return product;
    }
}
