package com.machine.dragon.common.core.envm;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DragonGenderEnum implements DragonBaseEnum<DragonGenderEnum, Integer> {
    UNDEFINED(0, "未知"),
    MALE(1, "男"),
    FEMALE(2, "女");

    private final Integer code;
    private final String msg;
}
