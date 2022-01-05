package com.machine.dragon.common.core.envm;

public interface DragonBaseEnum<E extends Enum<E>, T> {

    Integer getCode();

    String getMsg();

    /**
     * 根据Code获取对应IBaseEnum实例
     *
     * @param clazz 枚举类
     * @param code  编码
     * @param <T>   枚举类
     * @return 枚举类实例
     */
    static <T extends Enum<T>> T getInstance(Class<T> clazz, Integer code) {
        if (!clazz.isEnum() || !DragonBaseEnum.class.isAssignableFrom(clazz)) {
            throw new IllegalArgumentException("未知的枚举编码：" + code);
        }
        T[] enumConstants = clazz.getEnumConstants();
        if (enumConstants != null) {
            for (T enumConstant : enumConstants) {
                DragonBaseEnum<?, ?> baseEnum = (DragonBaseEnum<?, ?>) enumConstant;
                if (baseEnum.getCode().equals(code)) {
                    return enumConstant;
                }
            }
        }
        throw new IllegalArgumentException("未知的枚举编码：" + code);
    }
}
