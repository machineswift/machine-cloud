package com.machine.dragon.web.system.dictionary.fade.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.lang.ClassScanner;
import com.machine.dragon.common.core.envm.DragonBaseEnum;
import com.machine.dragon.web.system.dictionary.controller.request.DragonEnumResponse;
import com.machine.dragon.web.system.dictionary.fade.DragonEnumFade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.*;

@Slf4j
@Component
public class DragonEnumFadeImpl implements DragonEnumFade, InitializingBean {

    private final String ENUM_BASE_PACKAGE = "com.machine.dragon.common.core.envm";

    private final Map<String, List<DragonEnumResponse>> ENUM_MAP = new HashMap<>();

    @Override
    public List<DragonEnumResponse> queryEnumList(String enumName) {
        List<DragonEnumResponse> responseList = ENUM_MAP.get(enumName);
        if (CollectionUtil.isEmpty(responseList)) {
            return ListUtil.empty();
        }
        return responseList;
    }

    @Override
    public void afterPropertiesSet() {
        Set<Class<?>> enumClassSet = ClassScanner.scanPackage(ENUM_BASE_PACKAGE);
        for (Class<?> clazz : enumClassSet) {
            if (clazz.isInterface()) {
                continue;
            }
            List<DragonEnumResponse> responseList = new ArrayList<>();
            DragonBaseEnum<?, Integer>[] enums = (DragonBaseEnum<?, Integer>[]) clazz.getEnumConstants();
            for (DragonBaseEnum<?, Integer> e : enums) {
                DragonEnumResponse response = new DragonEnumResponse();
                response.setCode(e.getCode());
                response.setMsg(e.getMsg());
                response.setName(e.toString());
                responseList.add(response);
            }
            ENUM_MAP.put(clazz.getSimpleName(), responseList);
        }
    }
}
