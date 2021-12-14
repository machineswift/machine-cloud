package com.machine.dragon.common.core.envm.tenant;

import com.machine.dragon.common.core.envm.DragonBaseEnum;
import lombok.Getter;

@Getter
public enum DragonTenantStatusEnum implements DragonBaseEnum<DragonTenantStatusEnum, Integer> {
    DISABLE(0, "禁用"),

    ENABLE(1, "启用");


    private final Integer code;
    private final String name;

    DragonTenantStatusEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }
}
