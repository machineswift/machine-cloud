package com.machine.dragon.starter.mybatis.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

@Component
public class DragonMetaObjectHandler implements MetaObjectHandler {
    /**
     * 使用mp实现添加操作,这个方法会执行
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        //根据名称设置属性值
        Long currentTimeMillis = System.currentTimeMillis();
        this.setFieldValByName("createTime", currentTimeMillis, metaObject);
        this.setFieldValByName("updateTime", currentTimeMillis, metaObject);
    }

    /**
     * 使用mp实现修改操作,这个方法会执行
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime", System.currentTimeMillis(), metaObject);
    }
}
